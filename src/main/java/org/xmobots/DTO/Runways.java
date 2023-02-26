package org.xmobots.DTO;

import javax.persistence.*;

@Entity
@Table(name = "runways")
public class Runways {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "designation")
    private String designation;
    @Column(name = "width")
    private int width;
    @Column(name = "length")
    private int length;

    @ManyToOne
    @JoinColumn(name = "aerodrome_id")
    private Aerodrome aerodrome;

    public Aerodrome getAerodrome() {
        return aerodrome;
    }

    public void setAerodrome(Aerodrome aerodrome) {
        this.aerodrome = aerodrome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
