package br.com.jonathaspacifico.starwarsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jonathas
 */
@SpringBootApplication
@EnableEntityLinks
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Set user agent because SwapiAPI always resturned HTTP 403 without it. See
     * https://stackoverflow.com/questions/44922261/why-do-i-always-get-403-when-fetching-data-with-resttemplate
     *
     * @param restTemplateBuilder
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
            request.getHeaders().add("user-agent", "spring");
            return execution.execute(request, body);
        };
        return restTemplateBuilder.additionalInterceptors(interceptor).build();
    }
}
