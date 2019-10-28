/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import DAO.usersDAO;
import Entity.users;
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
@ManagedBean(name="users")
@SessionScoped

public class usersController {
    private users us =null;
    private ArrayList<users> uslist =null;
    private  usersDAO usDAO=null;

    public users getUs() {
        if(this.us==null)
            this.us =new users();
        return us;
    }

    public void setUs(users us) {
        this.us= us;
    }

    public ArrayList<users> getlist() {
        if(this.uslist==null){
            this.uslist=new ArrayList();
            uslist=this.getUsDAO().list();
                    }
        return this.uslist;
    }

    public void setlist(ArrayList<users> list) {
        this.uslist = list;
    }

    public usersDAO getUsDAO() {
        if(this.usDAO==null)
            this.usDAO = new usersDAO();
        return usDAO;
    }

    public void setUsDAO(usersDAO usDAO) {
        this.usDAO = usDAO;
    }
    public users getUserID(Long id){
       return this.getUsDAO().getUsers(id);
    }
    public void delete() {
        this.getUsDAO().delete(this.us);
        this.uslist = this.getUsDAO().list();
        this.clearForm();
    }
    public void clearForm(){
      this.us=new users();
    }
    public void updateForm(users u){
        this.us=u;
    }
    public void update(){
        this.getUsDAO().update(this.us);
        this.uslist=this.getUsDAO().list();
        this.clearForm();
    }
    
    public void create() {
        this.getUsDAO().create(this.us);
        this.uslist = this.getUsDAO().list();
        this.us=null;
        this.clearForm();
    }
    public String Giris(){
          Connection con =ConnectionManager.getConnection();
        
        
          try{
            PreparedStatement st =con.prepareStatement("select kullaniciAdi,sifre from users");
            ResultSet rs =st.executeQuery();
            
           while(rs.next()) {
               
                if(this.us.getKullaniciAdi().equals(rs.getString("kullaniciAdi"))&&this.us.getSifre().equals(rs.getString("sifre"))){
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user",this.us);
          return "/template/admin/indexx?faces-redirect=true";
    }
                 else{
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("kullanıcı adı veya parola hatalı.."));
        return "/register";

    }
                  
           }
            
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
             
        }
    return "";
    }  
        
    
  
     public String doLogout() {
        this.us.setKullaniciAdi(null); 
        this.us.setSifre(null);
     
        return "/index?faces-redirect=true";
    }
    
    
}
