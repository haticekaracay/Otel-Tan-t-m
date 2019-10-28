/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author haticeozbakir
 */
@ManagedBean(name="navigationBean")
@RequestScoped

public class NavigationBean implements Serializable {
    public String page(String p){
       return "/pages/"+p+"?faces-redirect=true";
    }
    
}
