package br.com.mediBox.business;


import br.com.mediBox.model.MedicamentoModel;
import br.com.mediBox.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicamentoBusiness {
    @Autowired
    public MedicamentoRepository medicamentoRepository;

    public List<MedicamentoModel> findAll() {
        return medicamentoRepository.findAll();
    }

    public MedicamentoModel findById(long id) {
        return medicamentoRepository.findById(id).get();
    }

    public void save(MedicamentoModel medicamentoModel) {
        medicamentoRepository.save(medicamentoModel);
    }

    public void deleteById(long id) {
        medicamentoRepository.deleteById(id);
    }
}
