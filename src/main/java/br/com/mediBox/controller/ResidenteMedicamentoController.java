package br.com.mediBox.controller;

import br.com.mediBox.business.ClienteBusiness;
import br.com.mediBox.business.MedicamentoBusiness;
import br.com.mediBox.business.ResidenteBusiness;
import br.com.mediBox.business.ResidenteMedicamentoBusiness;
import br.com.mediBox.dto.ResidenteMedicamentoDto;
import br.com.mediBox.exception.ResponseBusinessException;
import br.com.mediBox.model.ResidenteMedicamentoModel;
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
@RequestMapping("/residenteMedicamento")
public class ResidenteMedicamentoController {

    @Autowired
    public ResidenteMedicamentoBusiness residenteMedicamentoBusiness;

    @Autowired
    public MedicamentoBusiness medicamentoBusiness;

    @Autowired
    public ResidenteBusiness residenteBusiness;

    @Autowired
    public ClienteBusiness clienteBusiness;

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
    public ResponseEntity save(@RequestBody ResidenteMedicamentoDto residenteMedicamentoDto) throws ResponseBusinessException {
        ResidenteMedicamentoModel residenteMedicamentoModel = converterDtoToModel(residenteMedicamentoDto);
        residenteMedicamentoBusiness.save(residenteMedicamentoModel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(residenteMedicamentoModel.getIdResidenteMedicamento()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Edição
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody ResidenteMedicamentoDto residenteMedicamentoDto) throws  ResponseBusinessException{
        ResidenteMedicamentoModel residenteMedicamentoModel = converterDtoToModel(residenteMedicamentoDto);
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

    private ResidenteMedicamentoModel converterDtoToModel(ResidenteMedicamentoDto dto){
        ResidenteMedicamentoModel model = new ResidenteMedicamentoModel();
        model.setClienteModel(clienteBusiness.findById(dto.getClienteModel()));
        model.setMedicamentoModel(medicamentoBusiness.findById(dto.getMedicamentoModel()));
        model.setResidenteModel(residenteBusiness.findById(dto.getResidenteModel()));

        model.setDosagem(dto.getDosagem());
        model.setDoses(dto.getDoses());
        model.setIdResidenteMedicamento(dto.getIdResidenteMedicamento());
        model.setIntervalo(dto.getIntervalo());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
        Date dataHoraInicio = null;
        try {
            dataHoraInicio = format.parse(dto.getDataHoraInicio());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.setDataHoraInicio(dataHoraInicio);

        return model;
    }
}
