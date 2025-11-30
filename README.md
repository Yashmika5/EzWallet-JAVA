# 💰 EZ-Wallet - Digital Wallet Management System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-orange?style=for-the-badge)

A feature-rich desktop application for managing digital wallet transactions, built with Java Swing and MySQL. EZ-Wallet provides a secure and intuitive platform for users to manage their finances, transfer money, and track transactions.

## 📋 Table of Contents

- [Features](#-features)
- [Screenshots](#-screenshots)
- [Technology Stack](#-technology-stack)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Database Setup](#-database-setup)
- [Configuration](#-configuration)
- [Usage](#-usage)
- [Project Structure](#-project-structure)
- [Security Features](#-security-features)
- [Contributing](#-contributing)
- [License](#-license)

## ✨ Features

### 🔐 Authentication & Security
- **User Registration** with email verification
- **Secure Login** with encrypted password storage
- **PIN Protection** for sensitive transactions
- **Email Verification** using JavaMail API
- Show/Hide password toggle for enhanced security

### 💳 Wallet Management
- **View Balance** with real-time updates
- **Unique Pay ID** for each user
- **Top-up Wallet** functionality
- **Transaction History** with detailed logs
- **Income/Outcome Tracking** with visual indicators

### 💸 Money Transfer
- **Peer-to-Peer Transfers** using Pay IDs
- **Transaction Notes** for record keeping
- **PIN Verification** before transfers
- **Confirmation Dialogs** to prevent accidental transfers
- **Instant Balance Updates** for both sender and receiver

### 👤 Profile Management
- **View Profile** with complete user information
- **Edit Profile** (first name, last name, mobile, NIC)
- **Change PIN** with old PIN verification
- **Secure Logout** functionality

### 📊 Dashboard Features
- **Welcome Message** with user's first name
- **Current Balance Display** in LKR
- **Pay ID Display** for easy sharing
- **Total Income** summary with green indicator
- **Total Outcome** summary with red indicator
- **Quick Access Buttons** to all features

## 📸 Screenshots

- **Soon**

## 🛠 Technology Stack

### Frontend
- **Java Swing** - GUI framework
- **AWT** - Abstract Window Toolkit

### Backend
- **Java** - Core programming language
- **JDBC** - Database connectivity
- **MySQL Connector/J** - MySQL driver

### Database
- **MySQL** - Relational database management system

### Email Service
- **JavaMail API** - Email verification
- **SMTP** - Email protocol (Gmail)

### Design Pattern
- **MVC (Model-View-Controller)** - Architecture pattern
- **Loading Screen** - Separate MVC implementation

## 📦 Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK)** 8 or higher
- **MySQL Server** 5.7 or higher
- **MySQL Connector/J** (JDBC Driver)
- **JavaMail API** library
- An IDE (Eclipse, IntelliJ IDEA, or NetBeans) - Optional

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/ezwallet-java.git
cd ezwallet-java
```

### 2. Add Required Libraries

Download and add the following JAR files to your project's build path:

- **MySQL Connector/J**: [Download here](https://dev.mysql.com/downloads/connector/j/)
- **JavaMail API**: [Download here](https://javaee.github.io/javamail/)
- **Java Activation Framework (JAF)**: Required for JavaMail

### 3. Configure Assets Path

Update the image paths in all Java files to match your local asset directory:

```java
// Find and replace this path with your assets folder path
"C:\\Users\\yashm\\Documents\\ezwallet-assets\\"
```

Replace with your path, for example:
```java
"C:\\Your\\Path\\To\\Assets\\"
```

## 🗄 Database Setup

### 1. Create Database

```sql
CREATE DATABASE `ez-wallet-db`;
USE `ez-wallet-db`;
```

### 2. Create Users Table

```sql
CREATE TABLE `users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(50) NOT NULL,
  `lastName` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL,
  `mobile` VARCHAR(15) NOT NULL,
  `nic` VARCHAR(20) NOT NULL,
  `pin` INT(6) NOT NULL,
  `balance` DOUBLE(10,2) DEFAULT 0.00,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

### 3. Create Transactions Table

```sql
CREATE TABLE `transactions` (
  `transaction_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sender_id` INT(11) NOT NULL,
  `receiver_id` INT(11) NOT NULL,
  `amount` DOUBLE(10,2) NOT NULL,
  `notes` TEXT,
  `dateTime` DATETIME NOT NULL,
  PRIMARY KEY (`transaction_id`),
  FOREIGN KEY (`sender_id`) REFERENCES `users`(`id`),
  FOREIGN KEY (`receiver_id`) REFERENCES `users`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

### 4. Create Top-up History Table

```sql
CREATE TABLE `topup_history` (
  `topup_id` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `amount` DOUBLE(10,2) NOT NULL,
  `notes` TEXT,
  `dateTime` DATETIME NOT NULL,
  PRIMARY KEY (`topup_id`),
  FOREIGN KEY (`userId`) REFERENCES `users`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

## ⚙ Configuration

### Database Connection

Update the database connection details in each relevant Java file:

```java
private String url = "jdbc:mysql://localhost:3306/ez-wallet-db";
private String username = "root"; 
private String password = "your_mysql_password";
```

### Email Configuration

For email verification to work, update the `EmailVerify.java` file:

```java
String from = "your-email@gmail.com";
String password = "your-app-password"; // Use App Password for Gmail
```

**Note**: For Gmail, you need to:
1. Enable 2-Factor Authentication
2. Generate an [App Password](https://myaccount.google.com/apppasswords)
3. Use the App Password in your code

## 💻 Usage

### Running the Application

#### Using IDE:
1. Open the project in your preferred IDE
2. Navigate to `src/loadingScreen/MainClass.java`
3. Run the `main` method

#### Using Command Line:
```bash
# Compile
javac -cp ".;mysql-connector-java.jar;javax.mail.jar" src/loadingScreen/MainClass.java

# Run
java -cp ".;mysql-connector-java.jar;javax.mail.jar;src" loadingScreen.MainClass
```

### First Time Setup

1. **Launch Application** - The loading screen will appear
2. **Register Account** - Click on "Register" and fill in your details
3. **Verify Email** - Check your email for the verification code
4. **Login** - Use your email and password to login
5. **Start Using** - Access dashboard and start managing your wallet!

### User Flow

```
┌─────────────────┐
│  Loading Screen │
└────────┬────────┘
         │
         ▼
┌─────────────────┐      ┌──────────────┐
│  Login Screen   │◄─────┤ Registration │
└────────┬────────┘      └──────┬───────┘
         │                      │
         │                      ▼
         │              ┌──────────────┐
         │              │Email Verify  │
         │              └──────┬───────┘
         │                     │
         └──────────┬──────────┘
                    │
                    ▼
         ┌──────────────────┐
         │    Dashboard     │
         └────────┬─────────┘
                  │
    ┌─────────────┼─────────────┐
    │             │             │
    ▼             ▼             ▼
┌────────┐  ┌──────────┐  ┌──────────┐
│Transfer│  │  Top-up  │  │Transaction│
└────────┘  └──────────┘  │  History  │
    │             │        └──────────┘
    │             │             │
    └─────────────┼─────────────┘
                  │
                  ▼
         ┌──────────────────┐
         │    Settings      │
         └────────┬─────────┘
                  │
         ┌────────┴────────┐
         │                 │
         ▼                 ▼
    ┌──────────┐     ┌──────────┐
    │Edit Profile│    │Change PIN│
    └──────────┘     └──────────┘
```

## 📁 Project Structure

```
EzWallet-JAVA-main/
│
├── bin/                          # Compiled class files
│   ├── ezwallet/
│   └── loadingScreen/
│
├── src/                          # Source files
│   ├── backup/
│   │   └── emailverify.java
│   │
│   ├── ezwallet/
│   │   ├── changePin.java        # PIN change functionality
│   │   ├── dashboard.java        # Main dashboard
│   │   ├── editProfile.java      # Profile editing
│   │   ├── EmailVerify.java      # Email verification
│   │   ├── Login.java            # Login screen
│   │   ├── profile.java          # Profile viewing
│   │   ├── Register.java         # User registration
│   │   ├── Settings.java         # Settings menu
│   │   ├── toupWallet.java       # Wallet top-up
│   │   ├── transactionHistory.java  # Transaction logs
│   │   ├── transferMoney.java    # Money transfer
│   │   └── user.java             # User model
│   │
│   └── loadingScreen/
│       ├── LoadingControl.java   # MVC Controller
│       ├── LoadingModel.java     # MVC Model
│       ├── LoadingView.java      # MVC View
│       └── MainClass.java        # Application entry point
│
└── README.md                     # This file
```

### Key Components

#### Core Classes

- **`user.java`** - User data model with getters/setters
- **`Login.java`** - Authentication handling
- **`Register.java`** - New user registration
- **`EmailVerify.java`** - Email verification system
- **`dashboard.java`** - Main application hub

#### Feature Classes

- **`transferMoney.java`** - P2P money transfers
- **`toupWallet.java`** - Add funds to wallet
- **`transactionHistory.java`** - View past transactions
- **`profile.java`** - Display user profile
- **`editProfile.java`** - Modify user details
- **`changePin.java`** - Update security PIN
- **`Settings.java`** - Application settings

#### Loading Screen (MVC Pattern)

- **`LoadingModel.java`** - Data management
- **`LoadingView.java`** - UI rendering
- **`LoadingControl.java`** - Business logic
- **`MainClass.java`** - Entry point

## 🔒 Security Features

### 1. Password Security
- Passwords are stored as plain text (⚠️ **Not recommended for production**)
- **Recommendation**: Implement password hashing using BCrypt or PBKDF2

### 2. PIN Protection
- 6-digit PIN for transaction verification
- PIN required for:
  - Money transfers
  - Wallet top-ups
  - PIN changes

### 3. Email Verification
- Prevents fake account creation
- 6-digit verification code sent via email
- Code expires after verification

### 4. Input Validation
- Email format validation using regex
- Amount validation for transfers
- Required field checks
- PIN verification before sensitive operations

### 5. SQL Injection Prevention
- Uses PreparedStatements for all database queries
- Parameterized queries prevent SQL injection attacks

### 🔐 Security Improvements Recommended

```java
// 1. Implement password hashing
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
String hashedPassword = encoder.encode(plainPassword);

// 2. Add session management
// 3. Implement rate limiting for login attempts
// 4. Add HTTPS for production deployment
// 5. Implement proper logging and audit trails
```

## 🎨 UI/UX Features

- **Custom Icons** - Professional look and feel
- **Hover Effects** - Interactive cursor changes
- **Password Toggle** - Show/hide password functionality
- **Tool Tips** - Helpful hints on buttons
- **Confirmation Dialogs** - Prevent accidental actions
- **Error Messages** - Clear, user-friendly error notifications
- **Success Messages** - Positive feedback for completed actions
- **Smooth Navigation** - Easy transitions between screens

## 🐛 Known Issues

1. ⚠️ **Hardcoded Asset Paths** - Need to be updated for each system
2. ⚠️ **Plain Text Passwords** - Should be hashed in production
3. ⚠️ **No Connection Pooling** - Each operation creates new DB connection
4. ⚠️ **Email Credentials in Code** - Should use environment variables
5. ⚠️ **No Input Sanitization** - Risk of XSS in notes/text areas

## 🔧 Troubleshooting

### Database Connection Issues

```
Error: Communications link failure
```
**Solution**: 
- Check if MySQL server is running
- Verify database credentials
- Ensure MySQL port 3306 is open

### Email Sending Fails

```
Error: Authentication failed
```
**Solution**:
- Enable "Less secure app access" in Gmail (Not recommended)
- Use App Password (Recommended)
- Check internet connection

### ClassNotFoundException

```
java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver
```
**Solution**:
- Add MySQL Connector/J to build path
- Verify JAR file is not corrupted

### Asset Not Found

```
Exception: Cannot read image file
```
**Solution**:
- Update all image paths to your local assets folder
- Ensure all required images are present

## 🚀 Future Enhancements

### Planned Features
- [ ] Password hashing with BCrypt
- [ ] Transaction receipts (PDF generation)
- [ ] QR code for Pay ID sharing
- [ ] Transaction filters (date range, amount)
- [ ] Export transaction history to CSV/Excel
- [ ] Multi-currency support
- [ ] Recurring payments
- [ ] Bill payment integration
- [ ] Push notifications for transactions
- [ ] Two-factor authentication (2FA)
- [ ] Profile picture upload
- [ ] Dark mode support
- [ ] Multi-language support

### Technical Improvements
- [ ] Connection pooling (HikariCP)
- [ ] Environment-based configuration
- [ ] Logging framework (Log4j/SLF4J)
- [ ] Unit testing (JUnit)
- [ ] Build automation (Maven/Gradle)
- [ ] Docker containerization
- [ ] REST API development
- [ ] Mobile app integration

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. **Commit your changes**
   ```bash
   git commit -m 'Add some AmazingFeature'
   ```
4. **Push to the branch**
   ```bash
   git push origin feature/AmazingFeature
   ```
5. **Open a Pull Request**

### Coding Standards
- Follow Java naming conventions
- Add JavaDoc comments for public methods
- Keep methods focused and concise
- Use meaningful variable names
- Handle exceptions appropriately

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Your Name** - *Initial work* - [YourGitHub](https://github.com/yourusername)

## 🙏 Acknowledgments

- Java Swing documentation
- MySQL community
- JavaMail API contributors
- Stack Overflow community
- All contributors and testers

## 📧 Contact

For questions, suggestions, or issues:

- **Email**: your.email@example.com
- **GitHub**: [@yourusername](https://github.com/yourusername)
- **Project Link**: [https://github.com/yourusername/ezwallet-java](https://github.com/yourusername/ezwallet-java)

---

<div align="center">

### ⭐ Star this repository if you find it helpful!

Made with ❤️ by Yashmika

</div>
