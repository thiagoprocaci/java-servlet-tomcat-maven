package com.tbp.model;

import java.util.*;

public class Liquor {

    String type;
    List<String> branchList;

    public Liquor(String type) {
        this.type = type;
        this.branchList = new ArrayList<String>();
    }

    public String getType() {
        return type;
    }

    public List<String> getBranchList() {
        return branchList;
    }
}
