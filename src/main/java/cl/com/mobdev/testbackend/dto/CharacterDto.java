package cl.com.mobdev.testbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterDto {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    @JsonProperty("episode_count")
    private int episodeCount;
    private OriginDto origin;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setOrigin(OriginDto origin) {
        this.origin = origin;
    }

    public OriginDto getOrigin() {
        return origin;
    }

}
