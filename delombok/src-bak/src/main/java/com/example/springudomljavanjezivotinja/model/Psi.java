package com.example.springudomljavanjezivotinja.model;

import javax.persistence.*;

@Entity
@Table(name = "psi", uniqueConstraints = @UniqueConstraint(columnNames = "imePsa"))
public class Psi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imePsa")
    private String imePsa;

    private String opis;

    public Psi(String imePsa, String opis) {
        super();
        this.opis = opis;
        this.imePsa = imePsa;
    }

    public Psi() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImePsa() {
        return imePsa;
    }

    public void setImePsa(String imePsa) {
        this.imePsa = imePsa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
