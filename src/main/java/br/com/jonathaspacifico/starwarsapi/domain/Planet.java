package br.com.jonathaspacifico.starwarsapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Jonathas
 */
@Document(collection = "planet")
public class Planet implements Identifiable {

    @Id
    private String id;
    private String name;
    private String climate;
    private String terrain;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int appearsOnFilmsCount;

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public int getAppearsOnFilmsCount() {
        return appearsOnFilmsCount;
    }

    public void setAppearsOnFilmsCount(int appearsOnFilmsCount) {
        this.appearsOnFilmsCount = appearsOnFilmsCount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Planet other = (Planet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
