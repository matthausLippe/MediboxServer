package br.com.mediBox.repository;

import br.com.mediBox.model.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Long> {
}
