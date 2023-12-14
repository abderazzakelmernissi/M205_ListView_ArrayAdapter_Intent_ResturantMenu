package com.elmernissi.cc_m205;

import java.io.Serializable;

public class MenuResturant implements Serializable {

    private String nomPlat;
    private double prixPlat;

    public MenuResturant(String nomPlat, double prixPlat) {
        this.nomPlat = nomPlat;
        this.prixPlat = prixPlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public double getPrixPlat() {
        return prixPlat;
    }
}
