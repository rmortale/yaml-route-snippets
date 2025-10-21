# IBM MQ TLS examples



### Creating self signed certificates by using `openssl`

See [here](https://github.com/ibm-messaging/mq-dev-patterns/blob/master/README.md) for more details.


## Run MQ container with TLS enabled

Point volume to created certificates and keys from above step.

```bash
docker run --name mqtls --env LICENSE=accept \
    --env MQ_QMGR_NAME=QM1 \
    --env MQ_APP_PASSWORD=passw0rd \
    --env MQ_ADMIN_PASSWORD=passw0rd \
    --volume /home/nino/code/ibmmq/mqtls-test/ssl:/etc/mqm/pki/keys/mykey \
    --publish 1415:1414 \
    --publish 9444:9443 \
    --detach \
    icr.io/ibm-messaging/mq:latest
```

Copy clientkey.jks from step above to local directory. And run the route with:

```bash
jbang run -Djavax.net.ssl.trustStore=clientkey.jks -Djavax.net.ssl.trustStorePassword=changeit -Dcamel.jbang.version=4.15.0 camel@apache/camel run --dev --dep=mvn:com.ibm.mq:com.ibm.mq.jakarta.client:9.4.2.0 ibmtls.camel.yaml application.properties 
```

