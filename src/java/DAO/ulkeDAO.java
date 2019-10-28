/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author haticeozbakir
 */
import Entity.sehir;
import Entity.ulke;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ulkeDAO {

    private ulke ul = null;
    private ArrayList<ulke> ullist = null;

    public ulke getUlke(Long id) {
        Connection con = ConnectionManager.getConnection();
        try {
            PreparedStatement st=con.prepareStatement("select *from ulke where ulkeID=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            this.ul = new ulke(rs.getLong("ulkeID"), rs.getString("ulkeAdi"),rs.getLong("otelSayisiU"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return this.ul;
    }

    public ArrayList<ulke> list() {
        this.ullist = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {
            PreparedStatement pst=con.prepareStatement("select *from ulke order by ulkeID desc ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ulke u = new ulke();
                u.setUlkeID(rs.getLong("ulkeID"));
                u.setUlkeAdi(rs.getString("ulkeAdi"));
                u.setOtelSayisiU(rs.getLong("otelSayisiU"));
                this.ullist.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ullist;
    }

    public void delete(ulke u) {
        Connection con = ConnectionManager.getConnection();

        try {
            PreparedStatement st = con.prepareStatement("delete from ulke where ulkeID=?");
            st.setLong(1, u.getUlkeID());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(ulke u) {
        Connection con = ConnectionManager.getConnection();
        try {
           String update="update ulke set ulkeAdi=?,otelSayisiU=? where ulkeID=? ";
           PreparedStatement ps=con.prepareStatement(update);
           ps.setString(1, u.getUlkeAdi());
           ps.setLong(2, u.getOtelSayisiU());
           ps.setLong(3, u.getUlkeID()); 
           ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void create(ulke u) {
        Connection con = ConnectionManager.getConnection();
        try {
            PreparedStatement pst=con.prepareStatement("insert into ulke(ulkeAdi,otelSayisiU) values (?,?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, u.getUlkeAdi());
            pst.setLong(2, u.getOtelSayisiU());
            pst.executeUpdate();
             Long ulkeID=null;
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
             ulkeID=gk.getLong(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
