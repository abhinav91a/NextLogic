# NextLogic: Distributed Job Intelligence Platform

A fully containerised microservices platform that scrapes, enriches, stores and ranks job listings in real time using Kafka-driven event pipelines, with a Next.js frontend for search, company insights and personalised alerts.


---

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 3.2 |
| API Gateway | Spring Cloud Gateway |
| Service Discovery | Eureka |
| Messaging | Apache Kafka |
| Databases | PostgreSQL, MongoDB |
| Frontend | Next.js (React + TypeScript) |
| Containerisation | Docker |

---

## Architecture

NextLogic is split into independent services, all routed through a single API gateway and registered with Eureka for service discovery.

| Service | Responsibility |
|---|---|
| Scraper Service | Collects job listings from external sources |
| Job Service | Stores and manages job data |
| Company Service | Holds company metadata used to enrich listings |
| User Preferences Service | Stores each user's search preferences |
| Alert Service | Sends personalised alerts for matching jobs |
| API Gateway | Single entry point for the frontend (Spring Cloud Gateway) |
| Discovery Server | Service registry (Eureka) |
| Frontend | Next.js web application |

### Event-Driven Pipeline

Job listings flow through Kafka producers and consumers across four stages: scraping, enrichment, storage and ranking. Each service handles its own stage independently.

---

## Key Features

- **Real-time pipelines:** Kafka-driven event pipelines move listings through scraping, enrichment, storage and ranking.
- **Job matching engine:** Keyword, location and company-based search across PostgreSQL and MongoDB, with millisecond-level response times.
- **Automated job expiry:** Workflows remove stale listings automatically.
- **Deduplication:** Enrichment pipelines keep datasets clean and deduplicated across services.
- **Personalised alerts:** Users receive alerts based on their saved preferences.
- **Company insights:** Company metadata is surfaced alongside listings.
- **Unified API:** The frontend talks to every service through one gateway.

---

## Frontend

Built with Next.js, React and TypeScript. Main views:

- Job search
- Company insights
- Personalised alerts

---

## Prerequisites

- Java 21
- Maven
- Docker
- Node.js

---

## Author

**Abhinav Sharma**
[LinkedIn](https://linkedin.com/in/abhinav-sharma-373b17a7) · [GitHub](https://github.com/abhinav91a)
