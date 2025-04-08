## 💻 About the Project

This project was designed and developed following the principles of clean architecture, multi-module spring, reactive manifesto, circuit breakers, and asynchronous processing.

Java Version: 17

Spring Boot Version: 3.0.4

---
### To build a Docker image for this application.

```
docker build -t bff-chave .
```

### To run the required Redis Docker container.

```
docker run -d -p 6379:6379 redis
```

### To run the project.

```
docker run -p 8081:8081 bff-chave
```

### To build the project and run the application.

```
mvn clean package
```

```
cd .\target\
java -jar .\bff-chave.jar
```

### To access the application’s Swagger UI.

http://localhost:8081/swagger-ui/index.htm

## ⚙️ Structure

![alt text](https://www.zup.com.br/wp-content/uploads/2021/10/Clean-Architecture-3.png)
![Clean-Architecture-3](/uploads/b4cca35a0299a38999cf96b09393b6d9/Clean-Architecture-3.png)

Clean Architecture is an approach to software architecture that aims to separate concerns into independent and isolated layers, each with a specific responsibility. The main goal is to make the software easy to understand, modify, test, and maintain.

Clean Architecture is based on the dependency inversion principle, which states that the inner layers should depend on the outer layers only through interfaces, not concrete implementations. This allows the inner layers to be isolated from changes in the outer layers, facilitating maintenance and evolution of the software.

In Clean Architecture, all implementations between modules are done through interfaces, which allows each module to have its own implementation without affecting other modules. This ensures a clear separation between the layers of the application and guarantees that business rules are completely separate from technological implementation. Using interfaces to define contracts between different parts of the application can add a layer of complexity to the code, but this approach brings many benefits, such as better separation of concerns and easier system maintenance and evolution. Additionally, using interfaces helps ensure interoperability between different components and reduces coupling between them.

Although this approach may increase complexity in the code, the benefits often outweigh the costs, especially in larger and more complex projects. Moreover, there are tools and patterns that can help manage this complexity, such as dependency injection, testing frameworks, and static code analysis tools.

In the clean architecture with a division into three modules (app, core, and infrastructure), each module has specific responsibilities:

- The "core" module is responsible for containing the business rules and entities of the application, without depending on external libraries or frameworks. This is where the heart of the application lies, and the business logic is defined.

- The "infrastructure" module is responsible for implementing the interfaces defined in the "core" module. This is where the persistence layers (such as database access), integrations with external systems, email sending, and other functionalities that are not part of the core business logic are implemented. If the infrastructure module needs to know the core domain entities, domain interfaces should be created. These implementations in the infrastructure module should have no knowledge of the details of the core entities. They should depend on the domain entity interfaces defined in the core and convert these interfaces into appropriate formats for external communication.

- The "app" module is where the Spring Boot framework and classes responsible for exposing the application’s APIs reside. This is where controllers, services, and auxiliary classes specific to Spring Boot, such as security configurations, authentication, authorization, request validation, among other functionalities related to the presentation and infrastructure layers of the system, are found.

By following this structure of responsibility division, we have an application with a clear separation of concepts and a more organized and scalable architecture. The "app" module depends on the "core" and "infrastructure" modules, but the "core" and "infrastructure" modules do not depend on the "app" module, allowing for better testability and maintenance of the application.

### 📋 How the application works

1. The controller receives the calls and applies its rules.
2. The controller executes the UseCaseExecutor to return a CompletableFuture, running a chain of asynchronous operations in a data processing pipeline.
3. The first action in this chain is executing the mappers for @RequestBody.
4. The second action executes the use case.
   The use case follows basic principles. It transforms the input into an object for the Gateway, executes the Gateway, and finally transforms the response into an outputMapper.
5. The third action returns the result of the use case with "outputMapper."

Example:

```
return CompletableFuture
                .supplyAsync(() -> input)
                .thenApplyAsync(useCase::execute)
                .thenApplyAsync(outputMapper);
```

For all exceptions, we have a @ControllerAdvice "ResponseExceptionHandler" used to centralize the exception handling logic in a Spring application.
@ControllerAdvice is an annotation in Java that defines a global component to handle exceptions across all classes annotated with @Controller or @RestController.
The use of @ControllerAdvice is very helpful for handling exceptions in a centralized and consistent manner throughout the application, without the need to repeat the same code in every controller.

### 📦 Build

The project is compiled into the target folder in the project root, with the compiled project named bff-chave.jar.

In the context of a multi-module Spring Boot project, the Maven Assembly Plugin can be used to create a single JAR or ZIP file containing all the project modules and their dependencies. This simplifies the deployment process to a production environment, as it is not necessary to deploy each module separately.

Additionally, the Maven Assembly Plugin can also be configured to create different distributions of the application, depending on the project needs. For example, a ZIP file can be created that contains only the application's configuration files, allowing system administrators to update the configurations without having to redeploy the entire application.

In summary, the Maven Assembly Plugin is useful in multi-module Spring Boot projects to simplify the deployment and distribution process of the application in a production environment.

### 📋 UseCaseExecutors

The code presented defines a generic method called "execute," which is part of a service layer in a Spring Boot application.

The method signature includes three generic parameters:

"RX": represents the expected return type of the method. This type is defined by the developer when calling the "execute" method.
"I": represents the type of input expected by the use case to be executed. The use case is represented by the "useCase" parameter.
"O": represents the expected output type of the use case to be executed.

The "<>" before the CompletableFuture<RX> represent the use of generics in the method definition. In this case, "<RX, I extends UseCase.InputValues, O extends UseCase.OutputValues>" defines three generic parameters:

"RX" is the return type the function will produce.

"I extends UseCase.InputValues" is the generic type representing the input object passed to the "useCase" function to execute.

"O extends UseCase.OutputValues" is the generic type representing the output object produced by the function execution.

This generic definition allows the function to execute any use case (represented by the "useCase" parameter), which takes an object of type "I" as input and produces an object of type "O" as output, and maps the output object (of type "O") to the expected return type (of type "RX") using the outputMapper function.

The "execute" method receives three arguments:

"useCase": an instance of an object that implements the "UseCase" interface. This interface defines an "execute" method that takes an object of type "I" and returns an object of type "O."
"input": an instance of type "I," which is the input object for the use case. In this case, it receives a function to return the expected value as input.
"outputMapper": a function that maps the output object (of type "O") from the use case to the expected return type (of type "RX").
The "execute" method returns a CompletableFuture<RX>, which represents an asynchronous operation that can run concurrently with other operations in the Spring Boot application. The implementation of the method uses "CompletableFuture" to perform the processing asynchronously, which can improve the application’s performance and prevent unnecessary blocking.

In summary, the "execute" method is responsible for executing a use case asynchronously and mapping the result to the expected return type. This approach helps decouple the application layers and allows operations to be executed in parallel.

### 📋 Design Pattern

To clarify a common doubt among developers, let's briefly address mappers, builders, and factories:

Mappers are used to convert objects from one type to another, builders are used to create complex objects step by step, and factories are used to create objects without specifying the exact class of the object being created.

### 📋 SOLID

SOLID is a set of five software design principles based on object-oriented practices and aimed at helping developers create more flexible, scalable, and maintainable systems.

In Clean Architecture, the application is divided into layers, with each layer having a specific responsibility. SOLID is applicable to all layers, but we’ll focus on its use in the business layer (core), where the SOLID principles can be best leveraged.

- Single Responsibility Principle (SRP): Each class should have a single responsibility. In Clean Architecture, this means that use cases should have a single responsibility and should not be involved in infrastructure concerns like database access or external API calls.

- Open-Closed Principle (OCP): Classes should be open for extension but closed for modification. In Clean Architecture, this means that domain entities should be designed to allow extension without altering existing code.

- Liskov Substitution Principle (LSP): Classes should be replaceable by their subclasses. In Clean Architecture, this means that objects implementing the use case interfaces should be replaceable with other implementations without affecting the application's behavior.

- Interface Segregation Principle (ISP): Interfaces should be designed to meet the specific needs of the clients. In Clean Architecture, this means use case interfaces should be fine-grained and specific to each client’s needs.

- Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. In Clean Architecture, this means the business layer (core) should not directly depend on the infrastructure layer (adapters), but rather on interfaces defining contracts between the layers. This allows the business layer to be tested independently of the infrastructure.

In summary, SOLID in Clean Architecture means designing each layer so that each class or interface has a single responsibility and can be easily substituted without affecting application behavior. This makes the system more flexible, scalable, and easier to maintain.

### 📋 CompletableFuture

CompletableFuture is a class in Java introduced in version 8 that is heavily used in asynchronous and concurrent applications. It provides a more flexible and powerful way to work with asynchronous tasks compared to older mechanisms such as Threads and Runnable.

In the context of Spring Boot, CompletableFuture is used to perform asynchronous operations on a separate thread, allowing the main thread of the application to continue processing other requests without being blocked. This is particularly useful for operations that involve I/O or other forms of waiting, as it allows the application to keep processing other requests while the asynchronous operation is running.

Spring Boot's CompletableFuture is even more powerful than Java's native implementation because it provides additional features, such as the ability to perform multiple asynchronous operations in parallel and combine their results. Additionally, Spring Boot offers a variety of tools to work with CompletableFuture, such as the @Async annotation, which allows methods marked with it to execute asynchronously in a separate thread.

In summary, Spring Boot's CompletableFuture is a powerful tool for handling asynchronous tasks in applications, allowing them to be executed efficiently and flexibly without blocking the application's main thread.

### 📋 What Developers Usually Get Wrong When Working with Clean Architecture

Developers can make several mistakes when implementing Clean Architecture, but some of the most common errors include:

1. Mixing business logic with implementation details: It's important to keep the business logic isolated from implementation details, so that the business logic can be easily modified without affecting the overall system structure.

2. Not following the separation of responsibilities between layers: One of the key benefits of Clean Architecture is that it provides a clear structure to separate responsibilities between different layers of the system. If this separation is not properly followed, it can lead to a confusing and hard-to-maintain architecture.

3. Not using interfaces to communicate between layers: As mentioned earlier, it's important to use interfaces to communicate between layers of the system. If this is not done, it can create tight coupling between the layers, making the system less flexible and harder to modify.

4. Not testing the system properly: Clean Architecture emphasizes the importance of automated tests, which are a key part of the development process. If tests are not written properly or run regularly, it can lead to hard-to-find and difficult-to-fix bugs.

5. Not maintaining the system structure over time: Clean Architecture should be seen as an ongoing development process, not a one-time solution. If the system structure is not updated regularly to reflect changes in business requirements or technologies, it can become outdated and hard to maintain.


### 📋 Health Check

Spring Boot Actuator provides monitoring and management endpoints that allow you to check the health of the application. The /actuator/health/* endpoints are provided by Spring Boot Actuator to check the "liveness" of the application. It verifies if the application is responding to requests and is healthy enough to continue processing requests.

Endpoints:
1. /actuator/health/liveness
2. /actuator/health/readiness
3. /actuator/health