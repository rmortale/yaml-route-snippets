import org.apache.camel.builder.RouteBuilder;

public class kafka extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:minio-events?brokers=oravm05:9092&clientId=testcamel&groupId=testcamel")
            .log("${body}");
    }
}
