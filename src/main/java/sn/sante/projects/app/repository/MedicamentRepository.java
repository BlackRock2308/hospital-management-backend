package sn.sante.projects.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sn.sante.projects.app.model.Medicament;

@Repository
public interface MedicamentRepository extends CrudRepository<Medicament, String> {

	
}
