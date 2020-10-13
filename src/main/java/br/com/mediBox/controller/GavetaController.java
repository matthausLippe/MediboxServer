package br.com.mediBox.controller;

import br.com.mediBox.business.CaixaBusiness;
import br.com.mediBox.business.GavetaBusiness;
import br.com.mediBox.dto.GavetaDto;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.model.GavetaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/gaveta")
public class GavetaController {
    @Autowired
    public GavetaBusiness gavetaBusiness;

    @Autowired
    public CaixaBusiness caixaBusiness;

    //Busca
    @GetMapping
    public ResponseEntity<List<GavetaModel>> findAll(){
        List<GavetaModel> listGaveta = gavetaBusiness.findAll();
        return ResponseEntity.ok(listGaveta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GavetaModel> findById(@PathVariable("id") long id){
        GavetaModel gavetaModel = gavetaBusiness.findById(id);
        return ResponseEntity.ok(gavetaModel);

    }

    //Cadastro
    @PostMapping
    public ResponseEntity save(@RequestBody GavetaDto gavetaDto) throws ResponseBusinessException {
        GavetaModel gavetaModel = converterDtoToModel(gavetaDto);
        gavetaBusiness.save(gavetaModel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(gavetaModel.getIdGaveta()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody GavetaDto gavetaDto) throws  ResponseBusinessException{
        GavetaModel gavetaModel = converterDtoToModel(gavetaDto);
        gavetaBusiness.findById(id);
        gavetaModel.setIdGaveta(id);
        gavetaBusiness.save(gavetaModel);
        return ResponseEntity.ok().build();
    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){
        gavetaBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private GavetaModel converterDtoToModel (GavetaDto dto){
        GavetaModel model = new GavetaModel();
        model.setCaixaModel(caixaBusiness.findById(dto.getCaixaModel()));
        model.setIdGaveta(dto.getIdGaveta());
        model.setNomeGaveta(dto.getNomeGaveta());
        model.setTemperatura(dto.getTemperatura());
        return model;
    }
}
