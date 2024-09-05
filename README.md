# HEFESTO

![HEFESTO Logo](https://via.placeholder.com/150?text=HEFESTO)

## IP Geolocation and Name Nationality Service

[![Java Version](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

HEFESTO is a robust Java-based web application that provides IP geolocation and name nationality services. Built with Spring Boot and leveraging modern Java 17 features, this project offers a scalable and efficient solution for retrieving geographical information based on IP addresses and determining probable nationalities for given names.

## Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Usage Examples](#usage-examples)
- [Configuration](#configuration)
- [Development](#development)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features

- **IP Geolocation**: Retrieve detailed geographical information for any given IP address.
- **Name Nationality**: Determine the probable nationality of a given name.
- **RESTful API**: Well-documented API endpoints using OpenAPI 3.0 (Swagger).
- **Input Validation**: Ensures data integrity with comprehensive input validation.
- **Observability**: Utilizes Spring Boot Actuator and Micrometer for enhanced monitoring and metrics.

## Technology Stack

- Java 17
- Spring Boot 3.3.2
- Spring WebFlux
- Swagger (OpenAPI) 3.0
- Lombok
- MapStruct
- Gradle

## Getting Started

### Prerequisites

- JDK 17 or later
- Gradle 7.x or later

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/hefesto.git
   cd hefesto
   ```

2. Build the project:
   ```
   ./gradlew build
   ```

### Running the Application

To run the application locally:

```
./gradlew bootRun
```

The application will start on `http://localhost:8080` by default.

## API Documentation

Once the application is running, you can access the Swagger UI to explore and test the API endpoints:

```
http://localhost:8080/swagger-ui.html
```

### Available Endpoints

1. IP Geolocation
    - GET `/geo/{ip}/info`: Retrieve geolocation information for a given IP address.

2. Name Nationality
    - GET `/discover/{name}/info`: Retrieve nationality information for a given name.

## Usage Examples

### Retrieving IP Geolocation Information

```bash
curl -X GET "http://localhost:8080/geo/192.0.2.1/info" -H "accept: application/json"
```

### Retrieving Name Nationality Information

```bash
curl -X GET "http://localhost:8080/discover/John/info" -H "accept: application/json"
```

## Configuration

The application can be configured using the `application.properties` or `application.yml` file located in the `src/main/resources` directory. Key configuration options include:

- `server.port`: The port on which the application runs (default: 8080)
- `logging.level.root`: The root logging level (default: INFO)

For a complete list of configuration options, please refer to the [Configuration Guide](docs/CONFIGURATION.md).

## Development

### Code Style

This project follows the Google Java Style Guide. Please ensure your code adheres to these standards before submitting pull requests.

### Testing

To run the tests:

```bash
./gradlew test
```

## Contributing

We welcome contributions to HEFESTO! Please read our [Contributing Guide](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Sebastian Vega

---

© 2024 HEFESTO. All Rights Reserved.