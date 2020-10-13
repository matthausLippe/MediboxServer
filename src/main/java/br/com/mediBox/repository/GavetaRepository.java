package br.com.mediBox.repository;

import br.com.mediBox.model.GavetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GavetaRepository extends JpaRepository<GavetaModel, Long> {

    @Query(value = "SELECT * FROM TB_GAVETA WHERE ID_CAIXA = :id", nativeQuery = true)
    List<GavetaModel> findByIdCaixa(long id);

}
