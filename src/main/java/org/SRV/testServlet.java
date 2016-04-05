/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.SRV;
import com.google.gson.Gson;
import com.journaldev.spring.model.Essence;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
/**
 *
 * @author Abbas
 */
@WebServlet(name = "testServlet", urlPatterns = {"/testServlet"})
public class testServlet extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet testServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        entityManagerFactory = Persistence.createEntityManagerFactory("org.SRV_war_1.0.0-BUILD-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        List<Essence> essence = entityManager.createQuery("select * from essence").getResultList();        
        //Query query = entityManager.createQuery("FROM Essence u WHERE  u.id = :id").setParameter("id", 1);
        //List<Essence> resultList = query.getResultList();
        List<Essence> resultList = entityManager.createQuery("SELECT e FROM Essence e").getResultList();
        entityManager.close();   
        entityManagerFactory.close();
        String json = new Gson().toJson(resultList);
        response.getWriter().write(json);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    EntityManagerFactory entityManagerFactory;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        double value1 = Double.parseDouble(request.getParameter("val1"));
        double value2 = Double.parseDouble(request.getParameter("val2"));        
        
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        //com.seostella_springsecuritybasics_war_1.0.0-BUILD-SNAPSHOTPU
        entityManagerFactory = Persistence.createEntityManagerFactory("org.SRV_war_1.0.0-BUILD-SNAPSHOTPU");
        
        double result=0; 
        switch(request.getParameter("operation").charAt(0))
        {
            case '+':  result = value1+value2;
                break;
            case '-':  result = value1-value2;
                break;
            case '*':  result = value1*value2;
                break;
            case '/':  result = value1/value2;
                break;
            default: 
                break;
        } 
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();        
        entityManager.getTransaction().begin();
        Date date = new Date();
        Essence essence = new Essence();
        essence.setLogin(username);
        essence.setDate(date);
        essence.setValue1(Double.toString(value1));
        essence.setValue2(Double.toString(value2));
        essence.setOperation(request.getParameter("operation"));
        essence.setResult(Double.toString(result));
        entityManager.persist(essence);
        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.close();   
        entityManagerFactory.close();
        JSONObject obj;
        obj = new JSONObject();
        obj.put("result", result);      
        //response.getOutputStream().print(obj.toString());
        response.getWriter().write(obj.toString());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
