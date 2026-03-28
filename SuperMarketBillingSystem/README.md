# 🛒 Supermarket Billing System (Java Console Application)

## 📌 Overview
The Supermarket Billing System is a console-based Java application designed to simulate real-world supermarket operations. It supports both Admin and Customer roles, enabling inventory management, billing, cart operations, and sales tracking.

This project demonstrates strong understanding of Java, OOP concepts, and data handling using collections.

---

## 🚀 Features

### 🔐 Authentication
- Admin Login
- Customer Login

### 🛍️ Inventory Management (Admin)
- Add new products
- Update product details
- Delete products
- Search products
- Sort products
- Track sold items

### 👤 Customer Operations
- View available products
- Add items to cart
- Edit cart quantity
- Remove items from cart
- View cart with total price

### 💳 Payment System
- Credit-based payment system
- Cashback: ₹100 for purchases ≥ ₹5000
- Loyalty points system:
  - Earn points for every ₹100 spent
  - ₹100 reward for every 50 points

### 🧾 Billing & History
- Auto-generated bill ID
- Purchase history with date & amount

### 📊 Reports (Admin)
- Low stock products
- Unsold products

---

## 🧠 Concepts Used
- Object-Oriented Programming (OOP)
  - Encapsulation
  - Abstraction
- Java Collections (ArrayList)
- Control Structures (loops, conditionals)
- In-memory data management

---

## 🏗️ Project Structure

```
SuperMarketBillingSystem/
│
├── BillingSystem.java
├── DataStore.java
├── Admin.java
├── Customer.java
├── Inventory.java
├── CartItem.java
├── Bill.java
```

---

## ▶️ How to Run

1. Clone the repository:
```
git clone https://github.com/your-username/supermarket-billing-system.git
```

2. Open the project in any Java IDE (IntelliJ / Eclipse / VS Code)

3. Run the main file:
```
BillingSystem.java
```

---

## 🔑 Default Credentials

### Admin
- Email: admin@gmail.com
- Password: admin123

### Customer
- Email: user@gmail.com
- Password: user123

---

## 💡 Future Enhancements
- Integrate MySQL database
- Convert into Spring Boot REST API
- Build frontend using React or Flutter
- Add secure authentication (JWT)
- Add analytics dashboard

---

## 🎯 Learning Outcomes
- Practical implementation of OOP concepts
- Handling real-world business logic
- Designing modular and scalable code
- Understanding system workflows

---