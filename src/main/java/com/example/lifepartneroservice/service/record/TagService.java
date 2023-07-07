package com.example.lifepartneroservice.service.record;

import com.example.lifepartneroservice.entity.record.Tag;

public interface TagService {

    Tag createIfNotExist(String tagName);
}
