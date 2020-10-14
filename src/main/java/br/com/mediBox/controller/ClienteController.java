package br.com.mediBox.controller;


import br.com.mediBox.business.ClienteBusiness;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.model.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    public ClienteBusiness clienteBusiness;

    //Busca
    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){

        List<ClienteModel> listCliente = clienteBusiness.findAll();
        return ResponseEntity.ok(listCliente);



    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> findById(@PathVariable("id") long id){
        ClienteModel clienteModel = clienteBusiness.findById(id);
        return ResponseEntity.ok(clienteModel);

    }


    //Cadastro
    @PostMapping
    public ResponseEntity save(@RequestBody ClienteModel clienteModel) throws ResponseBusinessException {
        clienteBusiness.save(clienteModel);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clienteModel.getIdCliente()).toUri();

        return ResponseEntity.created(location).build();

    }


    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody ClienteModel clienteModel) throws  ResponseBusinessException{

        clienteBusiness.findById(id);

        clienteModel.setIdCliente(id);
        clienteBusiness.save(clienteModel);
        return ResponseEntity.noContent().build();

    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){
        clienteBusiness.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
