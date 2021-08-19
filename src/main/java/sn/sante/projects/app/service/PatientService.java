package sn.sante.projects.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.sante.projects.app.model.Patient;
import sn.sante.projects.app.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public Optional<Patient> getOnePatient(Long nSS){
		return patientRepository.findById(nSS);
	}
	
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public Iterable<Patient> getAllPatient(){
		return patientRepository.findAll();
	}
	
	//To be continued
	
}
