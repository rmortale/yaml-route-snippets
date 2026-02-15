
# Camel example using Kafka, Confluent Schema Registry and Avro message format


The `org.acme` dependency are Java classes for the Avro schema.avsc!

Run with Apache camel cli:

```bash
camel run * --dev --dep=io.confluent:kafka-avro-serializer:7.9.1 --dep=org.acme:products-lib:1.0.0-SNAPSHOT --repos=https://packages.confluent.io/maven
```

