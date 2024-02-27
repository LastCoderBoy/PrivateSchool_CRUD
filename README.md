# Private School Information

## Configuration
In order to connect to your own database, follow these steps:
- Open the `application.yml` file located in the `src/main/resources` directory.
- Update the following fields with your own information:
  ```yaml
  spring:
    datasource:
      url: jdbc:mysql://localhost:3306/your_database_name
      username: your_username
      password: your_password
