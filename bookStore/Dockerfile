# Use an official OpenJDK image
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Install Maven (if mvnw is not used)
RUN apt update && apt install -y maven

# Build the application
RUN mvn clean package -DskipTests

# Expose port (change if your app runs on another port)
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "target/*.jar"]
