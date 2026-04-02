# LearningSpringboot

A Spring Boot learning project from CodingShuttle that demonstrates core Spring Boot concepts, dependency injection, and service-oriented architecture.

## Project Overview

This is an educational Spring Boot application designed to teach fundamental concepts of the Spring Framework, including application lifecycle, component annotations, and service layer implementation. The project includes a payment processing service as a practical example.

## Technology Stack

| Technology | Version |
|-----------|---------|
| Java | 21 |
| Spring Boot | 4.0.4 |
| Maven | 3.6+ |
| H2 Database | Latest (Runtime) |

## Project Structure

```
LearningSpringboot/
├── src/
│   ├── main/
│   │   ├── java/com/codingshuttle/LearningSpringboot/
│   │   │   ├── LearningSpringbootApplication.java    # Main Spring Boot application entry point
│   │   │   └── PaymentService.java                   # Service layer for payment processing
│   │   └── resources/
│   │       ├── application.properties                 # Application configuration
│   │       ├── static/                               # Static resources (CSS, JS, images)
│   │       └── templates/                            # Thymeleaf templates (if needed)
│   └── test/
│       └── java/com/codingshuttle/LearningSpringboot/
│           └── LearningSpringbootApplicationTests.java
├── pom.xml                                            # Maven configuration
├── mvnw / mvnw.cmd                                    # Maven wrapper
├── HELP.md                                            # Spring Boot generated help
└── README.md                                          # This file
```

## Dependencies

### Maven Dependencies

#### Runtime
- **spring-boot-starter-webmvc** - Spring Web MVC framework for building web applications
- **h2** - Lightweight embedded relational database (runtime scope)

#### Testing
- **spring-boot-starter-webmvc-test** - Spring Boot testing support with WebMvc testing utilities

See [pom.xml](pom.xml) for detailed dependency configuration.

## Core Components

### 1. LearningSpringbootApplication
**File:** [src/main/java/com/codingshuttle/LearningSpringboot/LearningSpringbootApplication.java](src/main/java/com/codingshuttle/LearningSpringboot/LearningSpringbootApplication.java)

Main application class that:
- Bootstraps the Spring Boot application
- Implements `CommandLineRunner` for executing code at application startup
- Uses `@Autowired` annotation to inject the `PaymentService` dependency
- Demonstrates automatic dependency injection and application lifecycle management

```java
@SpringBootApplication
public class LearningSpringbootApplication implements CommandLineRunner {
    @Autowired
    PaymentService paymentService;
    
    public static void main(String[] args) {
        SpringApplication.run(LearningSpringbootApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        paymentService.pay(100);
    }
}
```

### 2. PaymentService
**File:** [src/main/java/com/codingshuttle/LearningSpringboot/PaymentService.java](src/main/java/com/codingshuttle/LearningSpringboot/PaymentService.java)

Service component that:
- Marked with `@Service` annotation to indicate it's a service-layer component
- Managed by Spring's component scanning and dependency injection
- Processes payment transactions
- Demonstrates the service layer pattern

```java
@Service
public class PaymentService {
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount);
    }
}
```

## Prerequisites

- **Java Development Kit (JDK) 21** or higher
- **Maven 3.6.0** or higher (or use the included Maven wrapper)
- **Git** (for version control)

## Setup and Installation

### Clone the Repository
```bash
git clone <repository-url>
cd LearningSpringboot
```

### Build the Project
Using Maven wrapper (recommended):
```bash
./mvnw clean compile
```

Or with system Maven:
```bash
mvn clean compile
```

### Run the Application

Using Maven wrapper:
```bash
./mvnw spring-boot:run
```

Or with system Maven:
```bash
mvn spring-boot:run
```

**Expected Output:**
```
Processing payment of $100
```

## Running Tests

Execute unit tests with:
```bash
./mvnw test
```

Or with system Maven:
```bash
mvn test
```

## Configuration

Application properties can be configured in [src/main/resources/application.properties](src/main/resources/application.properties)

### H2 Database Console (if web configuration is added)
When H2 is enabled, the database console is available at:
```
http://localhost:8080/h2-console
```

**Default Connection Settings:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (empty)

## Build and Package

Create an executable JAR file:
```bash
./mvnw clean package
```

The JAR file will be located in the `target/` directory. Run it with:
```bash
java -jar target/LearningSpringboot-0.0.1-SNAPSHOT.jar
```

## Project Artifacts

| Artifact | ID |
|----------|-----|
| Group ID | `com.codingshuttle` |
| Artifact ID | `LearningSpringboot` |
| Version | `0.0.1-SNAPSHOT` |

## Maven Wrapper

This project includes Maven Wrapper to ensure consistent Maven version across different environments:
- **mvnw** - Unix/Linux/Mac shell script
- **mvnw.cmd** - Windows batch script
- **.mvn/wrapper/** - Maven Wrapper configuration

## Learning Concepts Demonstrated

1. **Spring Boot Application Bootstrap** - Understanding how Spring Boot initializes the application
2. **Dependency Injection** - Using `@Autowired` for automatic dependency resolution
3. **Component Scanning** - Spring's automatic component discovery with `@Service` and `@SpringBootApplication`
4. **Service Layer Pattern** - Separating business logic into service components
5. **Application Lifecycle** - Running code at startup using `CommandLineRunner`
6. **Build Automation** - Maven for project management and dependency resolution

## Troubleshooting

### "Syntax error on token 'package', import expected"
Ensure package declarations come before import statements in Java files.

### "No embedded database found in the classpath"
Added H2 dependency to `pom.xml`:
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

### Maven Build Fails
- Clear Maven cache: `./mvnw clean`
- Update dependencies: `./mvnw dependency:resolve`
- Check Java version: `java -version` (should be 21+)

## Directory Explanation

| Directory | Purpose |
|-----------|---------|
| `src/main/java` | Main application source code |
| `src/main/resources` | Application configuration and static files |
| `src/test/java` | Unit test source code |
| `target/` | Compiled output and build artifacts |
| `.mvn/` | Maven Wrapper configuration |

## Git Configuration

This project uses a `.gitignore` file to exclude unnecessary files from version control:
- Build output (`target/`, `build/`)
- IDE configuration (`.idea/`, `.vscode/`)
- Maven wrapper cache (`.mvn/`)
- OS-specific files (`.DS_Store`)

## IDE Setup

### IntelliJ IDEA
1. Open project as Maven project
2. Maven dependencies will auto-download
3. Configure run configuration for `LearningSpringbootApplication`

### Visual Studio Code
1. Install "Spring Boot Dashboard" extension
2. Open project folder
3. Use the Maven extension for build/run commands

### Eclipse
1. Import as existing Maven project
2. Right-click project → Maven → Update Project

## Performance Considerations

- **Java 21**: Takes advantage of latest Java features and improvements
- **Embedded H2 Database**: Suitable for development and testing, not production
- **Spring Boot 4.0.4**: Latest features and security patches

## Future Enhancements

Potential areas for expansion:
- Add REST API endpoints with `@RestController`
- Implement database persistence with Spring Data JPA
- Add transaction management with `@Transactional`
- Create integration tests
- Add logging with SLF4J
- Implement validation with Bean Validation

## License

This is a learning project from CodingShuttle.

## Support

For issues or questions:
1. Check the Spring Boot documentation: https://spring.io/projects/spring-boot
2. Review CodingShuttle learning materials
3. Consult the [HELP.md](HELP.md) file

---

**Last Updated:** March 2026  
**Spring Boot Version:** 4.0.4  
**Java Version:** 21
