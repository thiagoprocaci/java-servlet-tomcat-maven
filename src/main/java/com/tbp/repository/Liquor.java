package com.tbp.repository;

import java.util.ArrayList;
import java.util.List;

public class Liquor {

    String type;
    List<String> brandList;

    public Liquor(String type) {
        this.type = type;
        this.brandList = new ArrayList<String>();
    }


    public String getType() {
        return type;
    }

    public List<String> getBrandList() {
        return brandList;
    }
}
