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
public class oda {
    private Long odaID;
    private String odaTuru;
    private Long yatakSayisi;
    private Long odaFiyat;
    private Long otelID;
   
    private otel otl;

    public otel getOtl() {
        return otl;
    }

    public void setOtl(otel otl) {
        this.otl = otl;
    }
    
    
    public Long getOdaID() {
        return odaID;
    }

    public void setOdaID(Long odaID) {
        this.odaID = odaID;
    }

    public String getOdaTuru() {
        return odaTuru;
    }

    public void setOdaTuru(String odaTuru) {
        this.odaTuru = odaTuru;
    }

    public Long getYatakSayisi() {
        return yatakSayisi;
    }

    public void setYatakSayisi(Long yatakSayisi) {
        this.yatakSayisi = yatakSayisi;
    }

    public Long getOdaFiyat() {
        return odaFiyat;
    }

    public void setOdaFiyat(Long odaFiyat) {
        this.odaFiyat = odaFiyat;
    }

    public Long getOtelID() {
        return otelID;
    }

    public void setOtelID(Long otelID) {
        this.otelID = otelID;
    }

    public oda(Long odaID, String odaTuru, Long yatakSayisi, Long odaFiyat, Long otelID) {
        this.odaID = odaID;
        this.odaTuru = odaTuru;
        this.yatakSayisi = yatakSayisi;
        this.odaFiyat = odaFiyat;
        this.otelID = otelID;
    }

    public oda() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.odaID);
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
        final oda other = (oda) obj;
        if (!Objects.equals(this.odaID, other.odaID)) {
            return false;
        }
        return true;
    }

    
    
}
