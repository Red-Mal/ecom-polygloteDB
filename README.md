# E-commerce PolyglotDB

A modern, full-stack e-commerce application built with a polyglot persistence approach, utilizing multiple databases for different aspects of the system.

## 🌟 Features

- **Modern UI/UX**: Built with Next.js 13+ and Tailwind CSS
- **Polyglot Persistence**:
  - MongoDB: Product catalog and reviews
  - PostgreSQL: User accounts and orders
  - Redis: Caching and session management
  - Elasticsearch: Full-text search capabilities
- **Microservices Architecture**: Containerized with Docker
- **Real-time Updates**: WebSocket integration for live inventory updates
- **Responsive Design**: Mobile-first approach
- **Secure Authentication**: JWT-based auth system
- **Rich Product Catalog**: With categories, ratings, and reviews
- **Shopping Cart**: Persistent cart functionality
- **Order Management**: Complete order lifecycle

## 🛠 Tech Stack

### Frontend
- Next.js 13+
- TypeScript
- Tailwind CSS
- Shadcn UI Components
- React Query

### Backend
- Spring Boot
- Java 17
- Spring Data JPA/MongoDB
- Spring Security

### Databases
- MongoDB
- PostgreSQL
- Redis
- Elasticsearch

### DevOps
- Docker
- Docker Compose
- GitHub Actions

## 🚀 Getting Started

### Prerequisites
- Docker and Docker Compose
- Node.js 18+
- Java 17+
- Maven

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/ecom-polyglotDB.git
cd ecom-polyglotDB
```

2. Start the services using Docker Compose:
```bash
docker compose -f docker/docker-compose.yml up -d
```

3. The application will be available at:
- Frontend: http://localhost:3001
- Backend API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html

## 📁 Project Structure

```
ecom-polyglotDB/
├── frontend/               # Next.js frontend application
├── backend/               # Spring Boot backend application
├── docker/                # Docker configuration files
│   ├── docker-compose.yml
│   └── init-scripts/      # Database initialization scripts
└── README.md
```

## 🔧 Configuration

### Environment Variables

Frontend (.env):
```
NEXT_PUBLIC_API_URL=http://backend:8080
```

Backend (application.properties):
```
spring.data.mongodb.uri=mongodb://mongodb:27017/ecommerce
spring.datasource.url=jdbc:postgresql://postgres:5432/ecommerce
```

## 🌐 API Documentation

The API documentation is available through Swagger UI at:
http://localhost:8080/swagger-ui.html

## 🧪 Testing

Run backend tests:
```bash
cd backend
./mvnw test
```

Run frontend tests:
```bash
cd frontend
npm test
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- [Unsplash](https://unsplash.com) for providing high-quality product images
- [Shadcn UI](https://ui.shadcn.com/) for the beautiful UI components
- All contributors who have helped this project grow 