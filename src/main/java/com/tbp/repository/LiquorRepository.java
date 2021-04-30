package com.tbp.repository;

import com.tbp.model.Liquor;

import java.util.*;

public class LiquorRepository {

    private static List<Liquor> liquorList;

    static {
        Liquor wine = new Liquor("WINE");
        wine.getBranchList().add("Concha y Toro");
        wine.getBranchList().add("J. P. Chenet");

        Liquor whisky = new Liquor("WHISHY");
        whisky.getBranchList().add("Johnnie Walker");
        whisky.getBranchList().add("Glenfiddich");

        Liquor beer = new Liquor("Beer");
        beer.getBranchList().add("Corona");

        liquorList = new ArrayList<Liquor>();
        liquorList.add(wine);
        liquorList.add(whisky);
        liquorList.add(beer);
    }

    public Liquor findByType(String type) {
        for(Liquor l : liquorList) {
            if(l.getType().equals(type)) {
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
        liquor.getBranchList().add(brand);
        liquorList.add(liquor);
    }

}
