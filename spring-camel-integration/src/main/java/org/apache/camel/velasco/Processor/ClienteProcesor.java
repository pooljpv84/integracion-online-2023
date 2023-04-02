package org.apache.camel.velasco.Processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.camel.velasco.DTO.*;


public class ClienteProcesor implements Processor{

    private Logger log = LoggerFactory.getLogger(ClienteProcesor.class);

    @Override
    public void process(Exchange exchange) throws Exception
    {
        Cliente cliente = (Cliente) exchange.getIn().getBody();
        log.info("Recibio {}",cliente);
        
    }
    
}
