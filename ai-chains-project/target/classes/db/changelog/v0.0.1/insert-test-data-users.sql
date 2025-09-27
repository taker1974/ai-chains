-- liquibase formatted sql

-- Notes:
-- Naming convention - see SQL Style Guide: snake_case, lowercase.

-- changeSet kostusonline:4c099e88-b4cb-53d8-a109-d6302f0dd23f runOnChange:true
INSERT INTO
    "users" (
        "name",
        "password",
        "first_name",
        "last_name",
        "phone",
        "role"
    )
VALUES (
        'anton@anton.net',
        '$2a$10$dNwSTUHdpy8BEEgtQvWKLuhfh2rNSSJIZRG3PieITjsDPcphmGGoi',
        'Anton',
        'Antonov',
        '+79223334455',
        'ADMIN'
    ),
    (
        'ivan@ivan.da',
        '$2a$10$dNwSTUHdpy8BEEgtQvWKLuhfh2rNSSJIZRG3PieITjsDPcphmGGoi',
        'Ivan',
        'Ivanov',
        '+79223334466',
        'USER'
    );