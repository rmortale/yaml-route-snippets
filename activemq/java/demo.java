
import org.apache.camel.builder.RouteBuilder;

public class demo extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:IncomingOrdersCopy?concurrentConsumers=5")
            .log("Received message: ${body}");
    }
}