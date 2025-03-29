#!/bin/bash
camel run --properties=ibm-devt.properties \
    --dependency=mvn:com.ibm.mq:com.ibm.mq.jakarta.client:9.4.2.0 \
    --dev infra.yaml MessageBridgeRoute.java

    # --dependency=mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:2.7.0 \
    # --dependency=mvn:org.apache.camel.quarkus:camel-quarkus-jms:3.18.0 \
    # --dependency=mvn:org.apache.camel.quarkus:camel-quarkus-jta:3.18.0 \
    # --dependency=mvn:io.quarkiverse.artemis:quarkus-artemis-jms:3.6.4 \
    