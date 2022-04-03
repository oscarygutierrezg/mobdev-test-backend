package cl.com.mobdev.testbackend.model;

import java.util.List;

public class Character extends Entity {

    private int id;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Entity origin;
    private Entity entity;
    private String image;
    private List<String> episode;
    private String created;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setOrigin(Entity origin) {
        this.origin = origin;
    }

    public Entity getOrigin() {
        return origin;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    public List<String> getEpisode() {
        return episode;
    }


    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreated() {
        return created;
    }

}
