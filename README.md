# NextLogic: Distributed Job Intelligence Platform

A fully containerised microservices platform that scrapes, enriches, stores and ranks job listings in real time using Kafka-driven event pipelines, with a Next.js frontend for search, company insights and personalised alerts.

**Status:** In active development (April 2026 to present)

> Items marked `[TODO]` are placeholders. Replace them with real details, or delete the line, before publishing.

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

`[TODO: add an architecture diagram, e.g. docs/architecture.png]`

### Event Flow

1. The Scraper Service publishes raw job listings to Kafka.
2. Enrichment consumers attach company metadata.
3. Job Service consumes the enriched events and persists them.
4. The matching engine ranks listings against user preferences.
5. Alert Service notifies users of relevant matches.

`[TODO: confirm the topic names and exact flow]`

---

## Key Features

- **Real-time pipelines:** Kafka producers and consumers move listings through scraping, enrichment, storage and ranking.
- **Job matching engine:** Keyword, location and company-based search across PostgreSQL and MongoDB, with millisecond-level responses. `[TODO: add a measured figure, e.g. p95 latency]`
- **Automated job expiry:** Scheduled workflows remove stale listings.
- **Deduplication:** Enrichment pipelines keep datasets clean and free of duplicates across services.
- **Personalised alerts:** Users receive alerts based on saved preferences.
- **Company insights:** Company metadata is surfaced alongside listings.
- **Unified API:** The frontend talks to every service through one gateway.

---

## Frontend

Built with Next.js, React and TypeScript. Main views:

- Job search
- Company insights
- Personalised alerts

`[TODO: rendering strategy (SSR / SSG / ISR / CSR), state management, styling (e.g. Tailwind)]`

---

## Getting Started

### Prerequisites

- Java 21
- Maven
- Docker
- Node.js `[TODO: version]`

### Run locally

```bash
# Clone the repository
git clone https://github.com/abhinav91a/NextLogic.git
cd NextLogic

# [TODO: replace with your actual run commands, e.g. docker compose up --build]
```

### Environment variables

`[TODO: list required variables, e.g. database URLs and Kafka bootstrap servers]`

---

## Project Structure

```
NextLogic/
├── [TODO: gateway/]
├── [TODO: discovery-server/]
├── [TODO: scraper-service/]
├── [TODO: job-service/]
├── [TODO: company-service/]
├── [TODO: user-preferences-service/]
├── [TODO: alert-service/]
└── [TODO: frontend/]
```

---

## Testing

`[TODO: describe the test setup, or delete this section]`

---

## Roadmap

`[TODO: planned features, or delete this section]`

---

## Author

**Abhinav Sharma**
[LinkedIn](https://linkedin.com/in/abhinav-sharma-373b17a7) · [GitHub](https://github.com/abhinav91a)
