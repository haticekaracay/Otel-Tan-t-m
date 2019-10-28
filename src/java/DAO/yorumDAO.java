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
import Entity.yorum;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class yorumDAO {
  private yorum yrm=null;
    private ArrayList<yorum> yorumlist=null;
    private otelDAO otlDao;

    public otelDAO getOtlDao() {
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }
    
    
    public yorum getYorum(Long id){

        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement st =con.prepareStatement("select *from where yorumID=?");
            st.setLong(1, id);
            ResultSet rs =st.executeQuery();
            rs.next();
            this.yrm =new yorum(rs.getLong("yorumID"),rs.getString("kisiAdi"),rs.getString("kisiSoyadi"),rs.getString("kisiMail"),rs.getLong("otelID"),rs.getString("yorum"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.yrm;
    }
     public ArrayList<yorum> list(){
         this.yorumlist=new ArrayList();
        Connection con =ConnectionManager.getConnection();
        try{
        PreparedStatement pst=con.prepareStatement("select * from yorum order by yorumID desc");
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
        yorum y=new yorum();
        y.setYorumID(rs.getLong("yorumID"));
        y.setKisiAdi(rs.getString("kisiAdi"));
        y.setKisiSoyadi(rs.getString("kisiSoyadi"));
        y.setKisiMail(rs.getString("kisiMail"));
        
        y.setYorumY(rs.getString("yorumY"));
        y.setOtl(this.getOtlDao().getOtl(rs.getLong("otelID")));
        yorumlist.add(y);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.yorumlist;
    }
     
       public void delete(yorum y){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst =con.prepareStatement("delete from yorum where yorumID=?");
            pst.setLong(1, y.getYorumID());
            pst.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
          public void update(yorum yrm) {
             Connection con =ConnectionManager.getConnection();
        try{
           String update="update yorum set kisiAdi=?,kisiSoyadi=?,kisiMail=?,otelID=?,yorumY=? where yorumID=? ";
        PreparedStatement ps=con.prepareStatement(update);
        ps.setString(1, yrm.getKisiAdi());
        ps.setString(2, yrm.getKisiSoyadi());
        ps.setString(3, yrm.getKisiMail());
        ps.setLong(4, yrm.getOtl().getOtelID());
        ps.setString(5, yrm.getYorumY());
        ps.setLong(6,yrm.getYorumID());
        
        ps.executeUpdate();
       
        
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
          }

    public void create(yorum yrm) {
         Connection con =ConnectionManager.getConnection();
          try{
            PreparedStatement pst=con.prepareStatement("insert into yorum(kisiAdi,kisiSoyadi,kisiMail,otelID,yorumY)values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
             
            pst.setString(1, yrm.getKisiAdi());
            pst.setString(2, yrm.getKisiSoyadi());
            pst.setString(3, yrm.getKisiMail());
            pst.setLong(4, yrm.getOtl().getOtelID());
            pst.setString(5, yrm.getYorumY());
            pst.executeUpdate();
            Long yorumID=null;
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
             yorumID=gk.getLong(1);
            }
            
          }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
    }

  

 
}
