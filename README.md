# escape-room-monitoring-system-backend
[![Create and publish a Docker image](https://github.com/rostekus/escape-room-monitoring-system-backend/actions/workflows/ci.yaml/badge.svg)](https://github.com/rostekus/escape-room-monitoring-system-backend/actions/workflows/ci.yaml)
## Build and Run 
- Clone the repository:
```bash
  git clone https://github.com/rostekus/escape-room-monitoring-system-backend
```

- Navigate to the folder:
```bash
  cd escape-room-monitoring-system-backend
```
- Create a .env file based on .env.template:
```bash
  cp .env.template .env
```
- Fill up the .env file using your favorite text editor:
```bash
  nvim .env
```
- To build, run:
```bash
  docker-compose build 
```
- To run the containers, use:
```bash
  docker-compose up 
```

## Development

It is not very convenient to build a Docker container every time you work on a feature. Therefore, it is a good idea to start the Postgres container separately using the following command:
```bash
  docker run --name my-postgres-container -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=<YOUR_PASSWORD> -e POSTGRES_DB=escaperoom -p 5432:5432 -d postgres
```
Then, use Maven to build the project. You need to specify the environment variables from **env.template** in the **src/main/resources/application.properties** file.

Note that, then you need to change database URI to:
```bash
  jdbc:postgres:/localhost:5432/escaperoom
```
Now, you can use your IDE to build and run the project, or you can use Maven with the following command:
```bash
  mvn clean package
```
If the build is successful, navigate to the target directory:
```bash
  cd target
```
Run the JAR file using the following command:
```bash
  java -jar escape-room-api.jar 
```
