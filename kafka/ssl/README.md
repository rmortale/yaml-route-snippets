# Kafka Camel SSL example

This example shows how Camel can be used to connect to a generic Kafka broker that uses `SSL`.

## Prerequisite

- A Kafka broker configured to use SSL for encryption and authentication respectively. It should use the `SSL` authentication mechanism in order to use this example. 
- You will also need the kafka bootstrap URL and an SSL key and certificate. You will need to edit the `application.properties` file, setting `camel.component.kafka.brokers` to the kafka bootstrap server URL; 


## Run a consumer

Now, open another shell and run the consumer integration using the command:

```
camel run SaslSSLKafkaConsumer.java application.properties --dev
```

