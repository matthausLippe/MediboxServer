package br.com.mediBox.business;


import br.com.mediBox.model.ResidenteMedicamentoModel;
import br.com.mediBox.repository.ResidenteMedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResidenteMedicamentoBusiness {

    @Autowired
    public ResidenteMedicamentoRepository residenteMedicamentoRepository;

    public List<ResidenteMedicamentoModel> findAll() {
        return residenteMedicamentoRepository.findAll();
    }

    public ResidenteMedicamentoModel findById(long id) {
        return residenteMedicamentoRepository.findById(id).get();
    }

    public void save(ResidenteMedicamentoModel residenteMedicamentoModel) {
        residenteMedicamentoRepository.save(residenteMedicamentoModel);
    }

    public void deleteById(long id) {
        residenteMedicamentoRepository.deleteById(id);
    }

    public List<ResidenteMedicamentoModel> findByIdResidente(long id){
        return residenteMedicamentoRepository.findByIdResidente(id);
    }
}
