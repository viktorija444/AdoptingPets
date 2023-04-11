package com.example.springudomljavanjezivotinja.model;


import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;


@Entity
@Table(name = "user")
public class User implements UserDetails {
    @SequenceGenerator(
            name="users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "users_sequence")
    private Long id;

    @NotNull(message = "First Name cannot be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last Name cannot be empty")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Email cannot be empty")
    @Email(message = "Please enter a valid email address")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phoneNumber", unique = true)
    @Length(min = 9, message = "Phone Number should be at least 9 number long")
    private String phoneNumber;

    @NotNull(message = "Password cannot be empty")
    @Length(min= 7, message = "Password should contain at least 7 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name ="locked")
    private Boolean locked = false;

    @Column(name = "enabled")
    private Boolean enabled = true;

    public User(){

    }

    public User(Long id, String firstName, String lastName, String email, String phoneNumber, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

//    @OneToMany(mappedBy = "user")
//    private List<Animal> animals = new ArrayList<>();
//
//    public List<Animal> getAnimals() {
//        return animals;
//    }
//
//    public void setAnimals(List<Zi> zivotinje) {
//        this.zivotinje = zivotinje;
//    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}





