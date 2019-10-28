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
public class rezervasyon {
    private Long rezID;
    private String gidisTarihi;
    private String donusTarihi;
    private Long otelID;
   
    private otel otl;

    public otel getOtl() {
        return otl;
    }

    public void setOtl(otel otl) {
        this.otl = otl;
    }
    
    
    public Long getRezID() {
        return rezID;
    }

    public void setRezID(Long rezID) {
        this.rezID = rezID;
    }

    public String getGidisTarihi() {
        return gidisTarihi;
    }

    public void setGidisTarihi(String gidisTarihi) {
        this.gidisTarihi = gidisTarihi;
    }

    public String getDonusTarihi() {
        return donusTarihi;
    }

    public void setDonusTarihi(String donusTarihi) {
        this.donusTarihi = donusTarihi;
    }

    public Long getOtelID() {
        return otelID;
    }

    public void setOtelID(Long otelID) {
        this.otelID = otelID;
    }

    @Override
    public String toString() {
        return "rezervasyon{" + "rezID=" + rezID + ", gidisTarihi=" + gidisTarihi + ", donusTarihi=" + donusTarihi + ", otelID=" + otelID + '}';
    }

    public rezervasyon(Long rezID, String gidisTarihi, String donusTarihi, Long otelID) {
        this.rezID = rezID;
        this.gidisTarihi = gidisTarihi;
        this.donusTarihi = donusTarihi;
        this.otelID = otelID;
    }

    public rezervasyon() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.rezID);
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
        final rezervasyon other = (rezervasyon) obj;
        if (!Objects.equals(this.rezID, other.rezID)) {
            return false;
        }
        return true;
    }
   
   
    
    
}
