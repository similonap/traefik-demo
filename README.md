# Traefik Demo Chat App

## Description

This is a simple chat application that demonstrates how to use Traefik as a reverse proxy for a microservices architecture. The application consists of a frontend built with Angular, a backend built with Spring Boot, and a MySQL database. Traefik is used to route traffic to the appropriate services.

## Architecture

- **Frontend**: Angular application served by Nginx.
- **Backend**: Spring Boot application providing RESTful APIs.
- **Database**: MySQL database to store chat messages.
- **Proxy**: Traefik as a reverse proxy to route requests to the frontend and backend services.

## Prerequisites

- Docker
- Docker Compose

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/traefik-demo.git
cd traefik-demo
```

### Edit the docker compose file

In this example we are using the development subdomains on the traefik.me domain. They will route to your localhost. If you want to use a different domain for development, you can change the `traefik.http.routers.frontend.rule` and `traefik.http.routers.backend.rule` labels in the `docker-compose.yml` file.

Make sure to keep the frontend and backend subdomains the same and include the PathPrefix rule.

### Build and run the application

```bash
docker-compose up --build
```

This command will:
1. Build the Angular frontend and serve it using Nginx.
2. Build the Spring Boot backend.
3. Start a MySQL database.
4. Start Traefik to route traffic to the frontend and backend.