package br.com.mediBox.controller;


import br.com.mediBox.business.EnderecoBusiness;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.model.EnderecoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    public EnderecoBusiness enderecoBusiness;

    //Busca
    @GetMapping
    public ResponseEntity<List<EnderecoModel>> findAll(){
        List<EnderecoModel> listEndereco = enderecoBusiness.findAll();
        return ResponseEntity.ok(listEndereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> findById(@PathVariable("id") long id){
        EnderecoModel enderecoModel = enderecoBusiness.findById(id);
        return ResponseEntity.ok(enderecoModel);
    }


    //Cadastro
    @PostMapping
    public ResponseEntity save(@RequestBody EnderecoModel enderecoModel) throws ResponseBusinessException {
        enderecoBusiness.save(enderecoModel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(enderecoModel.getIdEndereco()).toUri();
        return ResponseEntity.created(location).build();
    }


    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody EnderecoModel enderecoModel) throws  ResponseBusinessException{
        enderecoBusiness.findById(id);
        enderecoModel.setIdEndereco(id);
        enderecoBusiness.save(enderecoModel);
        return ResponseEntity.noContent().build();
    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){
        enderecoBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
