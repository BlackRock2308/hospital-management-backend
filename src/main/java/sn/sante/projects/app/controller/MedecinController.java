package sn.sante.projects.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sn.sante.projects.app.model.Medecin;
import sn.sante.projects.app.service.MedecinService;

@RestController
public class MedecinController {

	@Autowired
	private MedecinService medecinService;
	
	@GetMapping("api/hospital/medecins")
	public Iterable<Medecin> gettingMedecins(){
		return medecinService.getAllMedecins();
	}
	
	@PostMapping("api/hospital/medecins")
	public ResponseEntity<String> addMedecin(@RequestBody Medecin medecin){
	
		Medecin savedMedecin = medecinService.saveMedecin(medecin);
		
		if(savedMedecin == null) {
			return new ResponseEntity<>("Une erreur s'est produite", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>("Medecin ajouté avec succès", HttpStatus.CREATED);
	}
}
