# 📚 Library Management System (Java OOP)

## Overview

This project is a console-based Library Management System developed in Java to strengthen my understanding of Object-Oriented Programming (OOP).

Instead of focusing only on Java syntax, this project emphasizes designing real-world systems by identifying objects, assigning responsibilities, and allowing those objects to collaborate.

This is my second OOP project after completing a Bank Management System.

---

## Features

- Add books
- Add members
- Search books
- Search members
- Issue books
- Return books
- Track book availability
- Prevent issuing unavailable books
- Prevent members from borrowing beyond the limit
- Validate transactions before updating system state

---

## OOP Concepts Used

- Classes & Objects
- Encapsulation
- Composition
- Object Collaboration
- Abstraction
- ArrayList Collections
- Object References
- Method Reusability
- Validation Logic
- Responsibility Separation

---

## Project Structure

```
Library
│
├── Book
│   ├── Stores book information
│   ├── Tracks availability
│   ├── Handles issue/return state
│
├── Member
│   ├── Stores member information
│   ├── Maintains borrowed books
│   ├── Borrow/Return operations
│
└── Library
    ├── Stores books
    ├── Stores members
    ├── Searches books
    ├── Searches members
    ├── Coordinates issue/return operations
```

---

## What I Learned

Through this project I learned:

- How to model a real-world system using objects
- Difference between a class and an object
- Difference between collections and objects
- Object ownership and composition
- Coordinating interactions between multiple objects
- Returning objects from methods
- Designing reusable search methods
- Separating responsibilities among classes
- Managing object state safely

---

## Challenges Faced

Some concepts were initially difficult:

- Understanding object references
- Deciding which class should own which responsibility
- Difference between storing IDs and storing objects
- Designing interactions between multiple classes
- Coordinating object collaboration

These challenges helped improve my OOP thinking.

---

## Current Limitations

This project intentionally keeps the design simple for learning purposes.

Future improvements include:

- Duplicate detection using IDs
- Exception handling
- Better separation of business logic and presentation
- Transaction history
- Book categories
- Fine calculation for late returns
- File/database persistence
- Improved search functionality
- JUnit testing

---

## Technologies Used

- Java
- Object-Oriented Programming
- ArrayList Collections

---

## Future Goals

This project is part of my Java learning journey.

My next goals are:

- Improve object-oriented design
- Learn Java Collections deeply
- Exception Handling
- File Handling
- JDBC
- Spring Boot
- Build larger real-world backend projects

---

## Author

**Mohan Gangula**

Built as part of my Java OOP learning journey.