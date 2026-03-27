# 📚 Library Management System (Monolith Console App)

A robust Java-based console application designed to handle end-to-end library operations. This project features a dual-user interface for **Administrators** and **Borrowers**, ensuring secure access and efficient book tracking.

---

## 🚀 Key Modules

### 🔐 Authentication (Module A)
- **Role-Based Login:** Validates users based on Email and Password.
- **Session Management:** Automatically redirects users to the `AdminMenu` or `BorrowerMenu` based on their credentials.

### 🛠️ Admin Inventory Management (Module B)
- **CRUD Operations:** Full control to Add, Modify (Quantity), and Delete books from the inventory.
- **Dynamic Sorting:** - View all books sorted alphabetically by **Name**.
    - View all books sorted by **Available Quantity** (highest to lowest).
- **User Management:** Ability to manually register and add new Borrowers to the system.

### 📖 Borrowing System (Module C)
- **Validation Guards:** - Enforces a **maximum of 3 books** per borrower.
    - Ensures a **minimum 500 Rs deposit** is maintained before any transaction.
- **Inventory Updates:** Real-time decrement of book quantity and increment of the book's total borrow count.

### 💸 Fines & Wallet (Module D)
- **Automatic Fine Calculation:** Calculates a fine of 2 Rs per day for any book kept beyond the 15-day tenure.
- **Integrated Wallet:** Deducts fine amounts directly from the borrower's initial 1500 Rs caution deposit.
- **Return Tracking:** Updates inventory levels immediately upon successful book return.

### 📊 Borrower Dashboard (Module E)
- **Transaction History:** Borrowers can view their currently held books.
- **Fine Logs:** A detailed record of all previous fines and their reasons.

---

## 🏗️ Class Architecture

- **`LibrarySystem.java`**: The core engine containing the menu loops and business logic.
- **`Book.java`**: Data model for book details (ISBN, Author, Price, Quantity).
- **`Borrower.java`**: Stores user profile, deposit balance, and borrowing history.
- **`Admin.java`**: Minimalist class for administrative credentials.
- **`Main.java`**: The entry point to launch the application.

---

## 💻 How to Run

1. Clone the repository.
2. Navigate to the `LibraryManagementSystem` directory.
3. Compile the source files:
   ```bash
   javac *.java