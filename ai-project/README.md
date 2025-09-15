# AI Chains Diagram API

REST API for managing diagrams with nodes and connections.

## Description

The API allows you to create, save, and delete diagrams. Each diagram contains:

- **Nodes** - primary elements with input and output text, linked to AI entities
- **Lines** - connections between nodes

## Core entities

### Diagram

- `id` (long) - diagram ID
- `name` (string) - short display name of the diagram
- `description` (string) - diagram description
- `nodes` (array) - array of nodes
- `lines` (array) - array of lines

### Node

- `id` (long) - node ID
- `id_ai` (long) - associated AI entity
- `name` (string) - short display name of the node
- `description` (string) - node description
- `text_in` (string) - input text
- `text_out` (string) - output text

### Line

- `id` (long) - line ID
- `id_node_begin` (long) - starting node ID
- `id_node_end` (long) - ending node ID
- `description` (string) - line description

### Error

- `code` (int) - error code
- `message` (string) - short message
- `details` (string) - error details

### DiagramListItem

- `id` (long) - diagram ID
- `name` (string) - short display name of the diagram

## API Endpoints

### GET /templates

Get a list of all diagrams

- **Response**: `[{ id, name }, ...]` (array of list items)
- **Status**: 200 OK

### POST /templates/create

Create a new diagram

- **Request**: `{ name?: string, description?: string }` (optional)
- **Response**: `{ id: long }`
- **Status**: 201 CREATED

### POST /templates/{id}/save

Save a diagram

- **Request**: Full diagram structure
- **Response**: `{ id: long, name: string }`
- **Status**: 200 OK

### DELETE /templates/{id}/delete

Delete a diagram

- **Response**: `{ id: long, name: string }`
- **Status**: 204 NO_CONTENT

## Usage

1. **Create**: POST `/templates/create` → get the new diagram ID
2. **Save**: POST `/templates/{id}/save` → save changes to the diagram
3. **List**: GET `/templates` → view all available diagrams
4. **Delete**: DELETE `/templates/{id}/delete` → delete a diagram

## Error handling

All endpoints return the `Error` entity in case of failure:

- **400** - Bad request
- **404** - Diagram not found
- **500** - Internal server error

## Files

- `api-spec.yml` - OpenAPI 3.0 specification
- `README.md` - this description

## Validation

The specification complies with the OpenAPI 3.0.3 standard and can be used for:

- Client code generation
- Automatic request/response validation
- API documentation
- Testing via Swagger UI
