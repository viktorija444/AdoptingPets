package com.example.springudomljavanjezivotinja.respositories;

import com.example.springudomljavanjezivotinja.model.Zivotinje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZivotinjeRepository extends JpaRepository<Zivotinje, Long> {
}
