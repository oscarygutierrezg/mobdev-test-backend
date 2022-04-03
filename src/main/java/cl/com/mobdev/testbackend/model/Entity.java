package cl.com.mobdev.testbackend.model;

public class Entity {

    protected String name;
    protected String url;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
