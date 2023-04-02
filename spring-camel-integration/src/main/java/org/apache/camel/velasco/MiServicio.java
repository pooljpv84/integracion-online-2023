package org.apache.camel.velasco;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.camel.velasco.DTO.Cliente;
@RestController
public class MiServicio {

    @Autowired private ProducerTemplate template;

    @GetMapping(value = "/listaclientesflask")
    public String consultaClientes(){
        return template.requestBody("direct:clientes","").toString();
    }

    @GetMapping(value = "/listaclienteflask/{codigo}")
    public String consultaCliente(@PathVariable("codigo") String codigo){
        return template.requestBodyAndHeader("direct:cliente", null, "codigo", codigo).toString();
    }
    @GetMapping(value = "/listaclientesdotnet")
    public String consultaClientesD(){
        return template.requestBody("direct:clientesD","").toString();
    }

    @GetMapping(value = "/listaclientedotnet/{codigo}")
    public String consultaClienteD(@PathVariable("codigo") String codigo){
        return template.requestBodyAndHeader("direct:clienteD", null, "codigo", codigo).toString();
    }
    @PostMapping(value = "/canal")
    public ResponseEntity<String> inCustomer(@RequestBody Cliente customer){
        try {
            template.requestBody("direct:inData", customer);
            return ResponseEntity.status(HttpStatus.CREATED).body("exito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}
