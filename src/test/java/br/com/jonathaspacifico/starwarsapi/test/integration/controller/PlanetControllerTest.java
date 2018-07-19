//package br.com.jonathaspacifico.starwarsapi.test.integration.controller;
//
//import br.com.jonathaspacifico.starwarsapi.domain.Planet;
//import br.com.jonathaspacifico.starwarsapi.repository.PlanetRepository;
//import java.util.List;
//import static org.hamcrest.CoreMatchers.equalTo;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityLinks;
//import org.springframework.test.web.servlet.ResultActions;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// *
// * @author Jonathas Pacífico
// */
//public class PlanetControllerTest extends ControllerIntegrationTest {
//
//    private static final String INVALID_TEST_PLANET = "";
//    private static final String TEST_PLANET = "{\"description\": \"Some test description\", \"costInCents\": 200}";
//    private static final String TEST_PLANET_MISSING_PLANET_DATA = "{\"foo\": \"bar\"}";
//
//    @Autowired
//    private PlanetRepository repository;
//
//    @Autowired
//    private EntityLinks entityLinks;
//
//    @Before
//    public void setUp() {
//        repository.deleteAll();        
//    }
//
//    @Test
//    public void testGetAllEmptyListEnsureCorrectResponse() throws Exception {
//        assertNoPlanets();
//        getPlanet()
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("[]")));
//    }
//
//    private ResultActions getPlanet() throws Exception {
//        return get("/planet");
//    }
//
//    private void assertNoPlanets() {
//        assertPlanetCountIs(0);
//    }
//
//    private void assertPlanetCountIs(int count) {
//        Assert.assertEquals(count, repository.count());
//    }
//
//    @Test
//    public void testGetAllOnePlanetEnsureCorrectResponse() throws Exception {
//        Planet injectedPlanet = injectPlanet();
//        assertPlanetCountIs(1);
//        getPlanet()
//                .andExpect(status().isOk())
//                .andExpect(planetAtIndexIsCorrect(0, injectedPlanet));
//    }
//
//    @Test
//    public void testGetAllOnePlanetEnsureCorrectLinks() throws Exception {
//        Planet injectedPlanet = injectPlanet();
//        assertPlanetCountIs(1);
//        getPlanet()
//                .andExpect(status().isOk())
//                .andExpect(planetLinksAtIndexAreCorrect(0, injectedPlanet, entityLinks));
//    }
//
//    private Planet injectPlanet() {
//        Planet planet = new Planet();
//        planet.setDescription("Test description");
//
//        return repository.create(planet);
//    }
//
//    @Test
//    public void testGetAllTwoPlanetEnsureCorrectResponse() throws Exception {
//        Planet injectedPlanet1 = injectPlanet();
//        Planet injectedPlanet2 = injectPlanet();
//        assertPlanetCountIs(2);
//        getPlanet()
//                .andExpect(status().isOk())
//                .andExpect(planetAtIndexIsCorrect(0, injectedPlanet1))
//                .andExpect(planetAtIndexIsCorrect(1, injectedPlanet2));
//    }
//
//    @Test
//    public void testGetAllTwoPlanetEnsureCorrectLinks() throws Exception {
//        Planet injectedPlanet1 = injectPlanet();
//        Planet injectedPlanet2 = injectPlanet();
//        assertPlanetCountIs(2);
//        getPlanet()
//                .andExpect(status().isOk())
//                .andExpect(planetLinksAtIndexAreCorrect(0, injectedPlanet1, entityLinks))
//                .andExpect(planetLinksAtIndexAreCorrect(1, injectedPlanet2, entityLinks));
//    }
//
//    @Test
//    public void testGetNonexistentPlanetEnsureNotFoundResponse() throws Exception {
//        assertNoPlanets();
//        getPlanet(1)
//                .andExpect(status().isNotFound());
//    }
//
//    private ResultActions getPlanet(long id) throws Exception {
//        return get("/planet/{id}", id);
//    }
//
//    @Test
//    public void testGetExistingPlanetEnsureCorrectResponse() throws Exception {
//        Planet injectedPlanet = injectPlanet();
//        assertPlanetCountIs(1);
//        getPlanet(injectedPlanet.getId())
//                .andExpect(status().isOk())
//                .andExpect(planetIsCorrect(injectedPlanet));
//    }
//
//    @Test
//    public void testGetExistingPlanetEnsureCorrectLinks() throws Exception {
//        Planet injectedPlanet = injectPlanet();
//        assertPlanetCountIs(1);
//        getPlanet(injectedPlanet.getId())
//                .andExpect(status().isOk())
//                .andExpect(planetLinksAreCorrect(injectedPlanet, entityLinks));
//    }
//
//    @Test
//    public void testCreateNewPlanetEnsurePlanetCreated() throws Exception {
//        assertNoPlanets();
//        Planet desiredPlanet = generateTestPlanet();
//        createPlanet(toJsonString(desiredPlanet));
//        assertPlanetCountIs(1);
//        assertAllButIdsMatchBetweenPlanets(desiredPlanet, getCreatedPlanet());
//    }
//
//    private ResultActions createPlanet(String payload) throws Exception {
//        return post("/planet", payload);
//    }
//
//    private Planet getCreatedPlanet() {
//        List<Planet> planets = repository.findAll();
//        return planets.get(planets.size() - 1);
//    }
//
//    @Test
//    public void testCreateNewPlanetEnsureCorrectResponse() throws Exception {
//        assertNoPlanets();
//        createPlanet(TEST_PLANET)
//                .andExpect(status().isCreated())
//                .andExpect(planetIsCorrect(getCreatedPlanet()));
//    }
//
//    @Test
//    public void testCreateNewPlanetEnsureCorrectLinks() throws Exception {
//        assertNoPlanets();
//        createPlanet(TEST_PLANET)
//                .andExpect(status().isCreated())
//                .andExpect(planetLinksAreCorrect(getCreatedPlanet(), entityLinks));
//    }
//
//    @Test
//    public void testCreateNewPlanetMissingDataEnsureCorrectResponse() throws Exception {
//        assertNoPlanets();
//        createPlanet(TEST_PLANET_MISSING_PLANET_DATA)
//                .andExpect(status().isCreated())
//                .andExpect(planetIsCorrect(getCreatedPlanet()));
//    }
//
//    @Test
//    public void testCreateInvalidNewPlanetEnsureCorrectResponse() throws Exception {
//        assertNoPlanets();
//        createPlanet(INVALID_TEST_PLANET)
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    public void testDeleteNonexistentPlanetEnsureCorrectResponse() throws Exception {
//        assertNoPlanets();
//        deletePlanet(1)
//                .andExpect(status().isNotFound());
//    }
//
//    private ResultActions deletePlanet(long id) throws Exception {
//        return delete("/planet/{id}", id);
//    }
//
//    @Test
//    public void testDeleteExistingPlanetEnsureCorrectResponse() throws Exception {
//        Planet injectedPlanet = injectPlanet();
//        assertPlanetCountIs(1);
//        deletePlanet(injectedPlanet.getId())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void testDeleteExistingPlanetEnsurePlanetDeleted() throws Exception {
//        Planet injectedPlanet = injectPlanet();
//        assertPlanetCountIs(1);
//        deletePlanet(injectedPlanet.getId());
//        assertNoPlanets();
//    }
//
//    @Test
//    public void testUpdateNonexistentPlanetEnsureCorrectResponse() throws Exception {
//        assertNoPlanets();
//        updatePlanet(1, new Planet())
//                .andExpect(status().isNotFound());
//    }
//
//    private ResultActions updatePlanet(long id, Planet updatedPlanet) throws Exception {
//        return put("/planet/{id}", updatedPlanet, String.valueOf(id));
//    }
//
//    @Test
//    public void testUpdateExistingPlanetEnsurePlanetUpdated() throws Exception {
//        Planet originalPlanet = injectPlanet();
//        assertPlanetCountIs(1);
//        Planet updatedPlanet = generateUpdatedPlanet(originalPlanet);
//        updatePlanet(originalPlanet.getId(), updatedPlanet);
//        assertAllButIdsMatchBetweenPlanets(updatedPlanet, originalPlanet);
//    }
//
//    @Test
//    public void testUpdateExistingPlanetEnsureCorrectResponse() throws Exception {
//        Planet originalPlanet = injectPlanet();
//        assertPlanetCountIs(1);
//        Planet updatedPlanet = generateUpdatedPlanet(originalPlanet);
//        updatePlanet(originalPlanet.getId(), updatedPlanet)
//                .andExpect(status().isOk())
//                .andExpect(updatedPlanetIsCorrect(originalPlanet.getId(), updatedPlanet));
//    }
//}
