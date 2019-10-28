/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.otelDAO;
import DAO.rezervasyonDAO;
import Entity.otel;
import Entity.rezervasyon;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author haticeozbakir
 */
@ManagedBean(name="rezervasyon")
@SessionScoped
public class rezervasyonController {
    private rezervasyon rez =null;
    private ArrayList<rezervasyon> rlist =null;
    private  rezervasyonDAO rDAO=null;
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
     public rezervasyon getRez() {
        if(this.rez==null)
            this.rez =new rezervasyon();
        return rez;
    }

    public void setRez(rezervasyon r) {
        this.rez= r;
    }

    public ArrayList<rezervasyon> getlist() {
        if(this.rlist==null){
            this.rlist=new ArrayList();
            rlist=this.getRDAO().list();
                    }
        return this.rlist;
    }

    public void setlist(ArrayList<rezervasyon> list) {
        this.rlist = list;
    }

    public rezervasyonDAO  getRDAO() {
        if(this.rDAO==null)
            this.rDAO = new rezervasyonDAO();
        return rDAO;
    }

    public void setrDAO(rezervasyonDAO rDAO) {
        this.rDAO = rDAO;
    }
    public void delete() {
        this.getRDAO().delete(this.rez);
        this.rlist = this.getRDAO().list();
        this.clearForm();
    }
    public void clearForm(){
       this.rez=new rezervasyon();
    }
    public void updateForm(rezervasyon r){
      this.rez=r;
    }
    public void update(){
        this.getRDAO().update(this.rez);
        this.rlist = this.getRDAO().list();
        this.clearForm();
    }
    
    public void create() {
        this.getRDAO().create(this.rez);
        this.rlist = this.getRDAO().list();
        this.rez=null;
        this.clearForm();
    }
    
    

    
}
