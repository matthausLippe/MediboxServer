package br.com.mediBox.controller;

import br.com.mediBox.business.MedicamentoBusiness;
import br.com.mediBox.exception.ResponseBusinessException;

import br.com.mediBox.model.MedicamentoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    public MedicamentoBusiness medicamentoBusiness;

    //Busca
    @GetMapping
    public ResponseEntity<List<MedicamentoModel>> findAll(){

        List<MedicamentoModel> listMedicamento = medicamentoBusiness.findAll();
        return ResponseEntity.ok(listMedicamento);



    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoModel> findById(@PathVariable("id") long id){
        MedicamentoModel medicamentoModel = medicamentoBusiness.findById(id);
        return ResponseEntity.ok(medicamentoModel);

    }


    //Cadastro
    @PostMapping
    public ResponseEntity save(@RequestBody MedicamentoModel medicamentoModel) throws ResponseBusinessException {
        medicamentoBusiness.save(medicamentoModel);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(medicamentoModel.getIdMedicamento()).toUri();

        return ResponseEntity.created(location).build();

    }


    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody MedicamentoModel medicamentoModel) throws  ResponseBusinessException{

        medicamentoBusiness.findById(id);

        medicamentoModel.setIdMedicamento(id);
        medicamentoBusiness.save(medicamentoModel);
        return ResponseEntity.ok().build();

    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){
        medicamentoBusiness.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
