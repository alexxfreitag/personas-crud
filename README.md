<h1 align="center">
    Persona CRUD
</h1>

<h2 align="center">🚧 Under construction... 🚧</h2>

<h4 align="center">
  A ReactJs and Spring Boot application with PostgreSQL to manager users.
</h4>

## 🎯 To do
- [ ] (Both) Create a docker image
- [ ] (Backend) Finish unit tests
- [ ] (Frontend) Include form validation
- [ ] (Frontend) Handle errors returned by the backend

## ✔ Features
- List, create, delete and update users
- Get github link by acessing "/source" route
- Block unauthorized access (basic authentication with existent username/password)
- Validates the request data on the backend
- Blocks the creation of a user with a CPF that already exists in the database
- Stores creation date and last update

## :information_source: How To Use

To clone and run this application, you'll need Git, Maven and Yarn installed on your computer. From your command line:

```bash
# Clone this repository
$ git clone https://github.com/alexxfreitag/personas-crud/

# Go into the repository
$ cd personas-crud

# Go into the backend folder, install dependencies and start the server
$ cd backend/
$ mvn install
$ ./mvnw spring-boot:run

# Go into frontend folder, install dependencies and start the client
$ cd frontend/
$ yarn install
$ yarn start
```
