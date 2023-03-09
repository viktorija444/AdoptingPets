package com.example.springudomljavanjezivotinja.servisi;

import com.example.springudomljavanjezivotinja.model.Korisnik;
import com.example.springudomljavanjezivotinja.web.dto.KorisnikRegistracijaDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Objects;

public interface KorisnikServis extends UserDetailsService {


      public void save(Korisnik korisnik);
      public List<Object> isKorisnikPresent(Korisnik korisnik);











}
