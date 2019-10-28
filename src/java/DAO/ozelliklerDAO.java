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
import Entity.ozellikler;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ozelliklerDAO {
  private ozellikler ozl=null;
    private ArrayList<ozellikler> ozlist=null;
    private otelDAO otlDao;

    public otelDAO getOtlDao() {
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }
    
  
        public ozellikler getOZ(Long id){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement st=con.prepareStatement("select *from ozellikler where ozellikID=?");
            st.setLong(1, id);
            ResultSet rs=st.executeQuery();
            rs.next();
            this.ozl=new ozellikler(rs.getLong("ozellikID"),rs.getString("havuz"),
                    rs.getString("kahvalti"),rs.getString("hamamSPA"),
                    rs.getString("otopark"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.ozl;
    }
 
    public ArrayList<ozellikler> list(){
         this.ozlist=new ArrayList();
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst=con.prepareStatement("select *from ozellikler order by ozellikID desc");
             ResultSet rs=pst.executeQuery();
           while(rs.next()) {
               ozellikler o=new ozellikler();
               o.setOzellikID(rs.getLong("ozellikID"));
               o.setOtopark(rs.getString("otopark"));
               o.setKahvalti(rs.getString("kahvalti"));
               o.setHamamSPA(rs.getString("hamamSPA"));
               o.setHavuz(rs.getString("havuz"));
               o.setOtelozellik(this.getOtlDao().getOtelOzellik(o.getOzellikID()));
              
               ozlist.add(o);
          }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.ozlist;
    }
 
    
       public void delete(ozellikler o){
        Connection con =ConnectionManager.getConnection();
        try{
           PreparedStatement pst=con.prepareStatement("delete from otelozellik where ozellikID=?");
           pst.setLong(1, o.getOzellikID());
           pst.executeUpdate();
            
            pst =con.prepareStatement("delete from ozellikler where ozellikID=?");
            pst.setLong(1, o.getOzellikID());
            pst.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
  
    public void update(ozellikler o) {
           Connection con =ConnectionManager.getConnection();
        try{
          String update="update ozellikler set havuz=?,kahvalti=?,hamamSPA=?,otopark=? where ozellikID=? ";
          PreparedStatement ps=con.prepareStatement(update);
          ps.setString(1, o.getHavuz());
          ps.setString(2, o.getKahvalti());
          ps.setString(3, o.getHamamSPA());
          ps.setString(4, o.getOtopark());
          ps.setLong(5, o.getOzellikID());
          ps.executeUpdate();
           ps=con.prepareStatement("delete from otelozellik where ozellikID=?");
           ps.setLong(1, o.getOzellikID());
           ps.executeUpdate();
          
           for(otel ot:o.getOtelozellik() ){
            ps=con.prepareStatement("insert into otelozellik (otelID,ozellikID) values(?,?)");
            ps.setLong(1, ot.getOtelID());
            ps.setLong(2, o.getOzellikID());
            ps.executeUpdate();
          }
          
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        } 
    }
    public void create(ozellikler o) {
          Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst=con.prepareStatement("insert into ozellikler(havuz,kahvalti,hamamSPA,otopark) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, o.getHavuz());
            pst.setString(2, o.getKahvalti());
            pst.setString(3, o.getHamamSPA());
            pst.setString(4, o.getOtopark());
            
            pst.executeUpdate();
             Long ozellikID=null;
             ResultSet gk=pst.getGeneratedKeys();
             if(gk.next()){
               ozellikID=gk.getLong(1);
             }
            for(otel ot:o.getOtelozellik() ){
                pst=con.prepareStatement("insert into otelozellik(otelID,ozellikID)values (?,?)");
                pst.setLong(1, ot.getOtelID());
                pst.setLong(2, ozellikID);
                pst.executeUpdate();
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
    }

       private ozellikler find(Long id) {
           Connection con=ConnectionManager.getConnection();
           ozellikler o=null;
           try{
            PreparedStatement st=con.prepareStatement("select *from ozellikler where ozellikID=?");
             st.setLong(1, id);
            ResultSet rs=st.executeQuery();
            rs.next();
            
            o=new ozellikler();
            o.setOzellikID(rs.getLong("ozellikID"));
            o.setHavuz(rs.getString("havuz"));
            o.setKahvalti(rs.getString("kahvalti"));
            o.setHamamSPA(rs.getString("hamamSPA"));
            o.setOtopark(rs.getString("otopark"));
        
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return o;
      }

    ArrayList<ozellikler> getOtelOzellik(Long otelID) {
 ArrayList<ozellikler> otelOzellik=new ArrayList<>();
         Connection con=ConnectionManager.getConnection();
          try{
        PreparedStatement st=con.prepareStatement("select *from otelozellik where otelID=?");
        st.setLong(1, otelID);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
           otelOzellik.add(this.find(rs.getLong("ozellikID")));
           
        } 
       
       }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
       return otelOzellik;
    }

 
 
}
