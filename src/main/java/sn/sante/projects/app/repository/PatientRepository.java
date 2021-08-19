package sn.sante.projects.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sn.sante.projects.app.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

	
}
