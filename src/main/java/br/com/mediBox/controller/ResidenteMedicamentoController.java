package br.com.mediBox.controller;

import br.com.mediBox.business.ResidenteMedicamentoBusiness;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.model.ResidenteMedicamentoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/residenteMedicamento")
public class ResidenteMedicamentoController {

    @Autowired
    public ResidenteMedicamentoBusiness residenteMedicamentoBusiness;

    //Busca
    @GetMapping
    public ResponseEntity<List<ResidenteMedicamentoModel>> findAll(){

        List<ResidenteMedicamentoModel> listResidenteMedicamento = residenteMedicamentoBusiness.findAll();
        return ResponseEntity.ok(listResidenteMedicamento);
    }

    //BuscaIdResidente
    @GetMapping("/residente/{id}")
    public ResponseEntity<List<ResidenteMedicamentoModel>> findAll(@PathVariable("id") long id){

        List<ResidenteMedicamentoModel> listResidenteMedicamento = residenteMedicamentoBusiness.findByIdResidente(id);
        return ResponseEntity.ok(listResidenteMedicamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResidenteMedicamentoModel> findById(@PathVariable("id") long id){
        ResidenteMedicamentoModel residenteMedicamentoModel = residenteMedicamentoBusiness.findById(id);
        return ResponseEntity.ok(residenteMedicamentoModel);

    }


    //Cadastro
    @PostMapping
    public ResponseEntity save(@RequestBody ResidenteMedicamentoModel residenteMedicamentoModel) throws ResponseBusinessException {
        residenteMedicamentoBusiness.save(residenteMedicamentoModel);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(residenteMedicamentoModel.getIdResidenteMedicamento()).toUri();

        return ResponseEntity.created(location).build();

    }


    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody ResidenteMedicamentoModel residenteMedicamentoModel) throws  ResponseBusinessException{

        residenteMedicamentoBusiness.findById(id);

        residenteMedicamentoModel.setIdResidenteMedicamento(id);
        residenteMedicamentoBusiness.save(residenteMedicamentoModel);
        return ResponseEntity.ok().build();

    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){
        residenteMedicamentoBusiness.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
