import org.apache.camel.builder.RouteBuilder;

public class kafka extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:file.jms.events?brokers=144.24.252.7:9092&clientId=testcamel&groupId=testcamel")
            .log("${body}");
    }
}
