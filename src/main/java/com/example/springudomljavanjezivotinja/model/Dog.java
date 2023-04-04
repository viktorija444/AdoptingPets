package com.example.springudomljavanjezivotinja.model;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String petName;


    @Enumerated(EnumType.STRING)
    private TypeOfPet typeOfPet;

    @Column
    private String description;

    private String dateOfBirth;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public Dog(){

    }

    public TypeOfPet getTypeOfPet() {
        return typeOfPet;
    }

    public void setTypeOfPet(TypeOfPet typeOfPet) {
        this.typeOfPet = typeOfPet;
    }

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;


    public Dog(Long id, String petName, String description, String dateOfBirth, String image) {
        this.id = id;
        this.petName = petName;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
    }

    public User getUser() {
        return user;
    }



    public void setUser(User User) {
        this.user = user;
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


    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", petName=" + petName + ", typeOfPet=" + typeOfPet
                + ", description=" + description + ", dateOfBirth="  + dateOfBirth + " + image="
                + image + "]";
    }
}
