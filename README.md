# Library Management System (Java) – Submission Package

**Author:** Lalam Mishra  
**Date:** 2025-08-14 14:58

## 1) Problem Statement
Build a minimal console-based Library Management System to track books and basic circulation actions (issue/return).

## 2) Tech Stack
- Language: Java 8+
- Build: Single-file (no external libraries)
- I/O: Console (Scanner)

## 3) Features
- View all books (ID, Title, Issued status)
- Issue a book by ID
- Return a book by ID
- Search by keyword in title
- Seed data for quick demo

## 4) How to Run
```
cd src
javac LibrarySystem.java
java LibrarySystem
```

## 5) Sample Session
```
=== Library Management System ===
1. View Books
2. Issue Book
3. Return Book
4. Search by Title
5. Exit
Choose: 1
ID: 1, Title: Java Basics, Issued: false
ID: 2, Title: Python for Beginners, Issued: false
ID: 3, Title: Data Structures, Issued: false
```

## 6) Design Notes
- Simple OOP: Book class + LibrarySystem controller
- Data in-memory using ArrayList
- Input validation for integers
- Easily extensible: add persistence (JDBC), users, due dates

## 7) Complexity
- View/Search: O(n) over books
- Issue/Return by ID: O(n) linear scan (replaceable with HashMap for O(1))

## 8) Test Ideas
- Issue available book → status changes to true
- Issue already issued book → appropriate message
- Return an issued book → status changes to false
- Search with no results → “No matches.”

## 9) Future Work
- Persist data to DB (SQLite/MySQL)
- Fines/overdue logic, users/roles, reports
- Unit tests (JUnit)