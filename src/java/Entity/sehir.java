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
public class sehir {
    private Long sehirID;
    private String sehirAdi;
    private Long otelSayisi;
    private Long ulkeID;
    private ulke ulk;
    private otel otl;

    public otel getOtl() {
        return otl;
    }

    public void setOtl(otel otl) {
        this.otl = otl;
    }
    public ulke getUlk() {
        return ulk;
    }

    public void setUlk(ulke ulk) {
        this.ulk = ulk;
    }
    
    public Long getOtelSayisi() {
        return otelSayisi;
    }

    public void setOtelSayisi(Long otelSayisi) {
        this.otelSayisi = otelSayisi;
    }
    
    
    public Long getSehirID() {
        return sehirID;
    }
    public void setSehirID(Long sehirID) {
        this.sehirID = sehirID;
    }
    
    public String getSehirAdi() {
        return sehirAdi;
    }

    public void setSehirAdi(String sehirAdi) {
        this.sehirAdi = sehirAdi;
    }

    public Long getUlkeID() {
        return ulkeID;
    }

    public void setUlkeID(Long ulkeID) {
        this.ulkeID = ulkeID;
    }

    public sehir(Long sehirID, String sehirAdi,Long otelSayisi, Long ulkeID) {
        this.sehirID = sehirID;
        this.sehirAdi = sehirAdi;
        this.otelSayisi=otelSayisi;
        this.ulkeID = ulkeID;
    }

    public sehir(String sehirAdi, Long ulkeID) {
        this.sehirAdi = sehirAdi;
        this.ulkeID = ulkeID;
    }

    public sehir(String sehirAdi) {
        this.sehirAdi = sehirAdi;
    }

    @Override
    public String toString() {
        return "sehir{" + "sehirID=" + sehirID + ", sehirAdi=" + sehirAdi +",otelSayisi="+ otelSayisi + ", ulkeID=" + ulkeID + '}';
    }

    public sehir() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.sehirID);
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
        final sehir other = (sehir) obj;
        if (!Objects.equals(this.sehirID, other.sehirID)) {
            return false;
        }
        return true;
    }

    
    
    
}
