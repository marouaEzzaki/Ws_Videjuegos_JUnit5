# User and Video Game Management Application with JUnit Testing

## Description
This application is a user and video game management system that allows users to register, log in, and manage a list of video games. Users can add and list while ensuring data integrity and security.

## Features

### User Management
- **Registration and Access:** Users must be registered in a `usuarios.dat` file, with credentials stored in the format `USERNAME/PASSWORD`. Users can attempt to log in up to three times.
- **Add User:** Authenticated users can add new user records to the `usuarios.dat` file.

### Video Game Management
- **Add Video Game:** Users can add video games to a `videojuegos.txt` file, specifying the game name, company, and rating (score). Validations ensure proper input.
- **List Video Games:** Users can view all video games stored in the file in a readable format.

### Testing
- **JUnit Testing:** The application includes unit tests implemented with JUnit to ensure all features function correctly and maintain code quality. All tests must pass, and a coverage report should be generated to monitor test effectiveness.

## Non-Functional Requirements
- **Three-Layer Architecture:** The application follows a three-layer model: presentation, business, and data access.
