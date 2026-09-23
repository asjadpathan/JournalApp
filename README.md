# JournalApp

JournalApp is a simple Spring Boot REST API for managing journal entries in memory.

## Tech Stack

- Java 21
- Spring Boot 4.0.7
- Maven Wrapper (`./mvnw`)

## Project Structure

```text
src/main/java/com/aspn/journalApp
├── JournalApplication.java                 # Spring Boot entry point
├── controller
│   ├── HealthCheck.java                    # Health endpoint
│   └── JournalEntryContrioller.java        # Journal CRUD endpoints
└── entity
    └── JournalEntry.java                   # Journal entry model (id, title, content)
```

## Features

- Health check endpoint
- In-memory journal entry storage using `Map<Long, JournalEntry>`
- CRUD-style endpoints for journal entries (no database persistence)

## API Endpoints

Base path for journal APIs: `/Journal`

### Health

- `GET /health-check`
  - Returns: `"The Endpoint is healthy"`

### Journal Entries

- `GET /Journal`
  - Returns all journal entries

- `POST /Journal`
  - Creates/overwrites an entry by `id`
  - Example body:
    ```json
    {
      "id": 1,
      "title": "My day",
      "content": "Learned Spring Boot basics."
    }
    ```

- `GET /Journal/id/{myId}`
  - Returns the entry for a given id

- `PUT /Journal/id/{myId}`
  - Updates/replaces the entry for a given id

## Build, Run, and Test

From the repository root:

```bash
./mvnw clean test
./mvnw spring-boot:run
```

The application runs on the default Spring Boot port: `8080`.

## Current Limitations

- Data is stored only in memory and is lost on restart.
- No validation, exception handling, authentication, or persistence layer.
- `DELETE` behavior is currently incomplete in `JournalEntryContrioller` and needs route/parameter alignment.

