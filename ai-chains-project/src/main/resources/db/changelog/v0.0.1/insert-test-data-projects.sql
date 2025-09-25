-- liquibase formatted sql

-- Notes:
-- Naming convention - see SQL Style Guide: snake_case, lowercase.

-- changeSet kostusonline:5d8f9a2b-1c4e-4f7a-9b8c-3e2d1a0f9e8d runOnChange:true
INSERT INTO
    "projects" ("owner_id", "name", "status")
VALUES (
        1, -- anton@anton.net
        'AI Content Generator',
        'READY'
    ),
    (
        2, -- ivan@ivan.da
        'Data Processing Pipeline',
        'READY'
    );

-- changeSet kostusonline:6e9f0b3c-2d5f-5g8b-ac9d-4f3e2b1a0g9f runOnChange:true
INSERT INTO
    "project_blocks" (
        "project_id",
        "internal_block_id",
        "block_type_id",
        "default_input_text"
    )
VALUES
    -- Project 1: AI Content Generator (8 blocks)
    (
        1,
        '1',
        'input-reader',
        'Read user requirements and content specifications'
    ),
    (
        1,
        '2',
        'content-analyzer',
        'Analyze existing content and identify patterns'
    ),
    (
        1,
        '3',
        'prompt-generator',
        'Generate AI prompts based on requirements'
    ),
    (
        1,
        '4',
        'chat-gpt',
        'Generate content using ChatGPT API'
    ),
    (
        1,
        '5',
        'content-reviewer',
        'Review generated content for quality'
    ),
    (
        1,
        '6',
        'seo-optimizer',
        'Optimize content for SEO keywords'
    ),
    (
        1,
        '7',
        'format-converter',
        'Convert content to required format'
    ),
    (
        1,
        '8',
        'output-writer',
        'Save final content to target location'
    ),
    -- Project 2: Data Processing Pipeline (7 blocks)
    (
        2,
        '1',
        'data-ingestion',
        'Ingest data from various sources'
    ),
    (
        2,
        '2',
        'data-validator',
        'Validate data quality and structure'
    ),
    (
        2,
        '3',
        'data-transformer',
        'Transform data to required format'
    ),
    (
        2,
        '4',
        'data-enricher',
        'Enrich data with additional information'
    ),
    (
        2,
        '5',
        'data-aggregator',
        'Aggregate data by specified criteria'
    ),
    (
        2,
        '6',
        'data-analyzer',
        'Perform statistical analysis on data'
    ),
    (
        2,
        '7',
        'report-generator',
        'Generate reports and visualizations'
    );

-- changeSet kostusonline:7f0g1c4d-3e6g-6h9c-bd0e-5g4f3c2b1h0g runOnChange:true
INSERT INTO
    "project_lines" (
        "project_id",
        "internal_line_id",
        "block_from_internal_id",
        "block_to_internal_id"
    )
VALUES
    -- Project 1: AI Content Generator connections
    (1, '1', '1', '2'), -- input-reader -> content-analyzer
    (1, '2', '2', '3'), -- content-analyzer -> prompt-generator
    (1, '3', '3', '4'), -- prompt-generator -> chat-gpt
    (1, '4', '4', '5'), -- chat-gpt -> content-reviewer
    (1, '5', '5', '6'), -- content-reviewer -> seo-optimizer
    (1, '6', '6', '7'), -- seo-optimizer -> format-converter
    (1, '7', '7', '8'), -- format-converter -> output-writer
    -- Project 2: Data Processing Pipeline connections
    (2, '1', '1', '2'), -- data-ingestion -> data-validator
    (2, '2', '2', '3'), -- data-validator -> data-transformer
    (2, '3', '3', '4'), -- data-transformer -> data-enricher
    (2, '4', '4', '5'), -- data-enricher -> data-aggregator
    (2, '5', '5', '6'), -- data-aggregator -> data-analyzer
    (2, '6', '6', '7');
-- data-analyzer -> report-generator