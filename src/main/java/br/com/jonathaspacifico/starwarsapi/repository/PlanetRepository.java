package br.com.jonathaspacifico.starwarsapi.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.com.jonathaspacifico.starwarsapi.domain.Planet;
import java.util.Optional;

/**
 *
 * @author Jonathas
 */
//@RepositoryRestResource(collectionResourceRel = "planet", path = "planet")
public interface PlanetRepository extends MongoRepository<Planet, String> {

    Optional<Planet> findByName(@Param("name") String name);
}
