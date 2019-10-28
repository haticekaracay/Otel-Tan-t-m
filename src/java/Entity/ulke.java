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
public class ulke {
    private Long ulkeID;
    private String ulkeAdi;
    private Long otelSayisiU;
   
    public Long getOtelSayisiU() {
        return otelSayisiU;
    }

    public void setOtelSayisiU(Long otelSayisiU) {
        this.otelSayisiU = otelSayisiU;
    }

    
    
    public Long getUlkeID() {
        return ulkeID;
    }

    public void setUlkeID(Long ulkeID) {
        this.ulkeID = ulkeID;
    }

    public String getUlkeAdi() {
        return ulkeAdi;
    }

    public void setUlkeAdi(String ulkeAdi) {
        this.ulkeAdi = ulkeAdi;
    }

    @Override
    public String toString() {
        return "ulke{" + "ulkeID=" + ulkeID + ", ulkeAdi=" + ulkeAdi +"otelSayisiU="+ otelSayisiU + '}';
    }

    public ulke(Long ulkeID, String ulkeAdi,Long otelSayisiU) {
        this.ulkeID = ulkeID;
        this.ulkeAdi = ulkeAdi;
        this.otelSayisiU=otelSayisiU;
    }

    public ulke() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.ulkeID);
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
        final ulke other = (ulke) obj;
        if (!Objects.equals(this.ulkeID, other.ulkeID)) {
            return false;
        }
        return true;
    }
    
  
    
    
}
