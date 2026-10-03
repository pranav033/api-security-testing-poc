# API Security Testing POC

A hands-on API Security Testing POC built using Spring Boot, Spring Security, JWT and Postman.

The purpose of this project is to demonstrate practical API security testing techniques including authentication, authorization, JWT security testing, negative testing and Broken Object Level Authorization (BOLA/IDOR).

---

## Objective

This POC focuses on identifying and validating common API security weaknesses through hands-on testing.

The project covers:

- Authentication testing
- Authorization testing
- JWT security testing
- Negative API testing
- Broken Object Level Authorization (BOLA/IDOR)
- Token tampering and expiry testing
- Role-based access control
- Secure handling of JWT secrets using environment variables

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database
- JWT (JJWT)
- Maven
- Postman
- Git / GitHub

---

## Application Architecture

```text
                    ┌─────────────────┐
                    │     Postman     │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │   Spring Boot   │
                    │       API       │
                    └────────┬────────┘
                             │
                ┌────────────┴────────────┐
                │                         │
                ▼                         ▼
        ┌───────────────┐         ┌────────────────┐
        │ JWT Security  │         │   Controllers  │
        │     Filter    │         │                │
        └───────┬───────┘         └───────┬────────┘
                │                         │
                ▼                         ▼
        ┌───────────────┐         ┌────────────────┐
        │ Authentication │         │    Services    │
        │ & Authorization│         │                │
        └───────────────┘         └───────┬────────┘
                                          │
                                          ▼
                                  ┌────────────────┐
                                  │ Data / Repos   │
                                  └────────────────┘