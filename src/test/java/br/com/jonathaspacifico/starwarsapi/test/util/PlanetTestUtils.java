package br.com.jonathaspacifico.starwarsapi.test.util;

import br.com.jonathaspacifico.starwarsapi.domain.Planet;
import org.junit.Assert;

/**
 *
 * @author Jonathas Pacífico
 */
public class PlanetTestUtils {

    public static void assertAllButIdsMatchBetweenPlanets(Planet expected, Planet actual) {
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getTerrain(), actual.getTerrain());
        Assert.assertEquals(expected.getClimate(), actual.getClimate());
    }

    public static Planet generateTestPlanet() {
        Planet planet = new Planet();
        planet.setName("test name");
        planet.setTerrain("");
        planet.setClimate("Moderate");
        return planet;
    }

    public static Planet generateUpdatedPlanet(Planet original) {
        Planet updated = new Planet();
        updated.setName(original.getName() + " updated");
        updated.setTerrain(original.getTerrain() + " updated");
        updated.setClimate(original.getClimate() + " updated");
        return updated;
    }
}
