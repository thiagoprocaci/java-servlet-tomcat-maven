package com.tbp.repository;

import java.util.ArrayList;
import java.util.List;

public class LiquorRepository {

    private static List<Liquor> liquorList;

    static {
        Liquor wine = new Liquor("WINE");
        wine.getBrandList().add("Adrianna Vineyard");
        wine.getBrandList().add("J. P. Chenet");

        Liquor whisky = new Liquor("WHISKY");
        whisky.getBrandList().add("Glenfiddich");
        whisky.getBrandList().add("Johnnie Walker");

        Liquor beer = new Liquor("BEER");
        beer.getBrandList().add("Corona");

        liquorList = new ArrayList<Liquor>();
        liquorList.add(wine);
        liquorList.add(whisky);
        liquorList.add(beer);
    }


    public Liquor findByType(String type) {
        for(Liquor l : liquorList) {
            if(l.type.equals(type)) {
                return l;
            }
        }
        return null;
    }

    public List<Liquor> findAll() {
        return liquorList;
    }

    public void save(String type, String brand) {
        Liquor liquor = new Liquor(type);
        liquor.getBrandList().add(brand);
        liquorList.add(liquor);
    }


}
