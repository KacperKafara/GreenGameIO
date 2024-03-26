# GreenGameIO
The "GreenGameIO", built with Spring Boot, PostgreSQL and React, is an application featuring a variety of mini-games such as Plumber and Snake. Our responsibility was to implement an authentication module, enabling users to create accounts, log in, reset passwords, and allowing administrators to manage user accounts.
## How to run
- Clone repository
```
git clone https://github.com/KacperKafara/GreenGameIO.git
```
- Run docker containers with MongoDB and PostgreSQL
```
cd docker
docker compose up -d
```
 - Run Spring Boot application
```
cd ..
./mvnw spring-boot:run
```
 - Run React application
```
cd web
```
1. Install dependencies with  `yarn`
2. Run dev server with  `yarn dev`
---
Developers:
- Kacper Kafara github.com/KacperKafara
- Konrad Koza github.com/konradkoza
