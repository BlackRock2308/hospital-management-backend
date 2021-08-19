package sn.sante.projects.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sn.sante.projects.app.model.Medecin;

@Repository
public interface MedecinRepository extends CrudRepository<Medecin, Long> {

}
