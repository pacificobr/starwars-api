package br.com.jonathaspacifico.starwarsapi.domain;

/**
 *
 * @author pacifico
 */
public interface Identifiable extends org.springframework.hateoas.Identifiable<String>{
    public void setId(String id);
}
