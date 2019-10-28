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
public class kampanya {
    private Long kamID;
    private String kamAdi;
    private String kamBilgi;
    private String kamBaslangic;
    private String kamBitis;
    private ArrayList<otel> otelkampanya;

    public ArrayList<otel> getOtelkampanya() {
        return otelkampanya;
    }

    public void setOtelkampanya(ArrayList<otel> otelkampanya) {
        this.otelkampanya = otelkampanya;
    }
    
    
    public Long getKamID() {
        return kamID;
    }

    public void setKamID(Long kamID) {
        this.kamID = kamID;
    }

    public String getKamAdi() {
        return kamAdi;
    }

    public void setKamAdi(String kamAdi) {
        this.kamAdi = kamAdi;
    }

    public String getKamBilgi() {
        return kamBilgi;
    }

    public void setKamBilgi(String kamBilgi) {
        this.kamBilgi = kamBilgi;
    }

    public String getKamBaslangic() {
        return kamBaslangic;
    }

    public void setKamBaslangic(String kamBaslangic) {
        this.kamBaslangic = kamBaslangic;
    }

    public String getKamBitis() {
        return kamBitis;
    }

    public void setKamBitis(String kamBitis) {
        this.kamBitis = kamBitis;
    }

    @Override
    public String toString() {
        return "kampanya{" + "kamID=" + kamID + ", kamAdi=" + kamAdi + ", kamBilgi=" + kamBilgi + ", kamBaslangic=" + kamBaslangic + ", kamBitis=" + kamBitis + '}';
    }

    public kampanya(Long kamID, String kamAdi, String kamBilgi, String kamBaslangic, String kamBitis) {
        this.kamID = kamID;
        this.kamAdi = kamAdi;
        this.kamBilgi = kamBilgi;
        this.kamBaslangic = kamBaslangic;
        this.kamBitis = kamBitis;
    }

    public kampanya() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.kamID);
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
        final kampanya other = (kampanya) obj;
        if (!Objects.equals(this.kamID, other.kamID)) {
            return false;
        }
        return true;
    }
    
}
