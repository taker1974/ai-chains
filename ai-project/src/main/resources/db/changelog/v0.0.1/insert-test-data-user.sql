-- liquibase formatted sql

-- changeSet kostusonline:96e061da-697d-5af0-822e-032905077181 runOnChange:true
INSERT INTO
    "user" (
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