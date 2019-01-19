package com.tbp.service;

import com.tbp.repository.Liquor;
import com.tbp.repository.LiquorRepository;

import java.util.ArrayList;
import java.util.List;

public class LiquorService {

    public List<String> getAvaliableBrands(String type) {
        LiquorRepository liquorRepository = new LiquorRepository();
        Liquor liquor = liquorRepository.findByType(type);
        if(liquor != null) {
            return liquor.getBrandList();
        }
        return new ArrayList<String>();
    }

    public List<String> getTypes() {
        LiquorRepository liquorRepository = new LiquorRepository();
        List<Liquor> all = liquorRepository.findAll();
        ArrayList<String> typeList = new ArrayList<String>();
        for(Liquor l : all) {
            typeList.add(l.getType());
        }
        return typeList;
    }

    public void saveLiquor(String type, String brand) {
        LiquorRepository liquorRepository = new LiquorRepository();
        liquorRepository.save(type, brand);
    }

}
