package com.example.springudomljavanjezivotinja.model;

import javax.persistence.*;

@Entity
public class TipLjubimca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String tipLjubimca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTipLjubimca() {
        return tipLjubimca;
    }

    public void setTipLjubimca(String tipLjubimca) {
        this.tipLjubimca = tipLjubimca;
    }
}
