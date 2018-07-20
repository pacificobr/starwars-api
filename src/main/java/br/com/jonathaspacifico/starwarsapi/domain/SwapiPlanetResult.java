package br.com.jonathaspacifico.starwarsapi.domain;

/**
 *
 * @author Jonathas
 */
public class SwapiPlanetResult extends SwapiResult<SwapiPlanet> {

    public SwapiPlanet[] getResults() {
        return results;
    }

    public void setResults(SwapiPlanet[] results) {
        this.results = results;
    }
}
