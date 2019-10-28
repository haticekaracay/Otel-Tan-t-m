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
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class odaDAO {
    private oda od=null;
    private ArrayList<oda> odalist=null;
      private otelDAO otlDao;

    public otelDAO getOtlDao() {
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }
      

    
    public oda getOda(Long id){
        Connection con=ConnectionManager.getConnection();
    try{
        PreparedStatement st=con.prepareStatement("select *from oda where odaID=?");
        st.setLong(1, id);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
            this.od=new oda(rs.getLong("odaID"),rs.getString("odaTuru"),rs.getLong("yatakSayisi"),rs.getLong("odaFiyat"),rs.getLong("otelID"));
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.od;
    }
    
    
    public ArrayList<oda> list(){
        this.odalist=new ArrayList();
        Connection con=ConnectionManager.getConnection();
    try{
        PreparedStatement pst=con.prepareStatement("select *from oda order by odaID desc");
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            oda o=new oda();
            
            o.setOtl(this.getOtlDao().getOtl(rs.getLong("otelID")));
            o.setOdaID(rs.getLong("odaID"));
            o.setOdaTuru(rs.getString("odaTuru"));
            o.setYatakSayisi(rs.getLong("yatakSayisi"));
            o.setOdaFiyat(rs.getLong("odaFiyat"));
            
            odalist.add(o);
        }
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.odalist;
    }
     
     
    public void delete(oda o){
    Connection con=ConnectionManager.getConnection();
    try{
        PreparedStatement pst=con.prepareStatement("delete from oda where odaID=?");
        pst.setLong(1, o.getOdaID());
        pst.executeUpdate();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void update(oda o){
    Connection con=ConnectionManager.getConnection();
    try{
        Statement st=con.createStatement();
        //st.executeUpdate("update oda set odaFiyat='"+o.getOdaFiyat()+"' where odaTuru='"+o.getOdaTuru()+"'");
       String update="update oda set odaTuru=?,yatakSayisi=?,odaFiyat=?,otelID=? where odaID=?";
       PreparedStatement ps=con.prepareStatement(update);
       ps.setString(1,o.getOdaTuru());
       ps.setLong(2, o.getYatakSayisi());
       ps.setLong(3,o.getOdaFiyat());
       ps.setLong(4, o.getOtelID());
       ps.setLong(5,o.getOdaID());
       ps.executeUpdate();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    public void create(oda od) {
       Connection con=ConnectionManager.getConnection();
    try{
        PreparedStatement pst=con.prepareStatement("insert into oda(odaTuru,yatakSayisi,odaFiyat,otelID) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, od.getOdaTuru());
        pst.setLong(2, od.getYatakSayisi());
        pst.setLong(3, od.getOdaFiyat());
        pst.setLong(4, od.getOtl().getOtelID());
        pst.executeUpdate();
            Long odaID=null;
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
             odaID=gk.getLong(1);
            }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }

}