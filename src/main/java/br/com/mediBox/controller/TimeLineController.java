package br.com.mediBox.controller;

import br.com.mediBox.business.TimeLineBusiness;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.model.TimeLineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/timeLine")
public class TimeLineController {

    @Autowired
    public TimeLineBusiness timeLineBusiness;

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
    public ResponseEntity save(@RequestBody TimeLineModel timeLineModel) throws ResponseBusinessException {
        timeLineBusiness.save(timeLineModel);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(timeLineModel.getIdTimeLine()).toUri();

        return ResponseEntity.created(location).build();

    }


    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody TimeLineModel timeLineModel) throws  ResponseBusinessException{

        timeLineBusiness.findById(id);

        timeLineModel.setIdTimeLine(id);
        timeLineBusiness.save(timeLineModel);
        return ResponseEntity.ok().build();

    }

    //Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){
        timeLineBusiness.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
