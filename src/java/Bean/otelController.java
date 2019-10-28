/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.kampanyaDAO;
import DAO.otelDAO;
import DAO.sehirDAO;
import Entity.kampanya;
import Entity.otel;
import Entity.ozellikler;
import Entity.sehir;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author haticeozbakir
 */
@ManagedBean(name="otel")
@SessionScoped
public class otelController {
 private otel otl=null;
    private ArrayList<otel> otllist=null;
    private otelDAO otlDAO=null;
    private sehirDAO shrDao;
    private kampanyaDAO kamDao=null;
    private ArrayList<sehir> slist=null;
    private ArrayList<kampanya>klist=null;
    private ArrayList<ozellikler>ozlist=null;

    public kampanyaDAO getKamDao() {
        if(this.kamDao==null)
            this.kamDao=new kampanyaDAO();
        return kamDao;
    }

    
    public ArrayList<kampanya> getKlist() {
       this.klist=this.getKamDao().list();
        return klist;
    }

    public void setKlist(ArrayList<kampanya> klist) {
        this.klist = klist;
    }

    public ArrayList<ozellikler> getOzlist() {
        return ozlist;
    }

    public void setOzlist(ArrayList<ozellikler> ozlist) {
        this.ozlist = ozlist;
    }
 
    
    public ArrayList<sehir> getSlist() {
        this.slist=this.getShrDao().list();
        return slist;
    }

    public void setSlist(ArrayList<sehir> slist) {
        this.slist = slist;
    }
    
    
    public otel getOtl() {
        if(this.otl==null)
            this.otl=new otel();
        return otl;
    }

    public void setOtl(otel otl) {
        this.otl = otl;
    }

    public ArrayList<otel> getlist() {
        if(this.otllist==null){
            this.otllist=new ArrayList();
            otllist=this.getOtelDAO().list();
        }
        return otllist;
    }

    public void setlist(ArrayList<otel> otllist) {
        this.otllist = otllist;
    }
   
    public otelDAO getOtelDAO(){
    if(this.otlDAO==null)
        this.otlDAO=new otelDAO();
     return otlDAO;
    }
    
    public void setOtelDAO(otelDAO otelDAO){
        this.otlDAO=otelDAO;
    }

    public sehirDAO getShrDao() {
        if(this.shrDao==null)
            this.shrDao=new sehirDAO();
        return shrDao;
    }
    
    
    public void delete(){
        this.getOtelDAO().delete(this.otl);
        this.otllist=this.getOtelDAO().list();
        this.clearForm();
    }
   public void clearForm(){
     this.otl=new otel();
   }
   public void updateForm(otel o){
     this.otl=o;
   }
    public void update(){
       this.getOtelDAO().update(this.otl);
       this.otllist=this.getOtelDAO().list();
       this.clearForm();
    }
    
    
    public void create(){
        this.getOtelDAO().create(this.otl);
        this.otllist=this.getOtelDAO().list();
        this.otl=null;
        this.clearForm();
    }
       
}