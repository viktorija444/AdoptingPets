package com.example.springudomljavanjezivotinja.servisi;

import com.example.springudomljavanjezivotinja.model.Zivotinje;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ZivotinjeServis {

    List<Zivotinje> getZivotinje(String keyword);

    void saveProductToDB(MultipartFile file, String imeLjubimca, String tipLjubimca
            , String opis, String datumRodjenja);

    Zivotinje get(Long id);

    Zivotinje updateZivotinje(Zivotinje zivotinje);

    void deleteZivotinjuById(Long id);
}

