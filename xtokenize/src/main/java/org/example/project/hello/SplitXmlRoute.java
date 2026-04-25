package org.example.project.hello;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.builder.Namespaces;

public class SplitXmlRoute extends RouteBuilder {

    Namespaces ns = new Namespaces();

    @Override
    public void configure() throws Exception {
        from("file:source")
                .split().xtokenize("/company/address", 'u', ns)
                .log("Splited ${body}")
                .to("file:target");
    }
}
