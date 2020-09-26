package br.com.mediBox.repository;

import br.com.mediBox.model.ResidenteMedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenteMedicamentoRepository extends JpaRepository<ResidenteMedicamentoModel, Long> {
}
