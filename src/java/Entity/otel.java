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
public class otel {
    private Long otelID;
    private String otelAdi;
    private Long yildiz;
    private String ortPuan;
    private Long sehirID;
   
    private kampanya kam;
    private ozellikler ozellik;
    private sehir shr;
    private rezervasyon rez;
    private oda od;
    private ArrayList<ozellikler> otelozellik;
    private ArrayList<kampanya> otelkampanya;

    public ArrayList<kampanya> getOtelkampanya() {
        return otelkampanya;
    }

    public void setOtelkampanya(ArrayList<kampanya> otelkampanya) {
        this.otelkampanya = otelkampanya;
    }
    
    public ArrayList<ozellikler> getOtelozellik() {
        return otelozellik;
    }

    public void setOtelozellik(ArrayList<ozellikler> otelozellik) {
        this.otelozellik = otelozellik;
    }
    

    public oda getOd() {
        return od;
    }

    public void setOd(oda od) {
        this.od = od;
    }

    
    public rezervasyon getRez() {
        return rez;
    }

    public void setRez(rezervasyon rez) {
        this.rez = rez;
    }
  
    public sehir getShr() {
        return shr;
    }

    public void setShr(sehir shr) {
        this.shr = shr;
    }
    
    public ozellikler getOzellik() {
        return ozellik;
    }

    public void setOzellik(ozellikler ozellik) {
        this.ozellik = ozellik;
    }
 
    public kampanya getKam() {
        return kam;
    }

    public void setKam(kampanya kam) {
        this.kam = kam;
    }
     
    
    
    public Long getOtelID() {
        return otelID;
    }

    public void setOtelID(Long otelID) {
        this.otelID = otelID;
    }

    public String getOtelAdi() {
        return otelAdi;
    }

    public void setOtelAdi(String otelAdi) {
        this.otelAdi = otelAdi;
    }

    public Long getYildiz() {
        return yildiz;
    }

    public void setYildiz(Long yildiz) {
        this.yildiz = yildiz;
    }

    public String getOrtPuan() {
        return ortPuan;
    }

    public void setOrtPuan(String ortPuan) {
        this.ortPuan = ortPuan;
    }

    public Long getSehirID() {
        return sehirID;
    }

    public void setSehirID(Long sehirID) {
        this.sehirID = sehirID;
    }

  

    @Override
    public String toString() {
        return "otel{" + "otelID=" + otelID + ", otelAdi=" + otelAdi + ", yildiz=" + yildiz + ", ortPuan=" + ortPuan + ", sehirID=" + sehirID + '}';
    }

    public otel(Long otelID, String otelAdi, Long yildiz, String ortPuan, Long sehirID) {
        this.otelID = otelID;
        this.otelAdi = otelAdi;
        this.yildiz = yildiz;
        this.ortPuan = ortPuan;
        this.sehirID = sehirID;
        
    }

    public otel() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.otelID);
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
        final otel other = (otel) obj;
        if (!Objects.equals(this.otelID, other.otelID)) {
            return false;
        }
        return true;
    }
    
   
    
}
