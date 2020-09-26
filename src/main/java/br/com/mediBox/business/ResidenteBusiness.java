package br.com.mediBox.business;


import br.com.mediBox.model.ResidenteModel;
import br.com.mediBox.repository.ResidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResidenteBusiness {
    @Autowired
    public ResidenteRepository residenteRepository;

    public List<ResidenteModel> findAll() {
        return residenteRepository.findAll();
    }

    public ResidenteModel findById(long id) {
        return residenteRepository.findById(id).get();
    }

    public void save(ResidenteModel residenteModel) {
        residenteRepository.save(residenteModel);
    }

    public void deleteById(long id) {
        residenteRepository.deleteById(id);
    }
}
