/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author haticeozbakir
 */
public class users {
    private Long userID;
    private String kullaniciAdi;
    private String sifre;
    private ArrayList<groups> group;

    public ArrayList<groups> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<groups> group) {
        this.group = group;
    }
    
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    @Override
    public String toString() {
        return "users{" + "userID=" + userID + ", kullaniciAdi=" + kullaniciAdi + ", sifre=" + sifre + '}';
    }

    public users(Long userID, String kullaniciAdi, String sifre) {
        this.userID = userID;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    public users() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.userID);
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
        final users other = (users) obj;
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        return true;
    }
    
    
    
}
