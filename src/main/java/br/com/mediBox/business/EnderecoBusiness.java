package br.com.mediBox.business;


import br.com.mediBox.model.EnderecoModel;
import br.com.mediBox.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoBusiness {
    @Autowired
    public EnderecoRepository enderecoRepository;

    public List<EnderecoModel> findAll() {
        return enderecoRepository.findAll();
    }

    public EnderecoModel findById(long id) {
        return enderecoRepository.findById(id).get();
    }

    public void save(EnderecoModel enderecoModel) {
        enderecoRepository.save(enderecoModel);
    }

    public void deleteById(long id) {
        enderecoRepository.deleteById(id);
    }

}
