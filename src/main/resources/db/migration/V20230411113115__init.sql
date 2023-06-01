CREATE TABLE users
(
    usr_id            SERIAL PRIMARY KEY,
    usr_username      VARCHAR(50) NOT NULL UNIQUE,
    usr_password      VARCHAR(50) NOT NULL,
    usr_enabled       BOOL        NOT NULL,
    usr_date_added    TIMESTAMP DEFAULT NULL,
    usr_date_modified TIMESTAMP DEFAULT NULL
);

CREATE TABLE roles
(
    rol_id            SERIAL PRIMARY KEY,
    rol_name          VARCHAR(255) NOT NULL UNIQUE,
    rol_enabled       BOOL         NOT NULL,
    rol_date_added    TIMESTAMP DEFAULT NULL,
    rol_date_modified TIMESTAMP DEFAULT NULL
);

CREATE TABLE users_roles
(
    urr_usr_id INT NOT NULL,
    urr_rol_id INT NOT NULL,
    PRIMARY KEY (urr_usr_id, urr_rol_id),
    FOREIGN KEY (urr_rol_id)
        REFERENCES roles (rol_id),
    FOREIGN KEY (urr_usr_id)
        REFERENCES users (usr_id)
);

CREATE TABLE records
(
    rec_id            SERIAL PRIMARY KEY,
    rec_name          VARCHAR(50) NOT NULL,
    rec_date_added    TIMESTAMP DEFAULT NULL,
    rec_date_modified TIMESTAMP DEFAULT NULL
);
