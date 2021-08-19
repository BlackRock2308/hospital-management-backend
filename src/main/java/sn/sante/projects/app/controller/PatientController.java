package sn.sante.projects.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sn.sante.projects.app.model.Patient;
import sn.sante.projects.app.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("api/hospital/patients")
	public Iterable<Patient> gettingPatients(){
		return patientService.getAllPatient();
	}
	
	@PostMapping("api/hospital/patients")
	public ResponseEntity<String> addMedecin(@RequestBody Patient patient){
	
		Patient savedPatient = patientService.savePatient(patient);
		
		if(savedPatient == null) {
			return new ResponseEntity<>("Une erreur s'est produite", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>("Patient ajouté avec succès", HttpStatus.CREATED);
	}
}
