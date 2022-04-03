package cl.com.mobdev.testbackend.model;

import java.util.List;

public class Location extends Entity {

    private int id;
    private String type;
    private String dimension;
    private List<String> residents;
    private String created;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDimension() {
        return dimension;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreated() {
        return created;
    }

}
