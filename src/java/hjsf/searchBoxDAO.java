/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hjsf;

import DAO.kampanyaDAO;
import DAO.odaDAO;
import DAO.ozelliklerDAO;
import DAO.rezervasyonDAO;
import DAO.yorumDAO;
import Entity.kampanya;
import Entity.oda;
import Entity.otel;
import Entity.ozellikler;
import Entity.rezervasyon;
import Entity.sehir;
import Entity.yorum;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haticeozbakir
 */
public class searchBoxDAO {
     private otel otl=null;
     private sehir shr=null;
    private ArrayList<otel> otllist=null;
    private kampanyaDAO kamDAO;
    private yorumDAO yrmDAO;
    private odaDAO odaDAO;
    private rezervasyonDAO rezervasyonDAO;
    private ozelliklerDAO ozelliklerDAO;

    public sehir getShr() {
        if(this.shr==null)
            this.shr=new sehir();
        return shr;
    }

    public void setShr(sehir shr) {
        this.shr = shr;
    }
    
    public yorumDAO getYrmDAO() {
        return yrmDAO;
    }
    public void setYrmDAO(yorumDAO yrmDAO) {
        this.yrmDAO = yrmDAO;
    }
    public kampanyaDAO getKamDAO() {
        return kamDAO;
    }

    public void setKamDAO(kampanyaDAO kamDAO) {
        this.kamDAO = kamDAO;
    }
    public ozelliklerDAO getozelliklerDAO() {
        if(this.ozelliklerDAO==null)
                this.ozelliklerDAO=new ozelliklerDAO();
       return ozelliklerDAO;
    }

    public void setozelliklerDAO(ozelliklerDAO ozelliklerDAO) {
        this.ozelliklerDAO = ozelliklerDAO;
    }
    public odaDAO getOdaDAO() {
        if(this.odaDAO==null){
        this.odaDAO=new odaDAO();
        }
        return odaDAO;
    }

