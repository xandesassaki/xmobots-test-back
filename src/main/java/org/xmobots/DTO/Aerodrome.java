package org.xmobots.DTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="aerodrome")
public class Aerodrome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private String created_at;
    @OneToMany(mappedBy = "aerodrome", cascade = CascadeType.ALL)
    private List<Runways> runways;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<Runways> getRunway() {
        return runways;
    }

    public void setRunway(List<Runways> runways) {
        this.runways = runways;
    }
}
