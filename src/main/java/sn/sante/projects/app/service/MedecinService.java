package sn.sante.projects.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.sante.projects.app.model.Medecin;
import sn.sante.projects.app.repository.MedecinRepository;

@Service
public class MedecinService {

	@Autowired
	private MedecinRepository medecinRepository;
	
	public Optional<Medecin> getOneMedecin(Long matricule) {
		return medecinRepository.findById(matricule);
	}
	
	public Iterable<Medecin> getAllMedecins(){
		return medecinRepository.findAll();
	}
	
	public Medecin saveMedecin(Medecin medecin) {
		return medecinRepository.save(medecin);
	}
	
	public void deleteOneMedecin(Long matricule) {
		medecinRepository.deleteById(matricule);
	}
}
