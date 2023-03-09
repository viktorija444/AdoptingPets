package com.example.springudomljavanjezivotinja.respositories;

import com.example.springudomljavanjezivotinja.model.Zivotinje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZivotinjeRepository extends JpaRepository<Zivotinje, Long> {

    @Query("SELECT p FROM Zivotinje p WHERE p.imeLjubimca LIKE %?1%"
            + " OR p.tipLjubimca LIKE %?1%"
            + " OR p.opis LIKE %?1%")

    public List<Zivotinje> search(String keyword);
}
