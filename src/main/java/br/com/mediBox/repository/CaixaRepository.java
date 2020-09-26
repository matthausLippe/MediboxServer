package br.com.mediBox.repository;

import br.com.mediBox.model.CaixaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<CaixaModel, Long> {

}
