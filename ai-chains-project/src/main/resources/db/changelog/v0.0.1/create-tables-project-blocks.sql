-- liquibase formatted sql

-- Notes:
-- Naming convention - see SQL Style Guide: snake_case, lowercase.

-- changeSet kostusonline:07a0f74d-ea9e-514b-b64c-b46ff8203df5 runOnChange:true
CREATE TABLE IF NOT EXISTS "project_blocks" (
    id BIGINT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY,
    "project_id" BIGINT NOT NULL, -- id of the project
    "internal_block_id" VARCHAR(16) NOT NULL CHECK (
        LENGTH("internal_block_id") BETWEEN 1 AND 16
    ), -- internal block id unique within the project; i.e. "1" or "2" or whatever
    "block_type_id" VARCHAR(64) NOT NULL CHECK (
        LENGTH("block_type_id") BETWEEN 4 AND 64
    ), -- block type id; i.e. "chat-gpt" or "project-manager" or whatever
    "default_input_text" VARCHAR(4096) NOT NULL CHECK (
        LENGTH("default_input_text") BETWEEN 4 AND 4096
    ), -- default input text
    FOREIGN KEY (project_id) REFERENCES "projects" (id),
    UNIQUE (project_id, internal_block_id)
);

--changeSet kostusonline:11c2345a-3757-5507-881c-00f5a958e73f runOnChange:true
GRANT ALL ON "project_blocks" TO ai_chains_god;