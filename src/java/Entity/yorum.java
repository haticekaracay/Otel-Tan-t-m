/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author haticeozbakir
 */
public class yorum {
    private Long yorumID;
    private String kisiAdi;
    private String kisiSoyadi;
    private String kisiMail;
    private Long otelID;
    private String yorumY;
   
    private otel otl;

    public otel getOtl() {
        return otl;
    }

    public void setOtl(otel otl) {
        this.otl = otl;
    }
    

    public Long getYorumID() {
        return yorumID;
    }

    public void setYorumID(Long yorumID) {
        this.yorumID = yorumID;
    }

    public String getKisiAdi() {
        return kisiAdi;
    }

    public void setKisiAdi(String kisiAdi) {
        this.kisiAdi = kisiAdi;
    }

    public String getKisiSoyadi() {
        return kisiSoyadi;
    }

    public void setKisiSoyadi(String kisiSoyadi) {
        this.kisiSoyadi = kisiSoyadi;
    }

    public String getKisiMail() {
        return kisiMail;
    }

    public void setKisiMail(String kisiMail) {
        this.kisiMail = kisiMail;
    }

    public Long getOtelID() {
        return otelID;
    }

    public void setOtelID(Long otelID) {
        this.otelID = otelID;
    }

    public String getYorumY() {
        return yorumY;
    }

    public void setYorumY(String yorum) {
        this.yorumY = yorum;
    }

    @Override
    public String toString() {
        return "yorum{" + "yorumID=" + yorumID + ", kisiAdi=" + kisiAdi + ", kisiSoyadi=" + kisiSoyadi + ", kisiMail=" + kisiMail + ", otelID=" + otelID + ", yorumY=" + yorumY + '}';
    }

    public yorum() {
    }

    public yorum(Long yorumID, String kisiAdi, String kisiSoyadi, String kisiMail, Long otelID, String yorumY) {
        this.yorumID = yorumID;
        this.kisiAdi = kisiAdi;
        this.kisiSoyadi = kisiSoyadi;
        this.kisiMail = kisiMail;
        this.otelID = otelID;
        this.yorumY = yorumY;
    }
    

    
    
    
}
