/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.sehirDAO;
import Entity.sehir;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author haticeozbakir
 */
@FacesConverter(value="sehirConverter")
public class sehirConverter implements Converter{
    sehirDAO sehDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getSehirDAO().getShr(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
        sehir s=(sehir) o;
        return s.getSehirID().toString();
    }
    public sehirDAO getSehirDAO(){
    if(this.sehDao==null)
        this.sehDao=new sehirDAO();
      return sehDao;
    }
    
}
