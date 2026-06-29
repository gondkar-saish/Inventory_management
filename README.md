# 📦 Inventory Management System

A backend Inventory Management System built with **Spring Boot**, **Spring Data JPA**, and **MySQL**. The application provides REST APIs to manage products, suppliers, stock updates, and inventory transactions while automatically tracking low-stock items.

---

## ✨ Features

- 📦 Product Management
  - Add new products
  - Update product details
  - Delete products
  - View all products
  - Search product by ID

- 🚚 Supplier Management
  - Register suppliers
  - Update supplier information
  - Delete suppliers
  - View supplier details

- 📊 Inventory Tracking
  - Increase stock
  - Reduce stock
  - Maintain current inventory levels
  - Record every stock transaction

- ⚠️ Low Stock Monitoring
  - Retrieve products below the stock threshold
  - Helps identify products that require restocking

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs
- Postman

---

## 📂 Project Structure

```text
inventorymanagement/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.saish.inventorymanagement/
│   │   │
│   │   ├── controller/
│   │   │   ├── ProductController.java
│   │   │   ├── SupplierController.java
│   │   │   └── StockController.java
│   │   │
│   │   ├── dto/
│   │   │   ├── ProductRequest.java
│   │   │   ├── SupplierRequest.java
│   │   │   └── StockUpdateRequest.java
│   │   │
│   │   ├── entity/
│   │   │   ├── Product.java
│   │   │   ├── Supplier.java
│   │   │   └── StockTransaction.java
│   │   │
│   │   ├── repository/
│   │   │   ├── ProductRepository.java
│   │   │   ├── SupplierRepository.java
│   │   │   └── StockTransactionRepository.java
│   │   │
│   │   ├── service/
│   │   │   ├── ProductService.java
│   │   │   ├── SupplierService.java
│   │   │   ├── StockService.java
│   │   │   └── impl/
│   │   │       ├── ProductServiceImpl.java
│   │   │       ├── SupplierServiceImpl.java
│   │   │       └── StockServiceImpl.java
│   │   │
│   │   ├── exception/
│   │   │
│   │   └── InventoryManagementApplication.java
│   │
│   └── resources/
│       └── application.properties
│
└── pom.xml
```

---

## 🔄 Request Flow

```text
Client
   │
   ▼
Controller
   │
   ▼
Service Interface
   │
   ▼
Service Implementation
   │
   ▼
Repository
   │
   ▼
MySQL Database
```

---

## 🚀 REST Endpoints

### Product APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/products` | Add Product |
| GET | `/products` | Get All Products |
| GET | `/products/{id}` | Get Product by ID |
| PUT | `/products/{id}` | Update Product |
| DELETE | `/products/{id}` | Delete Product |
| GET | `/products/low-stock` | View Low Stock Products |

### Supplier APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/suppliers` | Add Supplier |
| GET | `/suppliers` | Get All Suppliers |
| GET | `/suppliers/{id}` | Get Supplier by ID |
| PUT | `/suppliers/{id}` | Update Supplier |
| DELETE | `/suppliers/{id}` | Delete Supplier |

### Stock APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/stock/update` | Update Inventory |
| GET | `/stock/history` | View Stock Transaction History |

---

## 💡 Architecture

- Layered Architecture
- DTO-based Request Handling
- Service Interface + Implementation Pattern
- Repository Pattern
- RESTful APIs
- Separation of Concerns
- MySQL Persistent Storage

---

## 🔮 Future Improvements

- JWT Authentication & Role-Based Access
- Product Categories
- Pagination & Sorting
- Search & Filtering
- Swagger/OpenAPI Documentation
- Docker Support
- Unit & Integration Testing

---

## 👨‍💻 Author

**Saish Gondkar**

Built as part of my Spring Boot backend learning journey to strengthen concepts such as layered architecture, REST API development, JPA/Hibernate, DTOs, and MySQL integration.
