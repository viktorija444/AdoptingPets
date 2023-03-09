package com.example.springudomljavanjezivotinja.model;

import javax.persistence.*;

@Entity
@Table(name = "zivotinje")
public class Zivotinje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imeLjubimca;
    @Column
    private String tipLjubimca;

    @Column
    private String opis;

    private String datumRodjenja;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public Zivotinje(){

    }

    public Zivotinje(Long id,String imeLjubimca, String tipLjubimca, String opis, String datumRodjenja, String image) {
        this.id = id;
        this.imeLjubimca = imeLjubimca;
        this.tipLjubimca = tipLjubimca;
        this.opis = opis;
        this.datumRodjenja = datumRodjenja;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getImeLjubimca() {
        return imeLjubimca;
    }

    public void setImeLjubimca(String imeLjubimca) {
        this.imeLjubimca = imeLjubimca;
    }


    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTipLjubimca() {
        return tipLjubimca;
    }

    public void setTipLjubimca(String tipLjubimca) {
        tipLjubimca = tipLjubimca;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Zivotinje [id=" + id + ", imeLjubimca=" + imeLjubimca + ", tipLjubimca="
                + tipLjubimca + ", opis=" + opis + ", datumRodjenja="  + datumRodjenja + " + image="
                + image + "]";
    }

}

