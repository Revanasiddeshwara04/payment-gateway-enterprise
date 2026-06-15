# Enterprise Payment Gateway System

A production-grade Payment Gateway Platform built using Java, Spring Boot Microservices, Spring Cloud, JWT Authentication, Kafka, Docker, Kubernetes, and AWS.

## Overview

This project demonstrates how enterprise payment providers such as Stripe, Razorpay, PayPal, and Adyen are designed using modern microservices architecture.

The system supports:

* Merchant onboarding
* User authentication and authorization
* Payment processing
* Transaction management
* Refund management
* Settlement processing
* Fraud detection
* Notification services
* Reporting and analytics

---

## Technology Stack

### Backend

* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Spring Cloud
* Spring Cloud Gateway
* OpenFeign
* Hibernate

### Database

* MySQL

### Security

* JWT Authentication
* BCrypt Password Encryption
* Spring Security

### Messaging

* Apache Kafka

### DevOps

* Docker
* Docker Compose
* Kubernetes
* AWS

### Service Discovery & Configuration

* Eureka Server
* Spring Cloud Config Server

---

## Project Structure

```text
payment-gateway-enterprise
│
├── backend
│   ├── config-server
│   ├── service-registry
│   ├── api-gateway
│   ├── auth-service
│   ├── merchant-service
│   ├── payment-service
│   ├── transaction-service
│   ├── refund-service
│   ├── settlement-service
│   ├── notification-service
│   ├── fraud-detection-service
│   └── reporting-service
│
├── frontend
│
├── docker
│
├── kubernetes
│
├── aws
│
├── kafka
│
├── docs
│
└── README.md
```

---

## Architecture

```text
                    Client
                       │
                       ▼
                API Gateway
                       │
      ┌────────────────┼────────────────┐
      │                │                │
      ▼                ▼                ▼

 Auth Service   Merchant Service   Payment Service
      │                │                │
      └────────────────┼────────────────┘
                       │
                       ▼
              Transaction Service
                       │
       ┌───────────────┼───────────────┐
       ▼               ▼               ▼

 Refund Service  Settlement Service  Notification Service
                       │
                       ▼
              Reporting Service

```

---

## Completed Services

### Infrastructure

* [x] Config Server
* [x] Eureka Service Registry
* [x] API Gateway

### Authentication Service

Features:

* User Registration
* User Login
* JWT Token Generation
* JWT Validation
* BCrypt Password Encryption
* Protected APIs

Status:

* [x] Completed

### Merchant Service

Features:

* Create Merchant
* Get Merchant By ID
* Get All Merchants
* Update Merchant
* Delete Merchant
* Activate Merchant
* Deactivate Merchant

Status:

* [x] Completed

---

## In Progress

### Payment Service

Planned Features:

* Create Payment
* Authorize Payment
* Capture Payment
* Cancel Payment
* Payment Status Tracking

Status:

* [ ] In Progress

---

## Future Services

### Transaction Service

* Transaction History
* Transaction Tracking
* Transaction Search

### Refund Service

* Full Refund
* Partial Refund
* Refund Tracking

### Settlement Service

* Merchant Settlement
* Daily Settlement Reports

### Notification Service

* Email Notifications
* SMS Notifications
* Payment Alerts

### Fraud Detection Service

* Velocity Checks
* Risk Analysis
* Suspicious Activity Detection

### Reporting Service

* Merchant Reports
* Payment Reports
* Settlement Reports

---

## Running the Application

### Start Config Server

```bash
cd backend/config-server
mvn spring-boot:run
```

### Start Eureka Server

```bash
cd backend/service-registry
mvn spring-boot:run
```

### Start API Gateway

```bash
cd backend/api-gateway
mvn spring-boot:run
```

### Start Auth Service

```bash
cd backend/auth-service
mvn spring-boot:run
```

### Start Merchant Service

```bash
cd backend/merchant-service
mvn spring-boot:run
```

---

## Learning Objectives

This project is being built to gain hands-on experience with:

* Enterprise Microservices
* Distributed Systems
* Security using JWT
* Event-Driven Architecture
* Cloud Deployment
* Kubernetes Orchestration
* Payment Processing Workflows

---

## Author

Revanasiddeshwara

Java Full Stack Developer

Building an enterprise-grade payment gateway from scratch for deep understanding of real-world microservices architecture.
