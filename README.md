<h1 align="center">
    Persona CRUD
</h1>

<h2 align="center">🚧 Under construction... 🚧</h2>

<h4 align="center">
  A VueJs and Spring Boot application with H2 database to manager users.
</h4>

## 🎯 To do
- [x] (Backend) Create a docker image
- [ ] (Backend) Finish unit tests
- [ ] (Backend) Create documentation (Swagger)
- [x] (Frontend) Include form validation
- [x] (Frontend) Handle errors returned by the backend

## ✔ Features
- List, create, delete and update users
- Get github link by acessing "/source" route
- Block unauthorized access (basic authentication with existent username/password)
- Validates the request data on the backend
- Blocks the creation of a user with a CPF that already exists in the database
- Stores creation date and last update

## :information_source: How To Use

You can use Docker to run the application.
```bash
# backend
$ docker pull alexxfreitag/personas-crud-api
$ docker run -p 9090:9090 alexxfreitag/personas-crud-api

# frontend
$ docker pull alexxfreitag/personas-crud-client
$ docker run -p 8080:8080 alexxfreitag/personas-crud-client
```

To clone and run this application locally, you'll need Git, Maven and Yarn installed on your computer. From your command line:

```bash
# Clone this repository
$ git clone https://github.com/alexxfreitag/personas-crud/

# Go into the repository
$ cd personas-crud

# Go into the backend folder, install dependencies and start the server
$ cd backend/
$ mvn clean package
$ mvn spring-boot:run

# Go into frontend folder, install dependencies and start the client
$ cd frontend/
$ yarn install
$ yarn serve
```

After this, you'll be able to acess the backend with http://localhost:9090 and the frontend with http://localhost:8080.

<p align="center">
  <a href="https://github.com/alexxfreitag/personas-crud/blob/master/.github/PersonaCRUDRoutes.json" target="_blank"><img src="https://insomnia.rest/images/run.svg" alt="Run in Insomnia"></a>
</p>
