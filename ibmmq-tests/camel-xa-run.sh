jbang '-Dcamel.jbang.version=4.13.0' camel@apache/camel run --dev \
    --name=camel-xa \
    --runtime=quarkus \
    --quarkus-version=3.24.1 \
    --dependency=camel-jta \
    --dependency=mvn:com.ibm.mq:com.ibm.mq.jakarta.client:9.4.2.0 \
    --dependency=mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:2.8.0 \
    IbmMqXa.java application.properties 
