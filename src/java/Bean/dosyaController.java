
package Bean;
import DAO.dosyaDAO;
import DAO.otelDAO;
import Entity.dosya;
import Entity.otel;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

@ManagedBean(name="dosya")
@SessionScoped
public class dosyaController implements Serializable{
     private dosya dsy;
     private List<dosya> dsyList;
     private dosyaDAO dsyDao;
     private otelDAO otlDao;
     private Part dos;
     private final String uploadTo="C:\\Users\\haticeozbakir\\Documents\\OT2\\web\\resources\\resimler";
    
     private ArrayList<otel> olist=null;

    public ArrayList<otel> getOlist() {
        this.olist=this.getOtlDao().list();
        return olist;
    }

    public void setOlist(ArrayList<otel> olist) {
        this.olist = olist;
    }
     public otelDAO getOtlDao() {
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }
     
     public void upload(){
          try{
              InputStream input=dos.getInputStream();
              File f=new File(uploadTo+dos.getSubmittedFileName());
              Files.copy(input, f.toPath());
              dsy=this.getDsy();
              dsy.setDosyaYolu(f.getParent());
              dsy.setDosyaAdi(f.getName());
              dsy.setDosyaTipi(dos.getContentType());
              this.getDsyDao().create(dsy);
          }catch(Exception e){
              System.out.println(e.getMessage());
              System.out.println("abaa");
          }
      }

    public String getUploadTo() {
        return uploadTo;
    }
      
    public dosya getDsy() {
        if(this.dsy==null)
            this.dsy=new dosya();
        return dsy;
    }

    public void setDsy(dosya dsy) {
        this.dsy = dsy;
    }

    public List<dosya> getDsyList() {
        this.dsyList=this.getDsyDao().findAll();
        return dsyList;
    }

    public void setDsyList(List<dosya> dsyList) {
        this.dsyList = dsyList;
    }

    public dosyaDAO getDsyDao() {
        if(this.dsyDao==null)
            this.dsyDao=new dosyaDAO();
        return dsyDao;
    }

    public void setDsyDao(dosyaDAO dsyDao) {
        this.dsyDao = dsyDao;
    }

    public Part getDos() {
        return dos;
    }

    public void setDos(Part dos) {
        this.dos = dos;
    }
 

}
