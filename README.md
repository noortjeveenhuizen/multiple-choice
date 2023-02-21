# Multiple Choice Application
This is a Java web application that provides a multiple-choice quiz. The application allows users to select from a set of pre-defined questions and submit their answers. The application will then provide feedback on the user's answers.

## Getting Started
To get started with this project, you will need to have the following installed:

- Java 8 or higher
- Maven
- An IDE such as Eclipse or IntelliJ IDEA

Once you have the required software installed, you can clone this repository to your local machine and import it into your IDE.

## Running the Application
To run the application, you can execute the following command from the root directory of the project:


```bash
mvn spring-boot:run
```
This will start the web server and make the application available at http://localhost:8080.

## Endpoints
The application provides the following endpoints:

- GET /api/questions: Returns a list of pre-defined questions for the quiz.
- POST /api/check-answers: Accepts a JSON payload containing the user's answers to the quiz questions and returns feedback on their answers.

## Technologies Used
This application was built using the following technologies:

- Java
- Spring Boot
- Maven


This application was created by Noortje Veenhuizen. If you have any questions or feedback, please feel free to get in touch.




