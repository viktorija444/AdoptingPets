package com.example.springudomljavanjezivotinja.service;

import com.example.springudomljavanjezivotinja.exception.WrongIDException;
import com.example.springudomljavanjezivotinja.model.Dog;
import com.example.springudomljavanjezivotinja.respositories.DogRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service
public class DogServiceImpl implements DogService{

    private DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public List<Dog> getDogs(String keyword) {
        if (keyword != null) {
            return dogRepository.search(keyword);
        }
        return dogRepository.findAll();
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
    public void saveDog(MultipartFile file, Dog dogs) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            dogs.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        dogRepository.save(dogs);
    }


    @Override
    // za svaki getByID proveriti da li Optional postoji ukoliko postoji vratiti .get ukoliko ne postoji baciti CustomException
    public Dog get(Long id) throws WrongIDException {
        Optional<Dog> dogOptional = dogRepository.findById(id);
        if (dogOptional.isPresent()) {
            return dogOptional.get();
        }
        throw new WrongIDException("ID doesnt exist");
    }

    @Override
    public Dog updateDog(Dog dogs, MultipartFile file, Long id) {

        Dog existingDog = this.get(id);
        String fileNam = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileNam.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            existingDog.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        existingDog.setId(id);
        existingDog.setPetName(dogs.getPetName());
        existingDog.setTypeOfPet(dogs.getTypeOfPet());
        existingDog.setDescription(dogs.getDescription());
        existingDog.setDateOfBirth(dogs.getDateOfBirth());
        return dogRepository.save(existingDog);
    }



    @Override
    public String deleteDogById(Long id) {
        Dog dogDB = get(id);
        if(dogDB != null) {
            dogRepository.delete(dogDB);

            return "Successfully delete";
        }


        return "Unsuccessfully delete";
    }
}
