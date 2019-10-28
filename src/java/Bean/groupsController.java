/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.groupsDAO;
import Entity.groups;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author haticeozbakir
 */
@ManagedBean(name="groups")
@SessionScoped
public class groupsController {
    private groups gr =null;
    private ArrayList<groups> grlist =null;
    private  groupsDAO grDAO=null;
    
     public groups getGr() {
        if(this.gr==null)
            this.gr =new groups();
        return gr;
    }

    public void setGr(groups g) {
        this.gr= g;
    }

    public ArrayList<groups> getlist() {
        if(this.grlist==null){
            this.grlist=new ArrayList();
            grlist=this.getGrDAO().list();}
        return this.grlist;
    }

    public void setlist(ArrayList<groups> list) {
        this.grlist = list;
    }

    public groupsDAO  getGrDAO() {
        if(this.grDAO==null)
            this.grDAO = new groupsDAO();
        return grDAO;
    }

    public void setGrDAO(groupsDAO gDAO) {
        this.grDAO = gDAO;
    }
    public groups getGrID(Long id){
       return this.getGrDAO().getGroups(id);
    }
    public void delete() {
        this.getGrDAO().delete(this.gr);
        this.grlist = this.getGrDAO().list();
        this.clearForm();
    }
    public void clearForm(){
       this.gr=new groups();
    }
    public void updateForm(groups g){
       this.gr=g;
    }
    public void update(){
        this.getGrDAO().update(this.gr);
        this.grlist = this.getGrDAO().list();
        this.clearForm();
    }
    
    public void create() {
        this.getGrDAO().create(this.gr);
        this.grlist = this.getGrDAO().list();
        this.gr=null;
        this.clearForm();
    }
    
       public String GirisYetkili() {
        Connection con = ConnectionManager.getConnection();

        try {
            PreparedStatement st = con.prepareStatement("select kullaniciAdi,sifre from groups");
            ResultSet rs = st.executeQuery();
                
            while (rs.next()) {
                
                if (this.gr.getKullaniciAdi().equals(rs.getString("kullaniciAdi")) && this.gr.getSifre().equals(rs.getString("sifre"))) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_groups", this.gr);

                    return "/template/yetkili/yetindex?faces-redirect=true";
                } 
               // else {
                 //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("kullanıcı adı veya şifre hatalı"));
                   // return "/yetkili";

                //}
                //  if((this.gr.getKullaniciAdi() == null ? rs.getString("kullaniciAdi") != null : !this.gr.getKullaniciAdi().equals(rs.getString("kullaniciAdi"))) && (this.gr.getSifre() == null ? rs.getString("sifre") != null : !this.gr.getSifre().equals(rs.getString("sifre")))){
               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("kullanıcı adı veya şifre hatalı"));
               //     return "/otel?faces-redirect=true";}
              
            }
           
            
     

           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return "";
    }
   
    public String doLogout() {
        this.gr.setKullaniciAdi(null);
        this.gr.setSifre(null);
        return "/index?faces-redirect=true";
    }


    
}
