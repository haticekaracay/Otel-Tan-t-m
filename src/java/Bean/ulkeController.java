/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.ulkeDAO;
import Entity.ulke;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author haticeozbakir
 */
@ManagedBean(name="ulke")
@SessionScoped
public class ulkeController {
     private ulke ul=null;
    private ArrayList<ulke> ullist=null;
    private ulkeDAO ulDAO=null;

    public ulke getUl() {
        if(this.ul==null)
            this.ul =new ulke();
        return ul;
    }

    public void setUl(ulke ul) {
        this.ul = ul;
    }

    public ArrayList<ulke> getlist() {
        if(this.ullist==null){
            this.ullist=new ArrayList();
            ullist=this.getUlDAO().list();
                    }
        return ullist;
    }

    public void setlist(ArrayList<ulke> ullist) {
        this.ullist = ullist;
    }
    
    
       public ulkeDAO getUlDAO(){
        if(this.ulDAO==null)
            this.ulDAO=new ulkeDAO();
            return ulDAO;
    }
    public void setUlDAO(ulkeDAO ulkeDAO){
       this.ulDAO=ulkeDAO;
    }
    public ulke getUlkeID(Long id){
       return this.getUlDAO().getUlke(id);
    }
  
    
    
    public void delete(){
        this.getUlDAO().delete(this.ul);
        this.ullist=this.getUlDAO().list();
        this.clearForm();
    }
    public void clearForm(){
     this.ul=new ulke();
    }
    public void updateForm(ulke u){
      this.ul=u;
    }
    public void update(){
        this.getUlDAO().update(this.ul);
        this.ullist=this.getUlDAO().list();
        this.clearForm();
    }
    
    
    public void create(){
        this.getUlDAO().create(this.ul);
        this.ullist=this.getUlDAO().list();
        this.ul=null;
        this.clearForm();
    }
}
