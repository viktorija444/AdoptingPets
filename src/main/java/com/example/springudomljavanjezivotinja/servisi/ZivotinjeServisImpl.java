package com.example.springudomljavanjezivotinja.servisi;

import com.example.springudomljavanjezivotinja.model.Zivotinje;
import com.example.springudomljavanjezivotinja.respositories.ZivotinjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ZivotinjeServisImpl implements ZivotinjeServis {


    private ZivotinjeRepository zivotinjeRepository;

    public ZivotinjeServisImpl(ZivotinjeRepository zivotinjeRepository) {
        super();
        this.zivotinjeRepository = zivotinjeRepository;
    }

    @Override
    public List<Zivotinje> getZivotinje(String keyword) {
        if (keyword != null) {
            return zivotinjeRepository.search(keyword);
        } return zivotinjeRepository.findAll();
    }
    @Override
    public void  saveProductToDB(MultipartFile file, String imeLjubimca, String tipLjubimca
            , String opis, String datumRodjenja)
    {
        Zivotinje p = new Zivotinje();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setImeLjubimca(imeLjubimca);

        p.setTipLjubimca(tipLjubimca);
        p.setOpis(opis);
        p.setDatumRodjenja(datumRodjenja);

        zivotinjeRepository.save(p);
    }


    @Override
    public Zivotinje get(Long id) {
        return zivotinjeRepository.findById(id).get();
    }

    @Override
    public Zivotinje updateZivotinje(Zivotinje zivotinje) {
        return zivotinjeRepository.save(zivotinje);
    }



    @Override
    public void deleteZivotinjuById(Long id)
    {
        zivotinjeRepository.deleteById(id);
    }
}
