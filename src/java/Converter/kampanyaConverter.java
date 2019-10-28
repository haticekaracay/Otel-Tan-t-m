/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.kampanyaDAO;
import Entity.kampanya;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author haticeozbakir
 */
@FacesConverter(value="kampanyaConverter")
public class kampanyaConverter implements Converter {
    private kampanyaDAO kamDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
     return this.getKampanyaDAO().getKam(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
    kampanya k=(kampanya) o;
    return k.getKamID().toString();
    }
    public kampanyaDAO getKampanyaDAO(){
        if(this.kamDao==null)
            this.kamDao=new kampanyaDAO();
        return kamDao;
    }
    
}
