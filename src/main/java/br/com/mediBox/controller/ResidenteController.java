package br.com.mediBox.controller;

import br.com.mediBox.business.ClienteBusiness;
import br.com.mediBox.business.ResidenteBusiness;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.dto.ResidenteDto;
import br.com.mediBox.model.ResidenteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/residente")
public class ResidenteController {

    @Autowired
    public ResidenteBusiness residenteBusiness;

    @Autowired
    public ClienteBusiness clienteBusiness;

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
    public ResponseEntity save(@RequestBody ResidenteDto residenteDto) throws ResponseBusinessException, ParseException {
        ResidenteModel residenteModel = converterDtoToModel(residenteDto);

        residenteBusiness.save(residenteModel);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(residenteModel.getIdResidente()).toUri();

        return ResponseEntity.created(location).build();

    }


    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody ResidenteDto residenteDto) throws  ResponseBusinessException{
        residenteBusiness.findById(id);
        ResidenteModel residenteModel = converterDtoToModel(residenteDto);
        residenteModel.setIdResidente(id);
        residenteBusiness.save(residenteModel);
        return ResponseEntity.noContent().build();
    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){
        residenteBusiness.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    private ResidenteModel converterDtoToModel(ResidenteDto residenteDto){
        ResidenteModel residenteModel = new ResidenteModel();

        residenteModel.setIdResidente(residenteDto.getIdResidente());
        residenteModel.setClienteModel(clienteBusiness.findById(residenteDto.getClienteModel()));
        residenteModel.setNomeResidente(residenteDto.getNomeResidente());

        residenteModel.setNomeResponsavel(residenteDto.getNomeResponsavel());
        residenteModel.setTelResponsavel(residenteDto.getTelResponsavel());
        residenteModel.setQuarto(residenteDto.getQuarto());
        residenteModel.setSexo(residenteDto.getSexo());
        residenteModel.setObservacoes(residenteDto.getObservacoes());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
        Date dataNascimento = null;
        try {
            dataNascimento = format.parse(residenteDto.getDataNascimento());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        residenteModel.setDataNascimento(dataNascimento);

        return residenteModel;
    }
}
