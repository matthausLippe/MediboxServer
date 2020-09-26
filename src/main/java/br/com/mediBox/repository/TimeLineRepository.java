package br.com.mediBox.repository;

import br.com.mediBox.model.TimeLineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeLineRepository extends JpaRepository<TimeLineModel, Long> {
}
