package br.com.jonathaspacifico.starwarsapi.domain;

/**
 *
 * @author Jonathas
 */
public class SwapiPlanet {

    private String name;
    private int rotation_period;
    private int orbital_period;
    private int diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private int surface_water;
    private long population;
    private String[] residents;
    private String[] films;
    private String created;
    private String edited;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(int rotation_period) {
        this.rotation_period = rotation_period;
    }

    public int getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(int orbital_period) {
        this.orbital_period = orbital_period;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public int getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(int surface_water) {
        this.surface_water = surface_water;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String[] getResidents() {
        return residents;
    }

    public void setResidents(String[] residents) {
        this.residents = residents;
    }

    public String[] getFilms() {
        return films;
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
