package com.example.lifepartneroservice.service.record.impl;

import com.example.lifepartneroservice.entity.record.Link;
import com.example.lifepartneroservice.entity.record.Record;
import com.example.lifepartneroservice.entity.record.Tag;
import com.example.lifepartneroservice.model.record.RecordDto;
import com.example.lifepartneroservice.model.record.TagDto;
import com.example.lifepartneroservice.model.record.converter.RecordConverter;
import com.example.lifepartneroservice.model.record.converter.TagConverter;
import com.example.lifepartneroservice.repository.record.LinkRepository;
import com.example.lifepartneroservice.repository.record.RecordRepository;
import com.example.lifepartneroservice.service.record.TagService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.example.lifepartneroservice.entity.record.RecordType.REVIEW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecordServiceImplTest {

    @Mock
    private RecordRepository recordRepository;

    @Mock
    private LinkRepository linkRepository;

    @Mock
    private TagService tagService;

    @Mock
    private TagConverter tagConverter;

    @Mock
    private RecordConverter recordConverter;

    @InjectMocks
    private RecordServiceImpl testSubject;

    @Test
    public void givenRecordDto_shouldCreateTags_thenSaveRecord_thenCreateLink_thenReturnRecordDto() {
        //given
        var firstTag = Tag.builder()
                .id(1L)
                .name("firstTag")
                .build();
        var secondTag = Tag.builder()
                .id(2L)
                .name("secondTag")
                .build();
        var firstTagDto = new TagDto(firstTag.getId(), firstTag.getName());
        var secondTagDto = new TagDto(0L, secondTag.getName());
        var secondTagDtoChanged = new TagDto(secondTag.getId(), secondTag.getName());
        Set<TagDto> givenTagDtoSet = new HashSet<>();
        givenTagDtoSet.add(firstTagDto);
        givenTagDtoSet.add(secondTagDto);
        var expectedTags = Set.of(firstTagDto, secondTagDtoChanged);

        var record = Record.builder()
                .id(1L)
                .name("testRecord")
                .recordType(REVIEW)
                .text("text")
                .build();
        var givenRecordDto = new RecordDto(
                0,
                record.getName(),
                record.getRecordType(),
                record.getText(),
                givenTagDtoSet
        );
        var expectedRecordDto = new RecordDto(
                record.getId(),
                record.getName(),
                record.getRecordType(),
                record.getText(),
                expectedTags
        );
        var link = Link.builder()
                .record(record)
                .build();

        when(tagService.createIfNotExist(firstTagDto.name())).thenReturn(firstTag);
        when(tagConverter.toDto(firstTag)).thenReturn(firstTagDto);
        when(tagService.createIfNotExist(secondTagDto.name())).thenReturn(secondTag);
        when(tagConverter.toDto(secondTag)).thenReturn(secondTagDtoChanged);

        when(recordConverter.toEntity(givenRecordDto)).thenReturn(record);
        when(recordRepository.save(record)).thenReturn(record);
        when(recordConverter.toDto(record)).thenReturn(expectedRecordDto);

        //when
        var result = testSubject.create(givenRecordDto);

        //then
        verify(tagService, times(2)).createIfNotExist(any());
        verify(tagConverter, times(2)).toDto(any());
        verify(recordConverter, times(1)).toEntity(givenRecordDto);
        verify(recordConverter, times(1)).toDto(record);
        verify(recordRepository, times(1)).save(record);
        verify(linkRepository).save(link);
        assertEquals(givenRecordDto.tags(), expectedTags);
        assertEquals(expectedRecordDto, result);
    }

    @Test
    public void linkExist_shouldSaveRelations() {
        //given
        var recordId = 1L;
        var otherRecordIds = Set.of(2L, 3L);
        var testLink = Link.builder().id(recordId).build();
        var firstOtherLink = Link.builder().id(2L).build();
        var secondOtherLink = Link.builder().id(3L).build();
        var otherLinksSet = Set.of(firstOtherLink, secondOtherLink);

        when(linkRepository.findById(recordId)).thenReturn(Optional.of(testLink));
        when(linkRepository.findAllUniqByIds(otherRecordIds)).thenReturn(otherLinksSet);

        //when
        testSubject.associateWithRecords(recordId, otherRecordIds);

        //then
        verify(linkRepository, times(1)).findById(recordId);
        verify(linkRepository, times(1)).findAllUniqByIds(otherRecordIds);
        verify(linkRepository, times(1)).save(testLink);
    }

    @Test
    public void linkDoesntExist_shouldThrow_IllegalArgumentException() {
        //given
        var recordId = 1L;
        var otherRecordIds = Set.of(2L, 3L);

        when(linkRepository.findById(recordId)).thenReturn(Optional.empty());

        //when
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> testSubject.associateWithRecords(recordId, otherRecordIds)
        );

        //then
        verify(linkRepository, times(1)).findById(recordId);
        assertEquals("Record with id 1 not found.", exception.getMessage());
    }
}
