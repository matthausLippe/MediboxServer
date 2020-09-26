package br.com.mediBox.repository;

import br.com.mediBox.model.ResidenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenteRepository extends JpaRepository<ResidenteModel, Long> {
}
