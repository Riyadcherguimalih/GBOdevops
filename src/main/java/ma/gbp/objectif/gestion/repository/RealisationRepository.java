package ma.gbp.objectif.gestion.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import ma.gbp.objectif.gestion.model.objectif.Realisation;

public interface RealisationRepository extends CrudRepository<Realisation, Long> {
	Set<Realisation> findAll();

}

