package br.com.jonathaspacifico.starwarsapi.controller;

import br.com.jonathaspacifico.starwarsapi.domain.Planet;
import br.com.jonathaspacifico.starwarsapi.repository.PlanetRepository;
import br.com.jonathaspacifico.starwarsapi.resource.PlanetResource;
import br.com.jonathaspacifico.starwarsapi.resource.PlanetResourceAssembler;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pacifico
 */
@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Planet.class)
@RequestMapping(value = "/planet", produces = "application/json")
public class PlanetController {

    @Autowired
    private PlanetRepository repository;
    @Autowired
    private PlanetResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<PlanetResource>> findAllPlanets() {
        List<Planet> planets = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(planets), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<PlanetResource> createPlanet(@RequestBody Planet planet) {
        Planet createdPlanet = repository.insert(planet);
        return new ResponseEntity<>(assembler.toResource(createdPlanet), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PlanetResource> findPlanetById(@PathVariable String id) {
        Optional<Planet> planet = repository.findById(id);
        if (planet.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(planet.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<PlanetResource> findPlanetByName(@PathVariable String name) {
        Optional<Planet> planet = repository.findByName(name);
        if (planet.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(planet.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePlanet(@PathVariable String id) {
        Optional<Planet> planet = repository.findById(id);
        boolean isPresent = planet.isPresent();
        if (isPresent) {
            repository.deleteById(id);
        }
        HttpStatus responseStatus = isPresent ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")    
    public ResponseEntity<PlanetResource> updatePlanet(@RequestBody Planet updatedPlanet) {
        String id = updatedPlanet.getId();
        if(id==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Optional<Planet> planet = repository.findById(id);
        boolean isPresent = planet.isPresent();
        if (isPresent) {
            repository.save(updatedPlanet);
        }
        if (isPresent) {
            return findPlanetById(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
