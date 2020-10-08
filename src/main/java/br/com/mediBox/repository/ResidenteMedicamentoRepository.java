package br.com.mediBox.repository;

import br.com.mediBox.model.ResidenteMedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ResidenteMedicamentoRepository extends JpaRepository<ResidenteMedicamentoModel, Long> {

    @Query(value = "SELECT * FROM TB_RESIDENTEMEDICAMENTO WHERE ID_CLIENTE = :id", nativeQuery = true)
    List<ResidenteMedicamentoModel> findByIdResidente(long id);
}
