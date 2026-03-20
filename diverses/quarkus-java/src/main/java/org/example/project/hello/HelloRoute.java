package org.example.project.hello;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

public class HelloRoute extends EndpointRouteBuilder {

    @Override
    public void configure() throws Exception {
        from(timer("java").period(1000))
                .setBody()
                .simple("Hello Camel from ${routeId}")
                .log("${body}");
    }
}
