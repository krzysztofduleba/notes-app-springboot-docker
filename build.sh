# Build the project
./mvnw clean package

# Build the Docker image
docker build -t notes-app .

# Start the Docker containers
docker-compose up -d
