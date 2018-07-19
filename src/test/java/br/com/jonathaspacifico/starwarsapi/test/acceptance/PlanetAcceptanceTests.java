package br.com.jonathaspacifico.starwarsapi.test.acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author pacifico
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/acceptance")
@WebAppConfiguration
public class PlanetAcceptanceTests {
    
}
