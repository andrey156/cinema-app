# cinema-app
CinemaApp

Introduction:
CinemaApp is a web application that allows users to register and manage their personal cart for adding movie tickets, selecting cinema halls, searching movie screenings by date and movie, and more. It provides user authentication with login and password. Users are assigned roles (USER/ADMIN), with additional privileges for ADMIN. The application utilizes the Spring Framework, Hibernate ORM Framework, Apache Tomcat, and MySQL database.

Features:
1. User Registration and Authentication
2. Personalized Shopping Cart
3. Movie Screening Search Functionality
4. Role-Based Access Control (USER/ADMIN)
5. Administration Functionality for Managing Cinema Halls, Users, Movies, etc. (ADMIN)
6. Database-Driven Operations

Technologies:
1. Java 17
2. Tomcat
3. Spring Framework - MVC, Security
4. Hibernate ORM Framework
5. MySQL
6. Maven

Project Structure:
src/main/java: Contains the Java source code for the application
src/main/resources: Contains configuration files and resources

Getting Started:
To run the application, ensure that you meet the following prerequisites:
1. Java 17 or later
2. Apache Tomcat 9 (recommended version: 9.0.73)
3. MySQL 8 or later

Installation steps:
1. Clone the repository using the command: git clone https://github.com/andrey156/cinema-app
2. Open the project in your preferred IDE and build it.
3. In the file src/main/resources/db.properties, update the following parameters with your own database details:
db.driver=YOUR_DRIVER
db.url=YOUR_URL
db.user=YOUR_USERNAME
db.password=YOUR_PASSWORD
4. Deploy the WAR file in Tomcat and start the application.

During the development of this project, the following best practices were followed:
Clear and concise naming conventions were used for variables, classes, and methods.
Code was organized into meaningful packages.
Defensive programming techniques were utilized to prevent bugs and exceptions.
Simplicity and readability were maintained for improved maintainability.

