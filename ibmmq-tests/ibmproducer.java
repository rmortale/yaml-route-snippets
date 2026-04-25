import org.apache.camel.builder.RouteBuilder;

public class ibmproducer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:input")
                .split(body().tokenize("\n"))
                .log("${body}")
                .to("kamelet:jms-ibm-mq-sink?destinationName=DEV.QUEUE.1");
    }
}
