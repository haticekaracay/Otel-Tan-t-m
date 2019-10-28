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
import Entity.otel;
import Entity.sehir;
import Entity.ulke;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class sehirDAO {
    private sehir shr=null;
    private ArrayList<sehir> shrlist=null;
    private otelDAO otlDAO;
    private ulkeDAO ulkDao;

    public ulkeDAO getUlkDao() {
        if(this.ulkDao==null)
            this.ulkDao=new ulkeDAO();
        return ulkDao;
    }
    
    
     public otelDAO getOtlDAO() {
        if(this.otlDAO==null){
            this.otlDAO=new otelDAO();
        }
        return otlDAO;
    }

    public sehir getShr(Long id){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement st =con.prepareStatement("select *from sehir where sehirID=?");
             st.setLong(1, id);
             ResultSet rs=st.executeQuery();
            rs.next();
            this.shr =new sehir(rs.getLong("sehirID"),rs.getString("sehirAdi"),rs.getLong("otelSayisi"),rs.getLong("ulkeID"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return this.shr;
    }
    
   
    public ArrayList<sehir> list(){
         this.shrlist=new ArrayList();
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst=con.prepareStatement("select *from sehir order by sehirID desc ");
            ResultSet rs =pst.executeQuery();
           while(rs.next()) {
               sehir s=new sehir();
              
               s.setSehirID(rs.getLong("sehirID"));
               s.setSehirAdi(rs.getString("sehirAdi"));
               s.setOtelSayisi(rs.getLong("otelSayisi"));
               s.setUlk(this.getUlkDao().getUlke(rs.getLong("ulkeID")));
               
             
               shrlist.add(s);     
           }
         }catch(SQLException ex){
            System.out.println(ex.getMessage());
         }
        return this.shrlist;
    }
     
    public void delete(sehir s){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst =con.prepareStatement("delete from sehir where sehirID=?");
            pst.setLong(1, s.getSehirID());
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
    
    public void update(sehir s){
        Connection con =ConnectionManager.getConnection();
        try{
           String update="update sehir set sehirAdi=?,otelSayisi=?,ulkeID=? where sehirID=? ";
           PreparedStatement ps=con.prepareStatement(update);
            ps.setString(1, s.getSehirAdi());
            ps.setLong(2, s.getOtelSayisi());
            ps.setLong(3, s.getUlk().getUlkeID());
            ps.setLong(4, s.getSehirID());
            
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        }

    public void create(sehir shr) {
         Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst=con.prepareStatement("insert into sehir(sehirID,sehirAdi,otelSayisi,ulkeID) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, shr.getSehirID());
            pst.setString(2, shr.getSehirAdi());
            pst.setLong(3, shr.getOtelSayisi());
            pst.setLong(4, shr.getUlk().getUlkeID());
            pst.executeUpdate();
             Long sehirID=null;
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
             sehirID=gk.getLong(1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
