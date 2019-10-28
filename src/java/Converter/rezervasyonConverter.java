/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.rezervasyonDAO;
import Entity.rezervasyon;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author haticeozbakir
 */
@FacesConverter(value="rezervasyonConverter")
public class rezervasyonConverter implements Converter {
     rezervasyonDAO rezDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getRezervasyonDAO().getRez(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
        rezervasyon r=(rezervasyon)o;
        return r.getRezID().toString();
    }
    public rezervasyonDAO getRezervasyonDAO(){
       if(this.rezDao==null)
           this.rezDao=new rezervasyonDAO();
       return rezDao;
    }
}
