# XML-Based Database Migration Tool

## 📝 Description
This project allows migration of table schema and data from XML into a relational database (like SQLite, PostgreSQL, or MySQL). It reads table definitions and records from `schema.xml` and `data.xml`.

## 🚀 Features
- Reads and parses XML structure and content
- Creates tables and inserts records into the destination DB
- Simple JDBC-based Java implementation

## 📂 Structure
- `src/` - Java source code
- `resources/` - XML files for schema and data
- `config.properties` - DB credentials

## ⚙️ Run Instructions
1. Update `config.properties` with your DB details.
2. Compile and run the project using your Java IDE or CLI.

## 📦 Requirements
- Java 8+
- JDBC Driver for your target DB (e.g., SQLite, MySQL)

## 📁 Example XML
See `resources/schema.xml` and `resources/data.xml`.
