package org.apache.camel.velasco.Processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.velasco.DTO.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.modelmapper.ModelMapper;

import java.util.*;


public class CreateClienteProcessor implements Processor
{

    private Logger log = LoggerFactory.getLogger(CreateClienteProcessor.class);
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void process(Exchange exchange) throws Exception
    {
        log.info("Crear Clientes por su Canal");
        Cliente objClient = modelMapper.map(exchange.getMessage().getBody(), Cliente.class);
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
            log.info("Canal: {}",objClient.getCanal());
        if (objClient.getCanal() == 1)
        {
            exchange.getIn().setHeader("ruta", "1");
        }
        else {
            exchange.getIn().setHeader("ruta", "2");
        }
        exchange.getIn().setBody(objClient);
        log.info("Cliente enviado: {}", objClient);

    }
}
