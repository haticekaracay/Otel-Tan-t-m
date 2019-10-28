/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.ozelliklerDAO;
import Entity.ozellikler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author haticeozbakir
 */
@FacesConverter(value="ozellikConverter")
public class ozellikConverter implements Converter {
    private ozelliklerDAO ozlDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
      return this.getOzelliklerDAO().getOZ(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
      ozellikler oz=(ozellikler) o;
      return oz.getOzellikID().toString();
    }
    public ozelliklerDAO getOzelliklerDAO(){
    if(this.ozlDao==null)
        this.ozlDao=new ozelliklerDAO();
    return ozlDao;
    }
    
}
