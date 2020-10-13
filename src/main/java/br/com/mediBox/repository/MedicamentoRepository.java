package br.com.mediBox.repository;

import br.com.mediBox.model.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Long> {

    @Query(value = "SELECT * FROM TB_MEDICAMENTO WHERE ID_GAVETA = :id", nativeQuery = true)
    List<MedicamentoModel> findByIdGaveta(long id);

}
