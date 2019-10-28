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
public class dosya {
    private Long dosyaID;
   private String dosyaYolu;
   private String dosyaAdi;
   private String dosyaTipi;
   private Long otelID;
   private otel otl;

    public otel getOtl() {
        return otl;
    }

    public void setOtl(otel otl) {
        this.otl = otl;
    }
    public Long getDosyaID() {
        return dosyaID;
    }

    public void setDosyaID(Long dosyaID) {
        this.dosyaID = dosyaID;
    }

    public String getDosyaYolu() {
        return dosyaYolu;
    }

    public void setDosyaYolu(String dosyaYolu) {
        this.dosyaYolu = dosyaYolu;
    }

    public String getDosyaAdi() {
        return dosyaAdi;
    }

    public void setDosyaAdi(String dosyaAdi) {
        this.dosyaAdi = dosyaAdi;
    }

    public String getDosyaTipi() {
        return dosyaTipi;
    }

    public void setDosyaTipi(String dosyaTipi) {
        this.dosyaTipi = dosyaTipi;
    } 

    public Long getOtelID() {
        return otelID;
    }

    public void setOtelID(Long otelID) {
        this.otelID = otelID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.dosyaID);
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
        final dosya other = (dosya) obj;
        if (!Objects.equals(this.dosyaID, other.dosyaID)) {
            return false;
        }
        return true;
    }
    
    
}
