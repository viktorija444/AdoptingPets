package com.example.springudomljavanjezivotinja.model;


import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "korisnik", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    private String email;
    private String brojTelefona;
    private String lozinka;
    private String potvrdaLozinke;


    /*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id")) */



    //private Collection<Role> roles;

    public Korisnik() {

    }
    public Korisnik(String ime, String prezime, String email, String brojTelefona, String lozinka, String potvrdaLozinke, Collection<Role> roles) {
        super();
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.lozinka = lozinka;
        this.potvrdaLozinke = potvrdaLozinke;
        //this.roles = roles;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public Collection<Role> getRoles() {
      //  return roles;
   // }

    //public void setRoles(Collection<Role> roles) {
      //  this.roles = roles;
   // }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getPotvrdaLozinke() {
        return potvrdaLozinke;
    }

    public void setPotvrdaLozinke(String potvrdaLozinke) {
        this.potvrdaLozinke = potvrdaLozinke;
    }
}




