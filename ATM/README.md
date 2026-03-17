# ATM Console Application

A simple Java console-based ATM simulation with **Admin** and **User** modes.

## ✅ Features
- **Admin** mode
  - View ATM cash reserve
  - Deposit cash into ATM
- **User** mode
  - Select from multiple user accounts
  - Create a new user account
  - View user balance
  - Deposit cash
  - Withdraw cash


## 🔐 Access Credentials
> **Admin PIN:** `0000`
>
> **Default user accounts:**
> - `Default` / PIN `1234`
> - `Alice` / PIN `2345`
> - `Bob` / PIN `3456`
>
> When running the program, choose **Create new user account** to add more users.
>
> ⚠️ These values are hard-coded for demo purposes only. Do not use this approach in production.

> ⚠️ These values are hard-coded for demo purposes only. Do not use this approach in production.

## ▶️ How to Run
1. Ensure you have **Java 8+** installed.
2. Compile the project:

```bash
javac ATM/*.java
```

3. Run the program:

```bash
java ATM.Main
```

## 🧩 Project Structure
- `Main.java` — entry point that selects Admin or User mode
- `Admin.java` — admin menu and ATM reserve logic
- `User.java` — user menu and account balance logic

---

If you'd like, I can also add a `build` script or show how to run this project with an IDE like IntelliJ/VS Code.