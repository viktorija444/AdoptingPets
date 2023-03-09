package com.example.springudomljavanjezivotinja.servisi;

import com.example.springudomljavanjezivotinja.model.Korisnik;
import com.example.springudomljavanjezivotinja.model.Role;
import com.example.springudomljavanjezivotinja.respositories.KorisnikRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class KorisnikServisimpl implements KorisnikServis, UserDetailsService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Korisnik korisnik) {
        String encodedPassword = bCryptPasswordEncoder.encode(korisnik.getPassword());
        korisnik.setPassword(encodedPassword);
        korisnik.setRole(Role.USER);
        korisnikRepository.save(korisnik);
    }

    @Override
    public List<Object> isKorisnikPresent(Korisnik korisnik) {
        boolean postojeciKorisnik = false;
        String message = null;
        Optional<Korisnik> postojeciKorisnickiEmail = korisnikRepository.findByEmail(korisnik.getEmail());
        if(postojeciKorisnickiEmail.isPresent()){
            postojeciKorisnik = true;
            message = "Email vec postoji!";
        }
        Optional<Korisnik> postojeciBrojTelefona = korisnikRepository.findByBrojTelefona(korisnik.getBrojTelefona());
        if(postojeciBrojTelefona.isPresent()){
            postojeciKorisnik = true;
            message = "Broj telefona vec postoji!";
        }
        if (postojeciKorisnickiEmail.isPresent() && postojeciBrojTelefona.isPresent()) {
            message = "Email and Mobile Number Both Already Present!";
        }
        System.out.println("existingUserEmail.isPresent() - "+postojeciKorisnickiEmail.isPresent()+"existingUserMobile.isPresent() - "+postojeciBrojTelefona.isPresent());
        return Arrays.asList(postojeciKorisnik, message);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return korisnikRepository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND", email)
              )  );
    }
}