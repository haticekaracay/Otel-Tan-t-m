/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.yorumDAO;
import Entity.yorum;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author haticeozbakir
 */
@FacesConverter(value="yorumConverter")
public class yorumConverter implements Converter {
   yorumDAO yrmDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getYorumDAO().getYorum(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
        yorum y=(yorum)o;
        return y.getYorumID().toString();
    }
    public yorumDAO getYorumDAO(){
       if(this.yrmDao==null)
           this.yrmDao=new yorumDAO();
       return yrmDao;
    }
}
