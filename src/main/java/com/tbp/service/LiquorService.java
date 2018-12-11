package com.tbp.service;

import java.util.ArrayList;
import java.util.List;

public class LiquorService {

    public List<String> getAvaliableBrands(String type) {
        List<String> brands = new ArrayList<String>();

        if("WINE".equals(type)){
            brands.add("Adrianna Vineyard");
            brands.add(("J. P. Chenet"));
        } else if("WHISKY".equals(type)){
            brands.add("Glenfiddich");
            brands.add("Johnnie Walker");
        } else if("BEER".equals(type)){
            brands.add("Corona");
        } else {
            brands.add("No Brand Available");
        }
        return brands;
    }

}
