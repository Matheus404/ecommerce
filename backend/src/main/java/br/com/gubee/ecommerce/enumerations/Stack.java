package br.com.gubee.ecommerce.enumerations;

public enum Stack {
	
    JAVA_10("Java 10"), 
    KOTLIN("Kotlin"), 
    KAFKA("Kafka"), 
    EVENT_STREAM("Event Stream"), 
    REDIS("Redis"),
    MONGODB("MongoDB"),
    NODEJS("NodeJS"),
    CASSANDRA("Cassandra"),
    PIG("Pig");
	
    private String descricao;

    Stack(String valor) {
        descricao = valor;
    }

    public String getDescricao() {
        return descricao;
    }
	
}
