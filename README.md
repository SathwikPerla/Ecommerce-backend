# 🛒 E-Commerce Backend API (Spring Boot + MongoDB)

A minimal **E-Commerce Backend REST API** built using **Spring Boot** and **MongoDB**, implementing core e-commerce functionalities such as product management, cart operations, order creation, and payment processing using a **mock payment gateway with webhook simulation**.

This project was developed as part of an **in-class academic assignment** to demonstrate backend architecture, RESTful APIs, business logic, and asynchronous payment handling.

---

## 📌 About the Project

This backend system simulates a real-world e-commerce workflow:

- Products can be created and listed
- Users can add products to a cart
- Orders are created from cart items
- Payments are initiated for orders
- Payment confirmation happens asynchronously via webhooks
- Order status updates automatically after payment

The focus is on **clean architecture**, **service-layer business logic**, and **REST API design**, not frontend/UI.

---

## 🎯 Features Implemented

- ✅ Product Management
- ✅ Cart Management
- ✅ Order Creation
- ✅ Mock Payment Gateway
- ✅ Webhook-based Payment Confirmation
- ✅ MongoDB Integration
- ✅ RESTful API Design
- ✅ Postman-tested APIs

---

## 🏗️ Tech Stack

- **Java 25**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data MongoDB**
- **MongoDB**
- **Lombok**
- **Postman (for API testing)**

```
---

## 📂 Project Structure
com.example.Sathwik
│
├── controller
│   ├── ProductController.java
│   ├── CartController.java
│   ├── OrderController.java
│   └── PaymentController.java
│
├── service
│   ├── ProductService.java
│   ├── CartService.java
│   ├── OrderService.java
│   └── PaymentService.java
│
├── repository
│   ├── ProductRepository.java
│   ├── CartRepository.java
│   ├── OrderRepository.java
│   └── PaymentRepository.java
│
├── model
│   ├── User.java
│   ├── Product.java
│   ├── CartItem.java
│   ├── Order.java
│   ├── OrderItem.java
│   └── Payment.java
│
├── dto
│   ├── AddToCartRequest.java
│   ├── CreateOrderRequest.java
│   ├── PaymentRequest.java
│   └── PaymentWebhookRequest.java
│
├── webhook
│   └── PaymentWebhookController.java
│
├── client
│   └── PaymentServiceClient.java   (if mock service used)
│
├── config
│   └── RestTemplateConfig.java
│
└── SathwikApplication.java

---
```

## 🔗 API Endpoints

### 1️⃣ Product APIs

#### Create Product
POST /api/products
```http
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000,
  "stock": 10
}
```
Get All Products
```
GET /api/products
```
2️⃣ Cart APIs
Add Item to Cart

POST /api/cart/add
```
{
  "userId": "user123",
  "productId": "PRODUCT_ID",
  "quantity": 2
}
```
Get User Cart
```
GET /api/cart/{userId}
```
Clear Cart

DELETE /api/cart/{userId}/clear

3️⃣ Order APIs
Create Order from Cart
POST /api/orders
```
{
  "userId": "user123"
}
```
4️⃣ Payment APIs (Mock Payment Service)
Create Payment
```
{
  "orderId": "ORDER_ID",
  "amount": 100000
}
```
Payment Webhook (Auto-triggered)
POST /api/webhooks/payment

Webhook is automatically triggered after a 3-second delay by the mock payment service.

## 🔄 Order Flow
Create products
Add products to cart
Create order from cart
Initiate payment
Mock payment gateway waits 3 seconds
Webhook updates payment and order status
Order status becomes PAID

## 🧪 Testing
All APIs were tested using Postman.

Recommended testing order:

Create product
Add to cart
View cart
Create order
Create payment
Wait for webhook callback

## 🎓 Key Concepts Demonstrated
REST API design
Layered architecture (Controller → Service → Repository)
MongoDB document modeling
Business logic validation
Asynchronous webhook handling
Service-to-service communication using RestTemplate

## ⚠️ Notes
No authentication/authorization is implemented (out of scope)
Payment gateway is mocked for simplicity
Order retrieval by ID can be added as an extension
Designed for academic and learning purposes

## 🚀 How to Run
Clone the repository
Start MongoDB locally on port 27017
Open project in IntelliJ / VS Code
Run SathwikApplication
Server starts at http://localhost:8080

## 👨‍💻 Author
Sathwik
Computer Science Student
Spring Boot | Backend Development

## 📄 License
This project is for educational purposes only.
