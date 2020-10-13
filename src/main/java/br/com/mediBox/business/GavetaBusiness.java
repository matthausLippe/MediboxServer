package br.com.mediBox.business;


import br.com.mediBox.model.GavetaModel;
import br.com.mediBox.repository.GavetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GavetaBusiness {
    @Autowired
    GavetaRepository gavetaRepository;

    public List<GavetaModel> findAll() {
        return gavetaRepository.findAll();
    }

    public List<GavetaModel> findByIdCaixa(long id){return gavetaRepository.findByIdCaixa(id);}

    public GavetaModel findById(long id) {
        return gavetaRepository.findById(id).get();
    }

    public void save(GavetaModel gavetaModel) {
        gavetaRepository.save(gavetaModel);
    }

    public void deleteById(long id) {
        gavetaRepository.deleteById(id);
    }
}
