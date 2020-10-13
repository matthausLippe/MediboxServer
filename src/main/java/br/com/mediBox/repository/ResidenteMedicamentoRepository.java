package br.com.mediBox.repository;

import br.com.mediBox.model.ResidenteMedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidenteMedicamentoRepository extends JpaRepository<ResidenteMedicamentoModel, Long> {

    @Query(value = "SELECT * FROM TB_RESIDENTEMEDICAMENTO WHERE ID_CLIENTE = :id", nativeQuery = true)
    List<ResidenteMedicamentoModel> findByIdCliente(long id);

    @Query(value = "SELECT * FROM TB_RESIDENTEMEDICAMENTO WHERE ID_MEDICAMENTO = :id", nativeQuery = true)
    List<ResidenteMedicamentoModel> findByIdMedicamento(long id);


    @Query(value = "SELECT * FROM TB_RESIDENTEMEDICAMENTO WHERE ID_RESIDENTE = :id", nativeQuery = true)
    List<ResidenteMedicamentoModel> findByIdResidente(long id);

    String query = "SELECT id_residente_medicamento, TO_CHAR(data_hora_inicio, 'yyyy/mm/dd hh24:mi:ss') as " +
            "Data_hora_inicio, dosagem, doses, " +
            "intervalo, id_cliente, id_medicamento, id_residente FROM TB_RESIDENTEMEDICAMENTO";

    @Query(value = query, nativeQuery = true)
    List<ResidenteMedicamentoModel> findAllData();

}
