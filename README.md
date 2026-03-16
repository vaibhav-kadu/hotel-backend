<h1 align="center">🏨 Smart Hotel Management System</h1>

<p align="center">
Backend system to manage restaurant operations, hotel bookings, and event hall reservations
</p>

<p align="center">

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Framework-brightgreen)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![JWT](https://img.shields.io/badge/Auth-JWT-yellow)
![Status](https://img.shields.io/badge/Status-Active-success)

</p>

---

# 📌 Project Overview

The **Smart Hotel Management System** is a backend application designed to automate **hotel and restaurant operations**.

The system manages:

* 🍽 Restaurant orders
* 🏨 Hotel room bookings
* 🎉 Event hall reservations

It also maintains **secure role-based access control** for different staff members.

The backend is built using **Spring Boot with a layered MVC architecture**, providing scalable, secure, and maintainable REST APIs.

---

# 📖 Project Description

This system digitizes hotel operations including:

* Restaurant order management
* Kitchen workflow
* Room booking
* Event hall reservations

Restaurant staff can take **table-wise orders**, which are instantly sent to the **kitchen dashboard**.

The system tracks order status through the workflow:

```
CREATED → PREPARING → READY → SERVED
```

The platform also supports:

* Guest management
* Room reservations
* Event hall bookings for functions such as weddings, birthdays, and corporate meetings.

Authentication and authorization are implemented using **JWT-based security with Role-Based Access Control (RBAC)**.

---

# ✨ Key Features

## 🍽 Restaurant Management

* Table management
* Menu management
* Order creation and tracking
* Kitchen dashboard workflow
* Order status management

```
CREATED → PREPARING → READY → SERVED
```

---

## 🏨 Hotel Management

* Customer / Guest management
* Room management *(Planned)*
* Room booking with check-in and check-out

---

## 🎉 Event Management

* Party hall management *(Planned)*
* Event booking for functions
* Optional food service integration with restaurant menu

---

## 🔐 Security

* JWT-based authentication
* Role-Based Access Control (RBAC)
* Secure password encryption using BCrypt

---

## 🏗 System Architecture

* Layered MVC architecture
* RESTful API design
* Relational database design with foreign key relationships
* DTO-based request validation
* Global exception handling

---

# 👥 Roles in the System

| Role            | Responsibilities                             |
| --------------- | -------------------------------------------- |
| **ADMIN**       | Manage menu, staff, and system configuration |
| **WAITER**      | Take customer orders                         |
| **CHEF**        | Manage kitchen order status                  |
| **BILLING**     | Generate invoices                            |
| **HOTEL STAFF** | Manage room and hall bookings                |

---

# ⚙ Technology Stack

## Backend

* **Java**
* **Spring Boot**
* **Spring Security**
* **Spring Data JPA / Hibernate**

## Database

* **MySQL**

## Authentication

* **JWT (JSON Web Token)**
* **BCrypt Password Encryption**

## Tools & Environment

* **IntelliJ IDEA**
* **Maven**
* **Git**
* **GitHub**
* **Postman**

---

# 🏗 Project Architecture

The backend follows a **Layered MVC Architecture**.

### Folder Structure

```
controller
service
repository
entity
dto
security
config
util
exception
```

### Request Flow

```
Client
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
Database
```

---

# 📦 Implemented Modules

✅ Staff Management
✅ Table Management
✅ Menu Management
✅ Order Management
✅ Kitchen Workflow
✅ JWT Authentication
✅ Role-Based Access Control
✅ Customer Management

---

# 🚧 Modules In Progress

🔄 Room Management
🔄 Room Booking System
🔄 Event Hall Management
🔄 Billing System

---

# 🚀 Future Improvements

* Online room reservation
* Payment gateway integration
* Hotel billing module
* Admin dashboard
* API documentation with Swagger
* Frontend web dashboard

---

# 👨‍💻 Author

**Vaibhav K**

Backend Developer
Java | Spring Boot | REST API
