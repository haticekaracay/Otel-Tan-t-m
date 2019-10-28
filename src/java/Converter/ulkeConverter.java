/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.ulkeDAO;
import Entity.ulke;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author haticeozbakir
 */
@FacesConverter(value="ulkeConverter")
public class ulkeConverter implements Converter {
 private ulkeDAO ulkDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
       return this.getUlkDao().getUlke(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
        ulke u=(ulke) o;
        return u.getUlkeID().toString();
    }

    public ulkeDAO getUlkDao() {
        if(this.ulkDao==null)
            this.ulkDao=new ulkeDAO();
        return ulkDao;
    }
    
}
