package com.example.springudomljavanjezivotinja.service;

import com.example.springudomljavanjezivotinja.exception.WrongIDException;
import com.example.springudomljavanjezivotinja.model.Cat;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface CatService {

    List<Cat> getCats(String keyword);

   // void saveProductToDB(MultipartFile file, String imeLjubimca, TipLjubimca tipLjubimca
           // , String opis, String datumRodjenja);

    void saveCat(MultipartFile file, Cat cats);


    Cat get(Long id) throws WrongIDException;

    String deleteCatById(Long id);

    Cat updateCat(Cat cats, MultipartFile file, Long id);

}

