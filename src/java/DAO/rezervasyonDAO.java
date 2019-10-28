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
import Entity.oda;
import Entity.otel;
import Entity.rezervasyon;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class rezervasyonDAO {
  private rezervasyon rez=null;
    private ArrayList<rezervasyon> rezlist=null;
    private otelDAO otlDao;

    public otelDAO getOtlDao() {
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }
    
    
    public rezervasyon getRez(Long id){

        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement st =con.prepareStatement("select *from rezervasyon where rezID=?");
           st.setLong(1, id);
            ResultSet rs =st.executeQuery();
            rs.next();
            this.rez =new rezervasyon(rs.getLong("rezID"),rs.getString("gidisTarihi"),rs.getString("donusTarihi"),rs.getLong("otelID"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.rez;
    }
     public ArrayList<rezervasyon> list(){
         this.rezlist=new ArrayList();
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst=con.prepareStatement("select *from rezervasyon order by rezID desc");
            ResultSet rs=pst.executeQuery();
         
           while(rs.next()){
              
            rezervasyon rez=new rezervasyon();
            rez.setRezID(rs.getLong("rezID"));
            rez.setGidisTarihi(rs.getString("gidisTarihi"));
            rez.setDonusTarihi(rs.getString("donusTarihi"));
            rez.setOtl(this.getOtlDao().getOtl(rs.getLong("otelID")));
           
            rezlist.add(rez);
        }
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.rezlist;
    }
    
       public void delete(rezervasyon rez){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst =con.prepareStatement("delete from rezervasyon where rezID=?");
            pst.setLong(1,rez.getRezID() );
            pst.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(rezervasyon r){
        Connection con =ConnectionManager.getConnection();
        try{
           String update="update rezervasyon set gidisTarihi=?,donusTarihi=?,otelID=? where rezID=? ";
           PreparedStatement ps=con.prepareStatement(update);
           ps.setString(1, r.getGidisTarihi());
           ps.setString(2, r.getDonusTarihi());
           ps.setLong(3, r.getOtl().getOtelID());
           ps.setLong(4, r.getRezID());
            ps.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
    public void create(rezervasyon rez) {
       Connection con =ConnectionManager.getConnection();
        try{
           PreparedStatement pst=con.prepareStatement("insert into rezervasyon(gidisTarihi,donusTarihi,otelID) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
           pst.setString(1, rez.getGidisTarihi());
           pst.setString(2, rez.getDonusTarihi());
           pst.setLong(3, rez.getOtl().getOtelID());
           pst.executeUpdate();
           Long rezID=null;
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
             rezID=gk.getLong(1);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
    }

}