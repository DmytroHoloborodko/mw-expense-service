FROM openjdk:11
EXPOSE 8080
ADD build/libs/expense-0.0.1-SNAPSHOT.jar app.jar
ADD sa-my-wallet-357616-33dc3721140f.json sa-my-wallet-357616-33dc3721140f.json
ENTRYPOINT ["java", "-jar", "app.jar"]
