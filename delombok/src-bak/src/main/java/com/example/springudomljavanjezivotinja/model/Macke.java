package com.example.springudomljavanjezivotinja.model;

import javax.persistence.*;

@Entity
@Table(name = "macke", uniqueConstraints = @UniqueConstraint(columnNames = "imeMacke"))
public class Macke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imeMacke")
    private String imeMacke;

    private String opis;

    public Macke(String ime, String opis) {
        super();
        this.imeMacke = imeMacke;
        this.opis = opis;
    }

    public Macke() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImeMacke() {
        return imeMacke;
    }

    public void setImeMacke(String imeMacke) {
        this.imeMacke = imeMacke;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