    public rezervasyonDAO getRezervasyonDAO() {
        if(this.rezervasyonDAO==null){
            this.rezervasyonDAO=new rezervasyonDAO();
        }
        return rezervasyonDAO;
    }
    public List<otel> getOtl(){
    List<otel> otllist= new ArrayList<>();
    
     Connection con =ConnectionManager.getConnection();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from otel where sehirID in(select sehirID from sehir where sehirAdi='"+getShr().getSehirAdi()+"')");
           while(rs.next()) {
               otel o=new otel();
               o.setOtelID(rs.getLong("otelID"));
               o.setOtelAdi(rs.getString("otelAdi"));
               o.setYildiz(rs.getLong("yildiz"));
               o.setOrtPuan(rs.getString("ortPuan"));
               o.setSehirID(rs.getLong("sehirID"));
              
              
               this.otllist.add(o);     
           }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
return otllist;
}
    public otel getOtl(Long id) {
        Connection con=ConnectionManager.getConnection();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from otel where sehirID="+id);
            rs.next();
            this.otl=new otel(rs.getLong("otelID"),rs.getString("otelAdi"),rs.getLong("yildiz"),rs.getString("ortPuan"),rs.getLong("sehirID"));
       }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return this.otl;
    }
    public ArrayList<otel> list(){
    this.otllist=new ArrayList();
    Connection con=ConnectionManager.getConnection();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from otel where sehirID in(select sehirID from sehir where sehirAdi='"+getShr().getSehirAdi()+"')");
        while(rs.next()){
        otel o=new otel();
        o.setOtelID(rs.getLong("otelID"));
        o.setOtelAdi(rs.getString("otelAdi"));
        o.setYildiz(rs.getLong("yildiz"));
        o.setOrtPuan(rs.getString("ortPuan"));
        o.setSehirID(rs.getLong("sehirID"));
        
        this.otllist.add(o);
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.otllist;
    }
      public ArrayList<kampanya> kampanyaGetir(Long id){
         ArrayList <kampanya> ka=new ArrayList();
        Connection con =ConnectionManager.getConnection();
        try{
            Statement st =con.createStatement();
           ResultSet rs=st.executeQuery("select * from kampanya where kamID in (select kamID from otelkampanya where otelID='"+id+"')");
           while(rs.next()) {
             kampanya k=new kampanya();
             k.setKamID(rs.getLong("kamID"));
             k.setKamAdi(rs.getString("kamAdi"));
             k.setKamBilgi(rs.getString("kamBilgi"));
             k.setKamBaslangic(rs.getString("kamBaslangic"));
             k.setKamBitis(rs.getString("kamBitis"));
             ka.add(k);
           }
           }catch(SQLException ex){
            System.out.println(ex.getMessage());
         }
        return ka;
       }
       public ArrayList<yorum> YorumGetir(Long id){
    ArrayList<yorum> ylist=new ArrayList<>();
    Connection con=ConnectionManager.getConnection();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from yorum where otelID="+id);
        while(rs.next()){
       yorum y=new yorum();
       y.setYorumID(rs.getLong("yorumID"));
       y.setKisiAdi(rs.getString("kisiAdi"));
       y.setKisiSoyadi(rs.getString("kisiSoyadi"));
       y.setKisiMail(rs.getString("kisiMail"));
       y.setOtelID(rs.getLong("otelID"));
       y.setYorumY(rs.getString("yorumY"));
        ylist.add(y);
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return ylist;
    }
     public ArrayList<sehir> sehirGetir(Long id){
    ArrayList<sehir> slist=new ArrayList<>();
    Connection con=ConnectionManager.getConnection();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from sehir where sehirID="+id);
        while(rs.next()){
       sehir s=new sehir();
       s.setSehirID(rs.getLong("sehirID"));
       s.setSehirAdi(rs.getString("sehirAdi"));
       s.setOtelSayisi(rs.getLong("otelSayisi"));
       s.setUlkeID(rs.getLong("ulkeID"));
       slist.add(s);
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return slist;
    }
    
     public ArrayList<oda> OdaGetir(Long id){
    ArrayList<oda> olist=new ArrayList<>();
    Connection con=ConnectionManager.getConnection();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from oda where otelID="+id);
        while(rs.next()){
       oda o=new oda();
       o.setOdaID(rs.getLong("odaID"));
       o.setOdaTuru(rs.getString("odaTuru"));
       o.setYatakSayisi(rs.getLong("yatakSayisi"));
       o.setOdaFiyat(rs.getLong("odaFiyat"));
       o.setOtelID(rs.getLong("odaID"));
        olist.add(o);
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return olist;
    }
                    

     public ArrayList<rezervasyon> RezervasyonGetir(Long ıd){
    ArrayList<rezervasyon> rezlist=new ArrayList<>();
    Connection con=ConnectionManager.getConnection();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from rezervasyon where rezID="+ıd);
        while(rs.next()){
            rezervasyon r=new rezervasyon();
            r.setRezID(rs.getLong("rezID"));
            r.setGidisTarihi(rs.getString("gidisTarihi"));
            r.setDonusTarihi(rs.getString("donusTarihi"));
            r.setOtelID(rs.getLong("otelID"));
            rezlist.add(r);
        }
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return rezlist;
    }
     
          public ArrayList<ozellikler> ozellikGetir(Long id){
         ArrayList <ozellikler> oz=new ArrayList();
        Connection con =ConnectionManager.getConnection();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from ozellikler where ozellikID in (select ozellikID from otelozellik where otelID='"+id+"')");
           while(rs.next()) {
               ozellikler o=new ozellikler();
        o.setOzellikID(rs.getLong("ozellikID"));
        o.setHavuz(rs.getString("kahvalti"));
        o.setHamamSPA(rs.getString("hamamSPA"));
        o.setOtopark(rs.getString("otopark"));
         oz.add(o);
           }
           }catch(SQLException ex){
            System.out.println(ex.getMessage());
         }
        return oz;
       }
     
 
    
    
   
}
