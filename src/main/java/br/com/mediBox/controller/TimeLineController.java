package br.com.mediBox.controller;

import br.com.mediBox.business.ClienteBusiness;
import br.com.mediBox.business.ResidenteMedicamentoBusiness;
import br.com.mediBox.business.TimeLineBusiness;
import br.com.mediBox.dto.TimeLineDto;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.model.TimeLineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/timeLine")
public class TimeLineController {

    @Autowired
    public TimeLineBusiness timeLineBusiness;

    @Autowired
    public ResidenteMedicamentoBusiness residenteMedicamentoBusiness;

    @Autowired
    public ClienteBusiness clienteBusiness;


    //Busca
    @GetMapping
    public ResponseEntity<List<TimeLineModel>> findAll(){
        List<TimeLineModel> listTimeLine = timeLineBusiness.findAll();
        return ResponseEntity.ok(listTimeLine);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeLineModel> findById(@PathVariable("id") long id){
        TimeLineModel timeLineModel = timeLineBusiness.findById(id);
        return ResponseEntity.ok(timeLineModel);
    }

    //Cadastro
    @PostMapping
    public ResponseEntity save(@RequestBody TimeLineDto timeLineDto) throws ResponseBusinessException {
        TimeLineModel timeLineModel = converterDtoToModel(timeLineDto);
        timeLineBusiness.save(timeLineModel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(timeLineModel.getIdTimeLine()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody TimeLineDto timeLineDto) throws  ResponseBusinessException{
        TimeLineModel timeLineModel = converterDtoToModel(timeLineDto);
        timeLineBusiness.findById(id);
        timeLineModel.setIdTimeLine(id);
        timeLineBusiness.save(timeLineModel);
        return ResponseEntity.noContent().build();
    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){
        timeLineBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private TimeLineModel converterDtoToModel(TimeLineDto dto){
        TimeLineModel model = new TimeLineModel();
        model.setClienteModel(clienteBusiness.findById(dto.getClienteModel()));
        model.setResidenteMedicamentoModel(residenteMedicamentoBusiness.findById(dto.getResidenteMedicamentoModel()));
        model.setIdTimeLine(dto.getIdTimeLine());
        model.setStatus(dto.getStatus());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
        Date dataHoraMedicacao = null;
        try {
            dataHoraMedicacao = format.parse(dto.getDataHoraMedicacao());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.setDataHoraMedicacao(dataHoraMedicacao);
        return model;
    }
}
