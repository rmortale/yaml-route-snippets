//DEPS org.apache.camel:camel-bom:4.10.2@pom
//DEPS org.apache.camel:camel-main
//DEPS org.apache.camel:camel-activemq
//DEPS org.apache.camel:camel-health
//DEPS org.messaginghub:pooled-jms:3.1.7
import org.apache.camel.builder.RouteBuilder;

public class demo extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:myqueue?concurrentConsumers=5")
            .log("Received message: ${body}");
    }
}