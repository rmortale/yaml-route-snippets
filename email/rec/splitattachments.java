import org.apache.camel.builder.RouteBuilder;

public class splitattachments extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("pop3://tom@localhost:14110?password=tom&handleDuplicateAttachmentNames=uuidSuffix&delay=10000")
            //.log("${attachments}")
            .split(method(new org.apache.camel.component.mail.SplitAttachmentsExpression())).streaming()
                .to("log:mylogger?showBody=false&showHeaders=true")
                .to("file:mails?fileName=${header.CamelSplitAttachmentId}")
            .end();
    }
}
