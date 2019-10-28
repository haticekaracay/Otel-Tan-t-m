/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.otelDAO;
import Entity.otel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author haticeozbakir
 */
@FacesConverter(value="otelConverter")
public class otelConverter implements Converter {
     private otelDAO otlDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
       return this.getOtelDAO().getOtl(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
       otel ot=(otel) o;
       return ot.getOtelID().toString();
    }
    public otelDAO getOtelDAO(){
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }
}
