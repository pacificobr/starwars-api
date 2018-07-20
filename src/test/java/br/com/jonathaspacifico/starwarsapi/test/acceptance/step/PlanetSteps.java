package br.com.jonathaspacifico.starwarsapi.test.acceptance.step;

import br.com.jonathaspacifico.starwarsapi.test.acceptance.util.AbstractSteps;
import com.fasterxml.jackson.core.type.TypeReference;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import org.junit.Assert;

/**
 *
 * @author Jonathas Pacífico
 */
public class PlanetSteps extends AbstractSteps {

    private static final String TEST_PLANET = "{ \"name\" : \"Tatooine\", \"terrain\" : \"desert\" , \"climate\" : \"arid\" }";
    private static final TypeReference<Map<String, Object>> RESOURCE_TYPE = new TypeReference<Map<String, Object>>() {
    };

    @Given("^an planet exists$")
    public void anPlanetExists() throws Throwable {
        createPlanet();
    }

    private void createPlanet() throws Exception {
        post("/planet", TEST_PLANET);
    }

    @When("^the user creates an planet$")
    public void theUserCallsGetPlanets() throws Throwable {
        createPlanet();
    }

    @When("^the user deletes the created planet$")
    public void theUserDeletesTheCreatedPlanet() throws Throwable {
        delete("/planet/{id}", getCreatedId());
    }

    private Object getCreatedId() throws Exception {
        return getLastPostContentAs(RESOURCE_TYPE).get("id");
    }

    @And("^the planet is successfully created$")
    public void thePlanetIsSuccessfullyCreated() {
        Assert.assertEquals(201, getLastPostResponse().getStatus());
    }

    @And("^the user gets the created planet$")
    public void theUserRetrievesThePlanet() throws Throwable {
        get("/planet/{id}", getCreatedId());
    }

    @Then("^the user receives status code of (\\d+)$")
    public void theUserReceivesStatusCodeOf(int statusCode) throws Throwable {
        Assert.assertEquals(statusCode, getLastStatusCode());
    }

    @And("^the retrieved planet is correct$")
    public void theRetrievedPlanetIsCorrect() throws Throwable {
        assertPlanetResourcesMatch(getLastPostContentAs(RESOURCE_TYPE), getLastGetContentAs(RESOURCE_TYPE));
    }

    private static void assertPlanetResourcesMatch(Map<String, Object> expected, Map<String, Object> actual) {
        Assert.assertEquals(expected.size(), actual.size());

        for (String key : expected.keySet()) {
            Assert.assertEquals(expected.get(key), actual.get(key));
        }
    }
}
