package br.com.mediBox.repository;

import br.com.mediBox.model.ResidenteMedicamentoModel;
import br.com.mediBox.model.ResidenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ResidenteRepository extends JpaRepository<ResidenteModel, Long> {


}
