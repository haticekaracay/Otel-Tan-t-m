/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author haticeozbakir
 */
public class groups {
    private Long grID;
    private String kullaniciAdi;
    private String sifre;
    private Long userID;

    public Long getGrID() {
        return grID;
    }

    public void setGrID(Long grID) {
        this.grID = grID;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "groups{" + "grID=" + grID + ", kullaniciAdi=" + kullaniciAdi + ", sifre=" + sifre + ", userID=" + userID + '}';
    }

    public groups(Long grID, String kullaniciAdi, String sifre, Long userID) {
        this.grID = grID;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.userID = userID;
    }

    public groups() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.grID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final groups other = (groups) obj;
        if (!Objects.equals(this.grID, other.grID)) {
            return false;
        }
        return true;
    }

    
    
    
}
