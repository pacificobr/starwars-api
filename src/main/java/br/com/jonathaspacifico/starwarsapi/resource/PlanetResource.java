package br.com.jonathaspacifico.starwarsapi.resource;

import br.com.jonathaspacifico.starwarsapi.domain.Planet;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author pacifico
 */
public class PlanetResource extends ResourceSupport {

    @JsonUnwrapped
    private final Planet planet;

    public PlanetResource(Planet planet) {
        this.planet = planet;
    }
}
