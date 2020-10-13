package br.com.mediBox.controller;

import br.com.mediBox.business.CaixaBusiness;
import br.com.mediBox.business.ClienteBusiness;
import br.com.mediBox.dto.CaixaDto;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.model.CaixaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/caixa")
public class CaixaController {

    @Autowired
    public CaixaBusiness caixaBusiness;

    @Autowired
    public ClienteBusiness clienteBusiness;

    //Busca
    @GetMapping
    public ResponseEntity<List<CaixaModel>> findAll() {

        List<CaixaModel> listCaixa = caixaBusiness.findAll();
        return ResponseEntity.ok(listCaixa);


    }

    @GetMapping("/{id}")
    public ResponseEntity<CaixaModel> findById(@PathVariable("id") long id) {
        CaixaModel caixaModel = caixaBusiness.findById(id);
        return ResponseEntity.ok(caixaModel);

    }


    //Cadastro
    @PostMapping
    public ResponseEntity save(@RequestBody CaixaDto caixaDto) throws ResponseBusinessException {
        CaixaModel caixaModel = converterDtoToModel(caixaDto);

        caixaBusiness.save(caixaModel);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(caixaModel.getIdCaixa()).toUri();

        return ResponseEntity.created(location).build();

    }

    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody CaixaDto caixaDto) throws ResponseBusinessException {
        caixaBusiness.findById(id);
        CaixaModel caixaModel = converterDtoToModel(caixaDto);
        caixaModel.setIdCaixa(id);
        caixaBusiness.save(caixaModel);
        return ResponseEntity.noContent().build();
    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id) {
        caixaBusiness.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    private CaixaModel converterDtoToModel(CaixaDto caixaDto) {
        CaixaModel caixaModel = new CaixaModel();
        caixaModel.setIdCaixa(caixaDto.getIdCaixa());
        caixaModel.setClienteModel(clienteBusiness.findById(caixaDto.getClienteModel()));
        caixaModel.setMac(caixaDto.getMac());
        caixaModel.setStatus(caixaDto.getStatus());

        return caixaModel;
    }

}
