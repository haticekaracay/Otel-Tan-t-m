
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
import DAO.kampanyaDAO;
import DAO.otelDAO;
import Entity.kampanya;
import Entity.otel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;


@ManagedBean(name="kampanya")
@SessionScoped
public class kampanyaController {
    private kampanya kam=null;
    private ArrayList<kampanya> kamlist =null;
    private  kampanyaDAO kamDAO=null;
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

    public kampanya getKam(){
    if(this.kam==null)
        this.kam=new kampanya();
    return kam;
    }
    
    public void setKam(kampanya kam){
        this.kam=kam;
    }
   
    public ArrayList<kampanya> getlist(){
    if(this.kamlist==null){
        this.kamlist=new ArrayList();
        kamlist=this.getKamDAO().list();}
      return this.kamlist;
    }
    
    public void setlist(ArrayList<kampanya> list){
        this.kamlist=list;
    }
            
    public kampanyaDAO getKamDAO(){
    if(this.kamDAO==null)
        this.kamDAO=new kampanyaDAO();
     return kamDAO;
    }
    
    public void setKamDAO(kampanyaDAO kamDAO){
        this.kamDAO=kamDAO;
    }
    
      public kampanya getKamID(Long id){
       return this.getKamDAO().getKam(id);
    }
    
    public void delete(){
        this.getKamDAO().delete(this.kam);
        this.kamlist=this.getKamDAO().list();
        this.clearForm();
    }
    public void clearForm(){
      this.kam=new kampanya();
    }
    public void updateForm(kampanya k){
      this.kam=k;
    }
    
    public void update(){
       this.getKamDAO().update(this.kam);
       this.kamlist=this.getKamDAO().list();
       this.clearForm();
    }
    
    
    public void create(){
        this.getKamDAO().create(this.kam);
        this.kamlist=this.getKamDAO().list();
        this.kam=null;
        this.clearForm();
    }
       
}
