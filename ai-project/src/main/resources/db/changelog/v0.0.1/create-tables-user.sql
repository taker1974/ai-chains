-- liquibase formatted sql

-- Notes:
-- Naming convention - see SQL Style Guide: snake_case, lowercase.

-- changeSet kostusonline:386352e5-ae04-5e5a-8636-5e739b57a404 runOnChange:true
CREATE TABLE IF NOT EXISTS "user" (
    id BIGINT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY,
    "name" VARCHAR(32) UNIQUE NOT NULL CHECK (
        LENGTH("name") BETWEEN 4 AND 32
    ),
    "password" VARCHAR(256) NOT NULL CHECK (
        LENGTH("password") BETWEEN 8 AND 256
    ),
    "first_name" VARCHAR(16) NOT NULL CHECK (
        LENGTH("first_name") BETWEEN 2 AND 16
    ),
    "last_name" VARCHAR(16) NOT NULL CHECK (
        LENGTH("last_name") BETWEEN 2 AND 16
    ),
    "phone" VARCHAR(16) UNIQUE NOT NULL CHECK (
        LENGTH("phone") BETWEEN 11 AND 16
    ),
    "role" VARCHAR(20) NOT NULL CHECK (
        LENGTH("role") BETWEEN 1 AND 20
    )
);

--changeSet kostusonline:0a0be85b-ade8-5034-88ef-c7601adc2dd9 runOnChange:true
GRANT ALL ON "user" TO ai_chains_god;