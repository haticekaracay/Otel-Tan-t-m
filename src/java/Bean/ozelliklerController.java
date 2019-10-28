/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.otelDAO;
import DAO.ozelliklerDAO;
import Entity.otel;
import Entity.ozellikler;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author haticeozbakir
 */
@ManagedBean(name="ozellikler")
@SessionScoped
public class ozelliklerController {
    private ozellikler o =null;
    private ArrayList<ozellikler> olist =null;
    private  ozelliklerDAO oDAO=null;
    private otelDAO otlDao;
    private ArrayList<otel> otlist=null;

    public ArrayList<otel> getOtlist() {
        this.otlist=this.getOtlDao().list();
        return otlist;
    }

    public void setOtlist(ArrayList<otel> olist) {
        this.otlist = olist;
    }
    public ozellikler getO() {
        if(this.o==null)
            this.o =new ozellikler();
        return o;
    }

    public void setO(ozellikler o) {
        this.o= o;
    }

    public ArrayList<ozellikler> getlist() {
        if(this.olist==null){
            this.olist=new ArrayList();
            olist=this.getODAO().list();
                    }
        return this.olist;
    }

    public void setlist(ArrayList<ozellikler> list) {
        this.olist = list;
    }

    public ozelliklerDAO  getODAO() {
        if(this.oDAO==null)
            this.oDAO = new ozelliklerDAO();
        return oDAO;
    }

    public void setoDAO(ozelliklerDAO oDAO) {
        this.oDAO = oDAO;
    }
    public void delete() {
        this.getODAO().delete(this.o);
        this.olist = this.getODAO().list();
        this.clearForm();
       
    }  
    public void clearForm(){
        this.o=new ozellikler();
    }
 public void updateForm(ozellikler o){
       this.o=o;
    }
    public void update(){
        this.getODAO().update(this.o);
        this.olist = this.getODAO().list();
        this.clearForm();
    }
    
    public void create() {
        this.getODAO().create(this.o);
        this.olist = this.getODAO().list();
        this.o=null;
        this.clearForm();
    }
    
    public otelDAO getOtlDao() {
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }
}
