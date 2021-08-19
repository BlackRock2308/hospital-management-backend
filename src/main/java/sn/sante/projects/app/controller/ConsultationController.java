package sn.sante.projects.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sn.sante.projects.app.model.Consultation;
import sn.sante.projects.app.model.ConsultationRequest;
import sn.sante.projects.app.model.Medecin;
import sn.sante.projects.app.model.Patient;
import sn.sante.projects.app.service.ConsultationService;
import sn.sante.projects.app.service.MedecinService;
import sn.sante.projects.app.service.PatientService;

@RestController
public class ConsultationController {
	
	@Autowired
	private ConsultationService consultationService;
	
	@Autowired
	private MedecinService medecinService;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("api/hospital/consultations")
	public Iterable<Consultation> gettingConsultations(){
		return consultationService.getAllConsultation();
	}
	
	@PostMapping("api/hostipal/consult")
	public ResponseEntity<String> addConsultation(@RequestBody ConsultationRequest consultation){
		
		Optional<Medecin> medecin = medecinService.getOneMedecin(consultation.getMedecin());
		Optional<Patient> patient = patientService.getOnePatient(consultation.getPatient());
		
		if(medecin.isPresent() && patient.isPresent()) {
			
			Consultation newConsultation = new Consultation();
			newConsultation.setMedecin(medecin.get());
			newConsultation.setPatient(patient.get());
			newConsultation.setDate(consultation.getDate());
			
			Consultation savedConsultation = consultationService.saveConsultation(newConsultation);
			
			if(savedConsultation == null) {
				return new ResponseEntity<>("Une erreur s'est produite", HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<>("Consultation ajoutée avec succès", HttpStatus.CREATED);
			
		}
		
		
		return new ResponseEntity<>("Une erreur s'est produite. Veuillez verifier les donnees", HttpStatus.BAD_REQUEST);
	}
	
	
}
