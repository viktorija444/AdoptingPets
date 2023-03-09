package com.example.springudomljavanjezivotinja.respositories;

import com.example.springudomljavanjezivotinja.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

   Optional <Korisnik> findByEmail(String email);
   Optional<Korisnik> findByBrojTelefona(String brojTelefona);

}
