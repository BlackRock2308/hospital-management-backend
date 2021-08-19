package sn.sante.projects.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import sn.sante.projects.app.model.Consultation;
import sn.sante.projects.app.repository.ConsultationRepository;


@Service
@Data
public class ConsultationService {

	@Autowired
	private ConsultationRepository consultationRepository;
	
	
	public Iterable<Consultation> getAllConsultation(){
		return consultationRepository.findAll();
	}
	
	public Consultation saveConsultation(Consultation consultation) {
		return consultationRepository.save(consultation);
	}
	
	public Optional<Consultation> getOneConsultation(Long id) {
		return consultationRepository.findById(id);
	}
	
	//To be continued
	
}
