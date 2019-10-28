/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author haticeozbakir
 */
import DAO.odaDAO;
import DAO.otelDAO;
import Entity.oda;
import Entity.otel;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="oda")
@SessionScoped
public class odaController {
    private oda od=null;
    private ArrayList<oda> odalist=null;
    private odaDAO odaDAO=null;
     private otelDAO otlDao;
   
    private ArrayList<otel> olist=null;

    public ArrayList<otel> getOlist() {
        this.olist=this.getOtlDao().list();
        return olist;
    }

    public void setOlist(ArrayList<otel> olist) {
        this.olist = olist;
    }
     public otelDAO getOtlDao() {
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }

    public oda getOd(){
    if(this.od==null)
        this.od=new oda();
    return od;
    }
    
    public void setOd(oda o){
        this.od=o;
    }
   
    public ArrayList<oda> getlist(){
    if(this.odalist==null)
        this.odalist=new ArrayList();
        odalist=this.getOdaDAO().list();
      return this.odalist;
    }
    
    public void setlist(ArrayList<oda> list){
        this.odalist=list;
    }
            
    public odaDAO getOdaDAO(){
    if(this.odaDAO==null)
        this.odaDAO=new odaDAO();
     return odaDAO;
    }
    
    public void setOdaDAO(odaDAO odaDAO){
        this.odaDAO=odaDAO;
    }
   
      public oda getOdaID(Long id){
       return this.getOdaDAO().getOda(id);
    }
              
    public void delete(){
        this.getOdaDAO().delete(this.od);
        this.odalist=this.getOdaDAO().list();
        this.clearForm();
    }
    public void clearForm(){
      this.od=new oda();
    }
    public void updateForm(oda o){
      this.od=o;
    }
    public void update(){
       this.getOdaDAO().update(this.od);
       this.odalist=this.getOdaDAO().list();
       this.clearForm();
    }
    
    public void create(){
        this.getOdaDAO().create(this.od);
        this.odalist=this.getOdaDAO().list();
        this.od=null;
        this.clearForm();
    }
       
}