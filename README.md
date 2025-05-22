# E-commerce PolyglotDB

A modern, full-stack e-commerce application built with a polyglot persistence approach, utilizing multiple databases for different aspects of the system.

## 🌟 Features

### Implemented Features
- **Modern UI/UX**: Built with Next.js 13+ and Tailwind CSS with Shadcn UI components
- **Polyglot Persistence**:
  - MongoDB: Product catalog and reviews
  - PostgreSQL: User accounts and orders
  - Redis: Ready for caching implementation
  - Elasticsearch: Ready for search implementation
- **Containerized Architecture**: Fully containerized with Docker and Docker Compose
- **Responsive Design**: Mobile-first approach with Tailwind CSS
- **Rich Product Catalog**: 
  - Multiple categories per product
  - High-quality product images
  - Customer reviews and ratings
- **Order Management**: 
  - Complete order lifecycle
  - Multiple order statuses (Pending, Confirmed, Shipped, Delivered, Cancelled)
  - User order history

### Planned Features
- **Real-time Updates**: WebSocket integration for live inventory updates
- **Secure Authentication**: JWT-based auth system
- **Shopping Cart**: Persistent cart functionality
- **Redis Caching**: Performance optimization
- **Elasticsearch Integration**: Advanced search capabilities

## 🛠 Tech Stack

### Frontend
- Next.js 13+
- TypeScript
- Tailwind CSS
- Shadcn UI Components
- React Query

### Backend
- Spring Boot 3.2
- Java 17
- Spring Data JPA/MongoDB
- Spring Security (planned)

### Databases
- MongoDB 7.0: Product catalog and reviews
- PostgreSQL 16: User accounts and orders
- Redis 7.0: Future caching implementation
- Elasticsearch 8.12: Future search implementation

### DevOps
- Docker & Docker Compose
- GitHub Actions (planned)

## 🚀 Getting Started

### Prerequisites
- Docker and Docker Compose
- Node.js 18+ (for local development)
- Java 17+ (for local development)
- Maven (for local development)

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

### Local Development Setup

#### Frontend
```bash
cd frontend
npm install
npm run dev
```

#### Backend
```bash
cd backend
./mvnw spring-boot:run
```

## 📁 Project Structure
```
ecom-polyglotDB/
├── frontend/                 # Next.js frontend application
│   ├── src/
│   │   ├── components/      # Reusable UI components
│   │   ├── pages/          # Next.js pages
│   │   └── styles/         # Global styles
├── backend/                 # Spring Boot backend application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/       # Java source files
│   │   │   └── resources/  # Application properties
│   │   └── test/           # Test files
└── docker/                  # Docker configuration
    ├── docker-compose.yml
    └── init-scripts/        # Database initialization scripts
```

## 🔧 Environment Setup

### Frontend Environment Variables (.env)
```
NEXT_PUBLIC_API_URL=http://localhost:8080
```

### Backend Environment Variables (application.properties)
```
spring.data.mongodb.uri=mongodb://mongodb:27017/ecommerce
spring.datasource.url=jdbc:postgresql://postgres:5432/ecommerce
```

## 🌐 API Documentation

The API documentation is available through Swagger UI at:
http://localhost:8080/swagger-ui.html

Key API endpoints:
- Products: `/api/products`
- Orders: `/api/orders`
- Reviews: `/api/reviews`
- Users: `/api/users`

## 🧪 Testing

### Frontend Tests
```bash
cd frontend
npm test
```

### Backend Tests
```bash
cd backend
./mvnw test
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch:
```bash
git checkout -b feature/AmazingFeature
```
3. Commit your changes:
```bash
git commit -m 'Add some AmazingFeature'
```
4. Push to the branch:
```bash
git push origin feature/AmazingFeature
```
5. Open a Pull Request

### Development Guidelines
- Follow the existing code style and conventions
- Write meaningful commit messages
- Add appropriate tests for new features
- Update documentation as needed

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- [Unsplash](https://unsplash.com) for providing high-quality product images
- [Shadcn UI](https://ui.shadcn.com/) for the beautiful UI components
- All contributors who have helped this project grow 