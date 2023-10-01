package net.map.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MapPoint {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String category;
    private double lat;
    private double lng;


    @SuppressWarnings("unused")
    public MapPoint()
    {
    }

    public MapPoint(String name, String description, String category, double lat, double lng){
        this.name = name;
        this.description = description;
        this.category = category;
        this.lat = lat;
        this.lng = lng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }


    @Override
    public String toString() {
        return "Map point: {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
