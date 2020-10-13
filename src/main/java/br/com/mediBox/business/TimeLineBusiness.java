package br.com.mediBox.business;

import br.com.mediBox.model.TimeLineModel;
import br.com.mediBox.repository.TimeLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeLineBusiness {
    @Autowired
    public TimeLineRepository timeLineRepository;

    public List<TimeLineModel> findAll() {
        return timeLineRepository.findAll();
    }

    public List<TimeLineModel> findByIdResidenteMedicamento(long id){
        return timeLineRepository.findByIdResidenteMedicamento(id);
    }

    public List<TimeLineModel> findByIdCliente(long id){
        return timeLineRepository.findByIdCliente(id);
    }

    public TimeLineModel findById(long id) {
        return timeLineRepository.findById(id).get();
    }

    public void save(TimeLineModel timeLineModel) {
        timeLineRepository.save(timeLineModel);
    }

    public void deleteById(long id) {
        timeLineRepository.deleteById(id);
    }
}
