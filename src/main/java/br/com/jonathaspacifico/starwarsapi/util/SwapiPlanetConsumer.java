package br.com.jonathaspacifico.starwarsapi.util;

import br.com.jonathaspacifico.starwarsapi.domain.SwapiPlanet;
import br.com.jonathaspacifico.starwarsapi.domain.SwapiPlanetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jonathas
 */
@Component
public class SwapiPlanetConsumer {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "https://swapi.co/api/planets?search=";

    public int getSwapiPlanetFilmParticipations(String planetName) {
        SwapiPlanetResult swapiResult = restTemplate.getForObject(BASE_URL + planetName, SwapiPlanetResult.class);
        if (swapiResult != null) {
            SwapiPlanet[] swapiPlanets = swapiResult.getResults();
            for (SwapiPlanet swapiPlanet : swapiPlanets) {
                if (swapiPlanet.getName().equals(planetName)) {
                    return swapiPlanet.getFilms() == null ? null : swapiPlanet.getFilms().length;
                }
            }
        }
        return 0;
    }
}
