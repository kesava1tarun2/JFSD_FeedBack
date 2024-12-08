To set up the **Student Feedback and Evaluation System** using **Eclipse** or **Spring Tool Suite (STS) 4**, follow the steps below:

# README: Student Feedback and Evaluation System (Eclipse/STS Setup)

## Overview

This project is a web application designed to collect and analyze student feedback on courses, instructors, and institutional services. The system provides insights and data to improve the educational experience and address areas for improvement.

## Features

### Admin (Teacher/Institution)
- **Create Feedback Forms**: Admins can create custom feedback forms for courses, instructors, and institutional services.
- **Analyze Feedback**: Provides detailed feedback analysis using charts and reports.
- **Improve Course Content**: Admins can enhance teaching methods and course content based on feedback.

### User (Student)
- **Submit Feedback**: Students can provide anonymous feedback on courses and instructors.
- **View Feedback Results**: Students can access aggregated results of their peers' feedback.

## Prerequisites

- **Eclipse IDE** or **Spring Tool Suite (STS) 4** installed.
- **Java JDK** (version 11 or later).
- **Maven** for dependency management.
- **MySQL** or **H2 Database** (optional, if not using an in-memory database).

## Technology Stack

- **Backend**: Spring Boot, Java
- **Frontend**: Thymeleaf, HTML, CSS, JavaScript
- **Database**: H2 (in-memory) or MySQL
- **Build Tool**: Maven
- **Security**: Spring Security for user authentication
- **Charts**: Chart.js for feedback analysis visualization

---

## Steps to Set Up the Project in Eclipse/STS

### 1. **Clone the Repository**

Clone the project from GitHub or your repository source:

```bash
git clone https://github.com/your-repository/student-feedback-system.git
```

### 2. **Import into Eclipse or STS**

- Open **Eclipse** or **Spring Tool Suite (STS)**.
- Click on **File** → **Import** → **Existing Maven Projects**.
- Navigate to the directory where you cloned the project and select the **pom.xml** file.
- Click **Finish**.

### 3. **Install Dependencies**

Once the project is imported, Maven will automatically download the necessary dependencies from the `pom.xml` file. If not, you can right-click on the project and select **Maven** → **Update Project**.

### 4. **Configure Database**

- **H2 Database**: If you are using the H2 in-memory database (default configuration), no additional setup is needed.
- **MySQL Database**: 
    - Install MySQL on your machine.
    - Create a new database, e.g., `student_feedback`.
    - Update the `application.properties` file in the `src/main/resources` folder with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_feedback
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 5. **Run the Application**

- In Eclipse or STS, right-click on the project in the **Project Explorer**.
- Select **Run As** → **Spring Boot App**.
- The application will start on `http://localhost:8080`.

### 6. **Access the Application**

- Open a browser and go to `http://localhost:8080` to interact with the Student Feedback System.
- Admins can log in to create feedback forms and analyze results.
- Students can log in to provide feedback and view aggregated results.

## Directory Structure

- **src/main/java**: Contains the application’s backend code, including controllers, services, and entities.
- **src/main/resources**: Contains the configuration files, including `application.properties` for database setup.
- **src/main/resources/templates**: Contains Thymeleaf templates for frontend views.
- **src/main/resources/static**: Contains static files like CSS, JavaScript, and images.

## How to Use

1. **Admin**: 
   - Log in using admin credentials.
   - Create feedback forms for courses, instructors, and services.
   - View and analyze aggregated feedback data using charts and statistics.

2. **Student**:
   - Log in to provide anonymous feedback on courses, instructors, and services.
   - View aggregated feedback results to understand general sentiment.

## Contributing

We welcome contributions to improve the system. Feel free to:
- Fork the project.
- Report issues via GitHub Issues.
- Submit pull requests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.

---

By following these steps, you can set up and run the **Student Feedback and Evaluation System** in **Eclipse** or **Spring Tool Suite (STS)** 4. Enjoy building and contributing to the system!
