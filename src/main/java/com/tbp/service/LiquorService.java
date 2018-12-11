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

}
