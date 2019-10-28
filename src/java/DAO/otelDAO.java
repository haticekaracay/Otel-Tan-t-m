/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author haticeozbakir
 */
import Entity.kampanya;
import Entity.oda;
import Entity.otel;
import Entity.ozellikler;
import Entity.rezervasyon;
import Entity.sehir;
import Entity.yorum;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
 
public class otelDAO {
    private otel otl=null;
    private ArrayList<otel> otllist=null;
    private kampanyaDAO kamDAO;
    private odaDAO odaDAO;
    private rezervasyonDAO rezervasyonDAO;
    private ozelliklerDAO ozelliklerDAO;
    private sehirDAO shrDao;

    public sehirDAO getShrDao() {
        if(this.shrDao==null)
            this.shrDao=new sehirDAO();
        return shrDao;
    }
    
  
    public kampanyaDAO getKamDAO() {
        if(this.kamDAO==null)
            this.kamDAO=new kampanyaDAO();
        return kamDAO;
    }

    public ozelliklerDAO getozelliklerDAO() {
        if(this.ozelliklerDAO==null)
                this.ozelliklerDAO=new ozelliklerDAO();
       return ozelliklerDAO;
    }
    public odaDAO getOdaDAO() {
        if(this.odaDAO==null)
        this.odaDAO=new odaDAO();
        return odaDAO;
    }

    public rezervasyonDAO getRezervasyonDAO() {
        if(this.rezervasyonDAO==null)
            this.rezervasyonDAO=new rezervasyonDAO();
        return rezervasyonDAO;
    }
    public otel getOtl(Long id) {
        Connection con=ConnectionManager.getConnection();
        try{
            PreparedStatement st=con.prepareStatement("select *from otel where otelID=?");
            st.setLong(1, id);
            ResultSet rs=st.executeQuery();
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
        PreparedStatement pst=con.prepareStatement("select *from otel order by otelID desc ");
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
        otel o=new otel();
        o.setOtelID(rs.getLong("otelID"));
        o.setOtelAdi(rs.getString("otelAdi"));
        o.setYildiz(rs.getLong("yildiz"));
        o.setOrtPuan(rs.getString("ortPuan"));
        o.setShr(this.getShrDao().getShr(rs.getLong("sehirID")));
        o.setOtelkampanya(this.getKamDAO().getOtelKampanya(o.getOtelID()));
        o.setOtelozellik(this.getozelliklerDAO().getOtelOzellik(o.getOtelID()));
        //o.setKam(this.getKamDAO().getKam(rs.getLong("otelID")));
        //o.setOzellik(this.getozelliklerDAO().getOZ(rs.getLong("otelID")));
       // o.setOd(this.getOdaDAO().getOda(rs.getLong("odaID")));
        this.otllist.add(o);
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.otllist;
    }
      public ArrayList<otel> getOtelOzellik(Long ozellikID) {
       ArrayList<otel> otelOzellik=new ArrayList<>();
        Connection con=ConnectionManager.getConnection();

       try{
        PreparedStatement st=con.prepareStatement("select *from otelozellik where ozellikID=?");
        st.setLong(1, ozellikID);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
           otelOzellik.add(this.find(rs.getLong("otelID")));
           
        } 
       
       }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
       return otelOzellik;
    }
      
    ArrayList<otel> getOtelKampanya(Long kamID) {
        ArrayList<otel> otelKampanya=new ArrayList<>();
        Connection con=ConnectionManager.getConnection();
        
        try{
            PreparedStatement st=con.prepareStatement("select *from otelkampanya where kamID=?");
            st.setLong(1, kamID);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
             otelKampanya.add(this.find(rs.getLong("otelID")));
            }
         }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return otelKampanya;
    }
      public otel find(Long id){
            Connection con=ConnectionManager.getConnection();
          otel o=null;
        try{
            PreparedStatement st=con.prepareStatement("select *from otel where otelID=?");
             st.setLong(1, id);
            ResultSet rs=st.executeQuery();
            rs.next();
            
            o=new otel();
            o.setOtelID(rs.getLong("otelID"));
            o.setOtelAdi(rs.getString("otelAdi"));
            o.setYildiz(rs.getLong("yildiz"));
            o.setOrtPuan(rs.getString("ortPuan"));
            o.setSehirID(rs.getLong("sehirID"));
        
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return o;
      }
     
    public void delete(otel o){
    Connection con=ConnectionManager.getConnection();
    try{
        PreparedStatement st=con.prepareStatement("delete from otelozellik where otelID=?");
        st.setLong(1, o.getOtelID());
        st.executeUpdate();
        st=con.prepareStatement("delete from otelkampanya where otelID=? ");
        st.setLong(1, o.getOtelID());
        st.executeUpdate();
        st=con.prepareStatement("delete from otel where otelID=?");
        st.setLong(1, o.getOtelID());
        st.executeUpdate();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void update(otel o){
    Connection con=ConnectionManager.getConnection();
    try{
       String update="update otel set otelAdi=?,yildiz=?,ortPuan=?,sehirID=? where otelID=? ";
       PreparedStatement ps=con.prepareStatement(update);
       ps.setString(1, o.getOtelAdi());
       ps.setLong(2, o.getYildiz());
       ps.setString(3, o.getOrtPuan());
       ps.setLong(4, o.getSehirID());
       ps.setLong(5, o.getOtelID());
       ps.executeUpdate();
       ps=con.prepareStatement("delete from otelozellik where otelID=?");
       ps.setLong(1, o.getOtelID());
       ps.executeUpdate();
       ps=con.prepareStatement("delete from otelkampanya where otelID=? ");
       ps.setLong(1, o.getOtelID());
       ps.executeUpdate();
        for(ozellikler oz:o.getOtelozellik() ){
            ps=con.prepareStatement("insert into otelozellik (otelID,ozellikID) values(?,?)");
            ps.setLong(1, oz.getOzellikID());
            ps.setLong(2, o.getOtelID());
            ps.executeUpdate();
          }
          for(kampanya k:o.getOtelkampanya()){
            ps=con.prepareStatement("insert into otelkampanya (otelID,kamID) values(?,?)");
            ps.setLong(1, k.getKamID());
            ps.setLong(2, o.getOtelID());
            ps.executeUpdate();
          }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    public void create(otel otl) {
      Connection con=ConnectionManager.getConnection();
    try{
        PreparedStatement pst=con.prepareStatement("insert into otel(otelAdi,yildiz,ortPuan,sehirID) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, otl.getOtelAdi());
        pst.setLong(2, otl.getYildiz());
        pst.setString(3, otl.getOrtPuan());
        pst.setLong(4, otl.getShr().getSehirID());
        pst.executeUpdate();
        
        Long otelID=null;
             ResultSet gk=pst.getGeneratedKeys();
             if(gk.next()){
               otelID=gk.getLong(1);
             }
             
          for(kampanya k:otl.getOtelkampanya()){
            pst=con.prepareStatement("insert into otelkampanya (otelID,kamID) values(?,?)");
            pst.setLong(1, otelID);
            pst.setLong(2, k.getKamID());
            pst.executeUpdate();
          }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }


 

}
