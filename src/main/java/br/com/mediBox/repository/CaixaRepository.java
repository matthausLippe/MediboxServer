package br.com.mediBox.repository;

import br.com.mediBox.model.CaixaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaixaRepository extends JpaRepository<CaixaModel, Long> {
    @Query(value = "SELECT * FROM TB_CAIXA WHERE ID_CLIENTE = :id", nativeQuery = true)
    List<CaixaModel> findByIdCliente(long id);

}
