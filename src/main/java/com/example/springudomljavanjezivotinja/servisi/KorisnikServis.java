package com.example.springudomljavanjezivotinja.servisi;

import com.example.springudomljavanjezivotinja.model.Korisnik;
import com.example.springudomljavanjezivotinja.web.dto.KorisnikRegistracijaDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface KorisnikServis extends UserDetailsService {


      Korisnik save(KorisnikRegistracijaDto registracijaDto);











}
