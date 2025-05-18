# E-Commerce Application with Polyglot Persistence

This is an e-commerce application that demonstrates the use of polyglot persistence, utilizing both PostgreSQL and MongoDB for different aspects of the data model.

## Technologies Used

- Java 17 (Amazon Corretto)
- Spring Boot
- PostgreSQL (for User and Order management)
- MongoDB (for Product and Review management)
- Docker & Docker Compose
- OpenAPI/Swagger for API documentation

## Data Model

### PostgreSQL Entities
- Users: Customer information and profiles
- Orders: Order management and tracking

### MongoDB Documents
- Products: Product catalog and inventory
- Reviews: Product reviews and ratings

## Prerequisites

- Docker and Docker Compose
- Java 17 or later
- Maven

## Getting Started

1. Clone the repository:
```bash
git clone [repository-url]
cd ecom-polygloteDB
```

2. Start the application using Docker Compose:
```bash
docker-compose up --build
```

3. Access the application:
- Main application: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- API Docs: http://localhost:8080/api-docs

## Database Configuration

### PostgreSQL
- Database: ecommerce
- Port: 5432
- Default credentials:
  - Username: postgres
  - Password: postgres

### MongoDB
- Database: ecommerce
- Port: 27017
- No authentication required for development

## Development

### Building the Application
```bash
./mvnw clean install
```

### Running Tests
```bash
./mvnw test
```

### Database Migrations
The application uses direct initialization scripts for both PostgreSQL and MongoDB. The scripts are located in:
- PostgreSQL: `init-scripts/postgres/`
- MongoDB: `init-scripts/mongo/`

## API Documentation

The API documentation is available through Swagger UI when the application is running. Visit http://localhost:8080/swagger-ui.html to explore the available endpoints.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 