package br.com.mediBox.repository;

import br.com.mediBox.model.GavetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GavetaRepository extends JpaRepository<GavetaModel, Long> {
}
