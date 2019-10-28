/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import Entity.groups;
import Entity.users;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/pages/*"})
public class LoginFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res =(HttpServletResponse) response;
        String url=req.getRequestURI();
        users us=(users) req.getSession().getAttribute("valid_users");
        groups gr=(groups) req.getSession().getAttribute("valid_groups");
        
        if(us==null){
            
            if(url.contains("template/admin/indexx") ){
           res.sendRedirect(req.getContextPath()+"/register.xhtml");
               
            }
            else{
            chain.doFilter(request, response);
            }
            
            
        }
        else{
        
         if(url.contains("register")){
         res.sendRedirect(req.getContextPath()+"/template/admin/indexx.xhtml");
         }
        else{
         chain.doFilter(request, response);}
        
         }
        if(gr==null){
          
            if(url.contains("template/yetkili/yetindex")){
           res.sendRedirect(req.getContextPath()+"/yetkili.xhtml");
                
            }     
            
        }
        else{     
            
            
         if(url.contains("yetkili")){
         res.sendRedirect(req.getContextPath()+"/template/yetkili/yetindex.xhtml");}
      
         }
        }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
    }
    

