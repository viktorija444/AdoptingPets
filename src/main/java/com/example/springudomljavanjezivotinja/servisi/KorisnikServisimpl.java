package com.example.springudomljavanjezivotinja.servisi;

import com.example.springudomljavanjezivotinja.model.Korisnik;
import com.example.springudomljavanjezivotinja.model.Role;
import com.example.springudomljavanjezivotinja.respositories.KorisnikRepository;
import com.example.springudomljavanjezivotinja.web.dto.KorisnikRegistracijaDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class KorisnikServisimpl implements KorisnikServis {

    private KorisnikRepository korisnikRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public KorisnikServisimpl(KorisnikRepository korisnikRepository) {
        super();
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik save(KorisnikRegistracijaDto registracijaDto) {
        Korisnik korisnik = new Korisnik(registracijaDto.getIme(),
                registracijaDto.getPrezime(), registracijaDto.getEmail(),
                registracijaDto.getBrojTelefona(), registracijaDto.getPotvrdaLozinke(),
                passwordEncoder.encode(registracijaDto.getLozinka()), Arrays.asList(new Role("ROLE_USER")));

    return korisnikRepository.save(korisnik);

    }


    @Override
    public UserDetails loadUserByUsername(String ime) throws UsernameNotFoundException {

        Korisnik korisnik = korisnikRepository.findByEmail(ime);
        if(korisnik == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(korisnik.getEmail(), korisnik.getLozinka(), mapRolesToAuthorities(korisnik.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}