# 🧠 Microservices-Based Quiz Project
This project is a comprehensive microservices-based system designed to manage quizzes and questions. It consists of multiple services, including a service registry, API gateway, quiz service, question service, and data access objects (DAOs) for interacting with the database. The system is built using Java and utilizes Spring Boot, Spring Cloud, and other relevant frameworks to provide a robust and scalable architecture.

## 🚀 Features
- **Service Registry**: Manages and keeps track of available services in the system, allowing for service discovery and communication between different microservices.
- **API Gateway**: Acts as an entry point for clients, routing requests to appropriate microservices and handling security, authentication, and other cross-cutting concerns.
- **Quiz Service**: Encapsulates the business logic related to quizzes, providing methods for creating, reading, updating, and deleting quizzes, as well as calculating quiz scores and retrieving quiz questions.
- **Question Service**: Encapsulates the business logic related to questions, offering methods for creating, reading, updating, and deleting questions, as well as validating question answers and retrieving questions by type.
- **Data Access Objects (DAOs)**: Provide a standardized interface for accessing and manipulating quiz and question data in the database, decoupling the business logic from the database implementation.

## 🛠️ Tech Stack
- **Java**: The primary programming language used for developing the microservices.
- **Spring Boot**: A framework used for building the microservices, providing a simplified approach to configuring and running the applications.
- **Spring Cloud**: A set of frameworks and tools used for building cloud-native applications, including service discovery, configuration management, and circuit breakers.
- **Database**: A relational database management system used for storing quiz and question data.
- **API Gateway**: Built using Spring Cloud Gateway, providing a single entry point for clients and handling requests to the microservices.
- **Service Registry**: Implemented using Netflix Eureka, allowing for dynamic service registration and discovery.

## 📦 Installation
To set up the project, follow these steps:
1. Clone the repository to your local machine.
2. Install the required dependencies, including Java, Spring Boot, and Spring Cloud.
3. Configure the database connection properties in the `application.properties` file.
4. Start the service registry and API gateway applications.
5. Deploy the quiz and question services to the service registry.

## 💻 Usage
To use the system, follow these steps:
1. Register a new quiz by sending a POST request to the quiz service with the quiz details.
2. Add questions to the quiz by sending a POST request to the question service with the question details.
3. Retrieve a quiz by sending a GET request to the quiz service with the quiz ID.
4. Submit answers to a quiz by sending a POST request to the quiz service with the answer details.
5. Retrieve the quiz results by sending a GET request to the quiz service with the quiz ID.
