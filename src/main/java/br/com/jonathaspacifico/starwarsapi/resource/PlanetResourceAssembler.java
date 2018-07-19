package br.com.jonathaspacifico.starwarsapi.resource;

import br.com.jonathaspacifico.starwarsapi.domain.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

/**
 *
 * @author pacifico
 */

@Component
public class PlanetResourceAssembler extends ResourceAssembler<Planet, PlanetResource> {

    @Autowired
    protected EntityLinks entityLinks;
    private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";

    @Override
    public PlanetResource toResource(Planet planet) {
        PlanetResource resource = new PlanetResource(planet);
        final Link selfLink = entityLinks.linkToSingleResource(planet);
        resource.add(selfLink.withSelfRel());
        resource.add(selfLink.withRel(UPDATE_REL));
        resource.add(selfLink.withRel(DELETE_REL));
        return resource;
    }
}
