# Book REST API — SkillPilots Task
Spring Boot REST API with full CRUD operations for Book.

## Requirements
- Java 17+
- Maven 3.6+
- Postman (for API testing)

## Run
Open a terminal in this folder and run:
```bash
mvn spring-boot:run
```
Base URL: `http://localhost:8080`

## Endpoints
| Method | URL | Purpose |
|---|---|---|
| GET | `/api/books` | Get all books |
| GET | `/api/books/{id}` | Get a book by ID |
| POST | `/api/books` | Create a book |
| PUT | `/api/books/{id}` | Update a book |
| DELETE | `/api/books/{id}` | Delete a book |

## JSON body for POST and PUT
```json
{"title":"Wings of Fire","author":"A. P. J. Abdul Kalam","price":250}
```

## curl examples
```bash
curl http://localhost:8080/api/books
curl http://localhost:8080/api/books/1
curl -X POST http://localhost:8080/api/books -H "Content-Type: application/json" -d "{\"title\":\"Wings of Fire\",\"author\":\"A. P. J. Abdul Kalam\",\"price\":250}"
curl -X PUT http://localhost:8080/api/books/1 -H "Content-Type: application/json" -d "{\"title\":\"Ignited Minds\",\"author\":\"A. P. J. Abdul Kalam\",\"price\":300}"
curl -X DELETE http://localhost:8080/api/books/1
```

## Postman testing
1. Run the application.
2. Create a request and choose GET, POST, PUT or DELETE.
3. Enter the endpoint URL above.
4. For POST/PUT choose Body → raw → JSON and paste the sample JSON.
5. Click Send and check the response.

## Implementation notes
- Uses `ResponseEntity` for HTTP responses.
- Uses `@Valid` and Jakarta validation annotations.
- Create returns HTTP 201; delete returns HTTP 204; missing IDs return HTTP 404.
- H2 is an in-memory database, so data resets when the app stops.
