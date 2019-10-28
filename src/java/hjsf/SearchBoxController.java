/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hjsf;

import hjsf.searchBoxDAO;
import Entity.otel;
import Entity.sehir;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author haticeozbakir
 */
@ManagedBean(name="searchBoxController")
@SessionScoped
public class SearchBoxController {
    private otel otl=null;
    private sehir shr=null;
    private ArrayList<otel> otllist=null;
    private searchBoxDAO srcDAO=null;

    public sehir getShr() {
        if(this.shr==null)
            this.shr=new sehir();
        return shr;
    }

    public void setShr(sehir shr) {
        this.shr = shr;
    }
    
    public otel getOtl() {
        if(this.otl==null)
            this.otl=new otel();
        return otl;
    }

    public void setOtl(otel otl) {
        this.otl = otl;
    }

    public ArrayList<otel> getlist() {
        if(this.otllist==null){
            this.otllist=new ArrayList();
            otllist=this.getOtelDAO().list();
                    }
        return otllist;
    }

    public void setlist(ArrayList<otel> otllist) {
        this.otllist = otllist;
    }
   
    public searchBoxDAO getOtelDAO(){
    if(this.srcDAO==null)
        this.srcDAO=new searchBoxDAO();
     return srcDAO;
    }
    
    public void setOtelDAO(searchBoxDAO otelDAO){
        this.srcDAO=otelDAO;
    }
    
    
}
