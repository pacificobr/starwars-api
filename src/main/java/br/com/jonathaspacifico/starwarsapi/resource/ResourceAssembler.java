package br.com.jonathaspacifico.starwarsapi.resource;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * @author pacifico
 * @param <DomainType>
 * @param <ResourceType>
 */
public abstract class ResourceAssembler<DomainType, ResourceType> {

    public abstract ResourceType toResource(DomainType domainObject);

    public Collection<ResourceType> toResourceCollection(Collection<DomainType> domainObjects) {
        return domainObjects.stream().map(o -> toResource(o)).collect(Collectors.toList());
    }
}
