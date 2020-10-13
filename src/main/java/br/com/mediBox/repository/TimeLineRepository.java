package br.com.mediBox.repository;

import br.com.mediBox.model.TimeLineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeLineRepository extends JpaRepository<TimeLineModel, Long> {

    @Query(value = "SELECT * FROM TB_TIMELINE WHERE ID_RESIDENTE_MEDICAMENTO = :id", nativeQuery = true)
    List<TimeLineModel> findByIdResidenteMedicamento(long id);

    @Query(value = "SELECT * FROM TB_TIMELINE WHERE ID_CLIENTE = :id", nativeQuery = true)
    List<TimeLineModel> findByIdCliente(long id);

}
