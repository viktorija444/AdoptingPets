package com.example.springudomljavanjezivotinja.service;

import com.example.springudomljavanjezivotinja.exception.WrongIDException;

import com.example.springudomljavanjezivotinja.model.Cat;
import com.example.springudomljavanjezivotinja.respositories.CatRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service
public class CatServiceImpl implements CatService {


    private CatRepository catRepository;

    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public List<Cat> getCats(String keyword) {
        if (keyword != null) {
            return catRepository.search(keyword);
        }
        return catRepository.findAll();
    }


//    @Override
//    public void saveProductToDB(MultipartFile file, String imeLjubimca, TipLjubimca tipLjubimca
//            , String opis, String datumRodjenja) {
//        Zivotinja p = new Zivotinja();
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        if (fileName.contains("..")) {
//            System.out.println("not a a valid file");
//        }
//        try {
//            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        p.setImeLjubimca(imeLjubimca);
//
//        p.setTipLjubimca(tipLjubimca);
//        p.setOpis(opis);
//        p.setDatumRodjenja(datumRodjenja);
//
//        zivotinjeRepository.save(p);
//    }

    @Override
    public void saveCat(MultipartFile file, Cat cats) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            cats.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        catRepository.save(cats);
    }


    @Override
    // za svaki getByID proveriti da li Optional postoji ukoliko postoji vratiti .get ukoliko ne postoji baciti CustomException
    public Cat get(Long id) throws WrongIDException {
        Optional<Cat> zivotinjaOptional = catRepository.findById(id);
        if (zivotinjaOptional.isPresent()) {
           return zivotinjaOptional.get();
        }
            throw new WrongIDException("ID doesnt exist");
    }

    @Override
    public Cat updateCat(Cat cats, MultipartFile file, Long id) {

        Cat existingCat = this.get(id);
        String fileNam = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileNam.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            existingCat.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        existingCat.setId(id);
        existingCat.setPetName(cats.getPetName());
        existingCat.setTypeOfPet(cats.getTypeOfPet());
        existingCat.setDescription(cats.getDescription());
        existingCat.setDateOfBirth(cats.getDateOfBirth());
        return catRepository.save(existingCat);
    }



    @Override
    public String deleteCatById(Long id) {
        Cat catDB = get(id);
        if(catDB != null) {
            catRepository.delete(catDB);

            return "Successfully delete";
        }


        return "Unsuccessfully delete";
    }
}
