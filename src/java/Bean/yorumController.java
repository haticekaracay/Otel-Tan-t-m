/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import DAO.otelDAO;
import DAO.yorumDAO;
import Entity.otel;
import Entity.yorum;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author haticeozbakir
 * @page
 * @pageSize
 * @pageCount
 */
@ManagedBean(name="yorum")
@SessionScoped

public class yorumController {
    private yorum yrm =null;
    private ArrayList<yorum> ylist =null;
    private  yorumDAO yDAO=null;
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

    public yorum getYrm() {
        if(this.yrm==null)
            this.yrm =new yorum();
        return yrm;
    }

    public void setYrm(yorum yrm) {
        this.yrm = yrm;
    }
  
    public ArrayList<yorum> getlist() {
        if(this.ylist==null){
            this.ylist=new ArrayList();
            ylist=this.getyDAO().list();
        }
        return this.ylist;
    }

    public void setlist(ArrayList<yorum> list) {
        this.ylist = list;
    }

    public yorumDAO getyDAO() {
        if(this.yDAO==null)
            this.yDAO = new yorumDAO();
        return yDAO;
    }

    public void setyDAO(yorumDAO yDAO) {
        this.yDAO = yDAO;
    }
      public yorum getYrmID(Long id){
       return this.getyDAO().getYorum(id);
    }
    
    public void delete() {
        this.getyDAO().delete(this.yrm);
        this.ylist = this.getyDAO().list();
        this.clearForm();
    }
    public void clearForm(){
      this.yrm=new yorum();
    }
    public void updateForm(yorum y){
       this.yrm=y;
    }
    public void update(){
        this.getyDAO().update(this.yrm);
        this.ylist = this.getyDAO().list();
        this.clearForm();
    }
    
    public void create() {
        this.getyDAO().create(this.yrm);
        this.ylist = this.getyDAO().list();
        this.yrm=null;
        this.clearForm();
    }
    
    
    
}
