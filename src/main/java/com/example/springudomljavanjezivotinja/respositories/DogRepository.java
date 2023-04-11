package com.example.springudomljavanjezivotinja.respositories;

import com.example.springudomljavanjezivotinja.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    @Query("SELECT p FROM Dog p WHERE p.petName LIKE %?1%"
            + " OR p.description LIKE %?1%")

    List<Dog> search(String keyword);






}
