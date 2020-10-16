mvn clean package
java -javaagent:transaction-agent/target/transaction-agent-1.0.0-SNAPSHOT.jar -jar transaction-service/target/transaction-service-1.0.0-SNAPSHOT.jar
