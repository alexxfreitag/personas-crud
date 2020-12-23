<h1 align="center">
    Persona CRUD
</h1>

<h2 align="center">🚧 Under construction... 🚧</h2>

<h4 align="center">
  A VueJs and Spring Boot application with H2 database to manager users.
</h4>

## 🎯 To do
- [ ] (Both) Create a docker image
- [ ] (Backend) Finish unit tests
- [ ] (Backend) Create documentation (Swagger)
- [ ] (Frontend) Include form validation
- [x] (Frontend) Handle errors returned by the backend

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
$ mvn clean package
$ ./mvnw spring-boot:run

OR

# Pull docker image from Docker HUB and run
$ docker pull alexxfreitag/personas-crud-api
$ docker run -p 9090:9090 alexxfreitag/personas-crud-api

# Go into frontend folder, install dependencies and start the client
$ cd frontend/
$ yarn install
$ yarn serve
```

<p align="center">
  <a href="https://github.com/alexxfreitag/personas-crud/blob/master/.github/PersonaCRUDRoutes.json" target="_blank"><img src="https://insomnia.rest/images/run.svg" alt="Run in Insomnia"></a>
</p>
