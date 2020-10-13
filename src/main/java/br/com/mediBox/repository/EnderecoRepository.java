package br.com.mediBox.repository;

import br.com.mediBox.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

    @Query(value = "SELECT * FROM TB_ENDERECO WHERE ID_CLIENTE = :id", nativeQuery = true)
    List<EnderecoModel> findByIdCliente(long id);

}
