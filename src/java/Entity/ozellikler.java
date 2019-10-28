package Entity;

import java.util.ArrayList;
import java.util.Objects;


public class ozellikler {
    private Long ozellikID;
    private String havuz;
    private String kahvalti;
    private String hamamSPA;
    private String otopark;
    private otel otl;
   private ArrayList<otel> otelozellik;
  
    public ArrayList<otel> getOtelozellik() {
        return otelozellik;
    }

    public void setOtelozellik(ArrayList<otel> otelozellik) {
        this.otelozellik = otelozellik;
    }

    public otel getOtl() {
        return otl;
    }

    public void setOtl(otel otl) {
        this.otl = otl;
    }
   
    
    public Long getOzellikID() {
        return ozellikID;
    }

    public void setOzellikID(Long ozellikID) {
        this.ozellikID = ozellikID;
    }

    public String getHavuz() {
        return havuz;
    }

    public void setHavuz(String havuz) {
        this.havuz = havuz;
    }

    public String getKahvalti() {
        return kahvalti;
    }

    public void setKahvalti(String kahvalti) {
        this.kahvalti = kahvalti;
    }

    public String getHamamSPA() {
        return hamamSPA;
    }

    public void setHamamSPA(String hamamSPA) {
        this.hamamSPA = hamamSPA;
    }

    public String getOtopark() {
        return otopark;
    }

    public void setOtopark(String otopark) {
        this.otopark = otopark;
    }

    @Override
    public String toString() {
        return "ozellikler{" + "ozellikID=" + ozellikID + ", havuz=" + havuz + ", kahvalti=" + kahvalti + ", hamamSPA=" + hamamSPA + ", otopark=" + otopark + '}';
    }

    public ozellikler(Long ozellikID, String havuz, String kahvalti, String hamamSPA, String otopark) {
        this.ozellikID = ozellikID;
        this.havuz = havuz;
        this.kahvalti = kahvalti;
        this.hamamSPA = hamamSPA;
        this.otopark = otopark;
    }

    public ozellikler() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.ozellikID);
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
        final ozellikler other = (ozellikler) obj;
        if (!Objects.equals(this.ozellikID, other.ozellikID)) {
            return false;
        }
        return true;
    }
    
    
    
}
