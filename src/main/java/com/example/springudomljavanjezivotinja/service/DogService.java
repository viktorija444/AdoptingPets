package com.example.springudomljavanjezivotinja.service;

import com.example.springudomljavanjezivotinja.exception.WrongIDException;
import com.example.springudomljavanjezivotinja.model.Cat;
import com.example.springudomljavanjezivotinja.model.Dog;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DogService {

    List<Dog> getDogs(String keyword);

    // void saveProductToDB(MultipartFile file, String imeLjubimca, TipLjubimca tipLjubimca
    // , String opis, String datumRodjenja);

    void saveDog(MultipartFile file, Dog dogs);


    Dog get(Long id) throws WrongIDException;

    String deleteDogById(Long id);

    Dog updateDog(Dog dogs, MultipartFile file, Long id);
}
