-- liquibase formatted sql

-- Notes:
-- Naming convention - see SQL Style Guide: snake_case, lowercase.

-- changeSet kostusonline:af96265b-41d7-5d89-b695-cd70ad6061a7 runOnChange:true
CREATE TABLE IF NOT EXISTS "project_lines" (
    id BIGINT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY,
    "project_id" BIGINT NOT NULL, -- id of the project
    "internal_line_id" VARCHAR(16) NOT NULL CHECK (
        LENGTH("internal_line_id") BETWEEN 1 AND 16
    ), -- internal line id unique within the project; i.e. "1" or "2" or whatever
    "block_from_internal_id" VARCHAR(16) NOT NULL CHECK (
        LENGTH("block_from_internal_id") BETWEEN 1 AND 16
    ), -- internal id of the block from
    "block_to_internal_id" VARCHAR(16) NOT NULL CHECK (
        LENGTH("block_to_internal_id") BETWEEN 1 AND 16
    ), -- internal id of the block to
    FOREIGN KEY (project_id) REFERENCES "projects" (id),
    UNIQUE (project_id, internal_line_id)
);

--changeSet kostusonline:944e0ad2-33c5-5372-b384-288fdec717ff runOnChange:true
GRANT ALL ON "project_lines" TO ai_chains_god;