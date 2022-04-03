package cl.com.mobdev.testbackend.dto;

import java.util.List;

import cl.com.mobdev.testbackend.model.Entity;

public class OriginDto extends Entity {

    private String dimension;
    private List<String> residents;

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

}
