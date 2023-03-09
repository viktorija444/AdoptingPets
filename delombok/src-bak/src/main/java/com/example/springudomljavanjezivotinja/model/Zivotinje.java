package com.example.springudomljavanjezivotinja.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "zivotinje", uniqueConstraints = @UniqueConstraint(columnNames = "imeLjubimca"))
public class Zivotinje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private String imeLjubimca;
    @Column
    private String TipLjubimca;

    private LocalDate datumRodjenja;

    @Lob
    private Byte[] slikaLjubimca;

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


    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTipLjubimca() {
        return TipLjubimca;
    }

    public void setTipLjubimca(String tipLjubimca) {
        TipLjubimca = tipLjubimca;
    }

    public Byte[] getSlikaLjubimca() {
        return slikaLjubimca;
    }

    public void setSlikaLjubimca(Byte[] slikaLjubimca) {
        this.slikaLjubimca = slikaLjubimca;
    }
}


