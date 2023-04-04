# escape-room-monitoring-system-backend

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