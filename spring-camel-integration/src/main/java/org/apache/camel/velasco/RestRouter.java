package org.apache.camel.velasco;


import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.velasco.DTO.Cliente;
import org.apache.camel.velasco.Processor.ClienteProcesor;
import org.apache.camel.velasco.Processor.CreateClienteProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder {

    JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Cliente.class);
    private Logger log = LoggerFactory.getLogger(RestRouter.class);

    @Override
    public void configure() throws Exception {
        from("direct:clientes")
        .routeId("QClientes")
        .to("rest:get:/clientes?host=localhost:5000")
        .log("${body}")
        .to("stream:out");

        from("direct:clientesD")
                .routeId("DClientes")
                .to("rest:get:/Client?host=localhost:9000")
                .log("${body}")
                .to("stream:out");

        from("direct:cliente")
        .routeId("QCliente")
        .to("rest:get:/cliente/{codigo}?host=localhost:5000")
        .unmarshal(jsonDataFormat)
        .process(new ClienteProcesor())
        .to("log:foo");

        from("direct:clienteD")
                .routeId("DCliente")
                .to("rest:get:/Client/{codigo}?host=localhost:9000")
                .unmarshal(jsonDataFormat)
                .process(new ClienteProcesor())
                .to("log:foo");

        restConfiguration()
                .enableCORS(false);
        from("direct:inData")
                .routeId("RouteClient")
                .process(new CreateClienteProcessor())
                .choice()
                    .when(header("ruta").contains("1"))
                    .marshal(jsonDataFormat)
                    .to("rest:post:/cliente?host=localhost:5000")
                .otherwise()
                    .marshal(jsonDataFormat)
                    .to("rest:post:/Client?host=localhost:9000")
                .end();

    }
    
}
