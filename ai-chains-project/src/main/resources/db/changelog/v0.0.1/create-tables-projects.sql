-- liquibase formatted sql

-- Notes:
-- Naming convention - see SQL Style Guide: snake_case, lowercase.

-- Logical structure of the project:
-- 1. Project is a collection of blocks and lines.
-- 2. Blocks are the main entities in the project.
-- 3. Lines are the connections between blocks.
-- 4. Blocks and lines are created and updated by the owner of the project.
-- 5. Blocks and lines are deleted by the owner of the project.
-- 6. Some fields are needed for logging and management.

-- changeSet kostusonline:0e11e97c-3f0d-5d2f-9fff-ccd774406229 runOnChange:true
CREATE TABLE IF NOT EXISTS "projects" (
    id BIGINT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY,
    "created_at" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- creation timestamp
    "updated_at" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- last update timestamp
    "owner_id" BIGINT NOT NULL, -- id of the owner/creator
    "name" VARCHAR(64) UNIQUE NOT NULL CHECK (
        LENGTH("name") BETWEEN 4 AND 64
    ), -- short display name of the project; in logical structure, it is needed for logging
    "status" VARCHAR(20) NOT NULL CHECK (
        LENGTH("status") BETWEEN 1 AND 20
    ) DEFAULT 'READY', -- project status from enum ProjectStatus: READY, EDITING, DELETED, REJECTED etc.
    FOREIGN KEY (owner_id) REFERENCES "users" (id),
    UNIQUE (owner_id, name)
);

--changeSet kostusonline:33c45501-dc60-5176-9f0d-384b51f39c73 runOnChange:true
GRANT ALL ON "projects" TO ai_chains_god;