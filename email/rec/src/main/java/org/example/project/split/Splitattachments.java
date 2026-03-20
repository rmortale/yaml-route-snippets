package org.example.project.split;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mail.SplitAttachmentsExpression;

public class Splitattachments extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        routeTemplate("mailTemplate")
                .templateParameter("username")
                .templateParameter("password")
                .templateParameter("delay")
                .from("pop3://localhost:14110?username={{username}}&password={{password}}&handleDuplicateAttachmentNames=uuidSuffix&delay={{delay}}")
                .log("${attachments}")
                .split(method(new SplitAttachmentsExpression()))
                .log("${headers}");

        routeTemplate("sftpWithNotification")
                .templateParameter("host")
                .templateParameter("port")
                .templateParameter("username")
                .templateParameter("targetDir")
                .templateParameter("sourceDir")
                .templateParameter("notifyQueueName")
                .from("file:{{sourceDir}}")
                .to("sftp:{{host}}:{{port}}/{{targetDir}}")
                .to("jms:queue:{{notifyQueueName}}")
                .log("Successfully delivered file and notify message!");

    }
}
