/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.sehirDAO;
import DAO.ulkeDAO;
import Entity.sehir;
import Entity.ulke;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author haticeozbakir
 */
@ManagedBean(name="sehir")
@SessionScoped
public class sehirController {
    private sehir shr=null;
    private ArrayList<sehir> sehirlist=null;
    private sehirDAO sehirDAO=null;
    private ulkeDAO ulkDao;
    private ArrayList<ulke> ulist=null;

    public ArrayList<ulke> getUlist() {
        this.ulist=this.getUlkDao().list();
        return ulist;
    }

    public void setUlist(ArrayList<ulke> ulist) {
        this.ulist = ulist;
    }
    
   
    public ulkeDAO getUlkDao() {
        if(this.ulkDao==null)
            this.ulkDao=new ulkeDAO();
        return ulkDao;
    }

    public sehir getShr() {
         if(this.shr==null)
         this.shr =new sehir();
         return shr;
    }

    public void setShr(sehir shr) {
        this.shr = shr;
    }
   
    public ArrayList<sehir> getlist(){
        if(this.sehirlist==null){
            this.sehirlist=new ArrayList();
            sehirlist=this.getSehirDAO().list();}
            return this.sehirlist;
    }

    
    public void setlist(ArrayList<sehir>list){
        this.sehirlist=list;
    }
    
    
    public sehirDAO getSehirDAO(){
        if(this.sehirDAO==null)
            this.sehirDAO=new sehirDAO();
            return sehirDAO;
    }
    
    
    public void setUlkeDAO(sehirDAO sehirDAO){
        this.sehirDAO=sehirDAO;
    }
    
    
    public sehir getSehirId(Long id){
        return this.getSehirDAO().getShr(id);
    }
    
    
    public void delete(){
        this.getSehirDAO().delete(this.shr);
        this.sehirlist=this.getSehirDAO().list();
        this.clearForm();
    }
    public void clearForm(){
      this.shr=new sehir();
    }
    public void updateForm(sehir s){
       this.shr=s;
    }
    public void update(){
        this.getSehirDAO().update(this.shr);
        this.sehirlist=this.getSehirDAO().list();
        this.clearForm();
    }
    
    
    public void create(){
        this.getSehirDAO().create(this.shr);
        this.sehirlist=this.getSehirDAO().list();
        this.shr=null;
        this.clearForm();
    }
}
