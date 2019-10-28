
package DAO;


import Entity.dosya;
import Entity.groups;
import Entity.otel;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class dosyaDAO {
    private dosya dsy=null;
    private otelDAO otlDao;
    
    public otelDAO getOtlDao() {
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }
    public List<dosya> findAll(){
      List<dosya> dList=new ArrayList<>();
      Connection con=ConnectionManager.getConnection();
      try{
          PreparedStatement pst=con.prepareStatement("select*from dosya");
          ResultSet rs=pst.executeQuery();
          while(rs.next()){
              dosya d=new dosya();
              d.setDosyaID(rs.getLong("dosyaID"));
              d.setDosyaYolu(rs.getString("dosyaYolu"));
              d.setDosyaAdi(rs.getString("dosyaAdi")); 
              d.setDosyaTipi(rs.getString("dosyaTipi"));
              d.setOtl(this.getOtlDao().getOtl(rs.getLong("otelID")));
              
              dList.add(d);
          }
      }catch(SQLException e){
          System.out.println(e.getMessage());
      }
      return dList;
    
    }
    public void create(dosya d) {
          Connection con=ConnectionManager.getConnection();
         try{
          PreparedStatement pst=con.prepareStatement("insert into dosya(dosyaYolu,dosyaAdi,dosyaTipi,otelID) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
          pst.setString(1, d.getDosyaYolu());
          pst.setString(2, d.getDosyaAdi());
          pst.setString(3, d.getDosyaTipi());
          pst.setLong(4, d.getOtl().getOtelID());
          pst.executeUpdate();
          Long dosyaID=null;
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
             dosyaID=gk.getLong(1);
            }
      
      }catch(SQLException e){
          System.out.println(e.getMessage());
      }
        
    }


}
    
    