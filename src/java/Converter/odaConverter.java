/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.odaDAO;
import Entity.oda;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author haticeozbakir
 */
@FacesConverter(value="odaConverter")
public class odaConverter implements Converter {
     odaDAO odDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getOdaDAO().getOda(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
         oda od=(oda) o;
         return od.getOdaID().toString();
    }
    public odaDAO getOdaDAO(){
    if(this.odDao==null)
        this.odDao=new odaDAO();
    return odDao;
    }
}
