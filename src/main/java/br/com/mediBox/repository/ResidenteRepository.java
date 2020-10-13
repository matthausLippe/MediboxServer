package br.com.mediBox.repository;

import br.com.mediBox.model.ResidenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidenteRepository extends JpaRepository<ResidenteModel, Long> {

    @Query(value = "SELECT * FROM TB_RESIDENTE WHERE ID_CLIENTE = :id", nativeQuery = true)
    List<ResidenteModel> findByIdCliente(long id);

}
