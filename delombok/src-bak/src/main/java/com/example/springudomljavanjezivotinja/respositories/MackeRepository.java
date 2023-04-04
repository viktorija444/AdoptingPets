package com.example.springudomljavanjezivotinja.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MackeRepository extends JpaRepository<Macke, Long> {

    Macke findByImeMacke(String imeMacke);
}
