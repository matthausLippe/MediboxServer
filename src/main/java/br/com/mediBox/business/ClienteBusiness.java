package br.com.mediBox.business;


import br.com.mediBox.model.ClienteModel;
import br.com.mediBox.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteBusiness {
    @Autowired
    public ClienteRepository clienteRepository;

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    public ClienteModel findById(long id) {
        return clienteRepository.findById(id).get();
    }

    public void save(ClienteModel clienteModel) {
        clienteRepository.save(clienteModel);
    }

    public void deleteById(long id) {
        clienteRepository.deleteById(id);
    }
}
