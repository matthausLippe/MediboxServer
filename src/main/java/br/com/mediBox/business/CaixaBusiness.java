package br.com.mediBox.business;


import br.com.mediBox.model.CaixaModel;
import br.com.mediBox.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaixaBusiness {

    @Autowired
    public CaixaRepository caixaRepository;

    public List<CaixaModel> findAll() {
        return caixaRepository.findAll();
    }

    public CaixaModel findById(long id) {
        return caixaRepository.findById(id).get();
    }

    public List<CaixaModel> findByIdCliente(long id){
        return caixaRepository.findByIdCliente(id);

    }

    public void save(CaixaModel caixaModel) {
        caixaRepository.save(caixaModel);
    }

    public void deleteById(long id) {
        caixaRepository.deleteById(id);
    }
}
