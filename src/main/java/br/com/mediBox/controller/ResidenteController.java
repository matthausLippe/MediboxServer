package br.com.mediBox.controller;

import br.com.mediBox.business.ResidenteBusiness;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.model.ResidenteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/residente")
public class ResidenteController {

    @Autowired
    public ResidenteBusiness residenteBusiness;

    //Busca
    @GetMapping
    public ResponseEntity<List<ResidenteModel>> findAll(){

        List<ResidenteModel> listResidente = residenteBusiness.findAll();
        return ResponseEntity.ok(listResidente);



    }

    @GetMapping("/{id}")
    public ResponseEntity<ResidenteModel> findById(@PathVariable("id") long id){
        ResidenteModel residenteModel = residenteBusiness.findById(id);
        return ResponseEntity.ok(residenteModel);

    }


    //Cadastro
    @PostMapping
    public ResponseEntity save(@RequestBody ResidenteModel residenteModel) throws ResponseBusinessException {
        residenteBusiness.save(residenteModel);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(residenteModel.getIdResidente()).toUri();

        return ResponseEntity.created(location).build();

    }


    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody ResidenteModel residenteModel) throws  ResponseBusinessException{

        residenteBusiness.findById(id);

        residenteModel.setIdResidente(id);
        residenteBusiness.save(residenteModel);
        return ResponseEntity.ok().build();

    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){
        residenteBusiness.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
