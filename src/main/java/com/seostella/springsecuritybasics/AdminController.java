package com.seostella.springsecuritybasics;

/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value = "/calculator", method = RequestMethod.GET)
	public String calculator() {
		return "calculator";
	}
        @RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}
        @RequestMapping(value = "/testServlet", method = RequestMethod.GET)
	public String Servlet() {
		return "testServlet";
	}
        /*@RequestMapping(value = "/insertDB", method = RequestMethod.GET)
	public void InsertDB() {
            EntityManagerFactory emFactory;
            emFactory = Persistence.createEntityManagerFactory("persistence");
            EntityManager em = emFactory.createEntityManager();
            UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
	}*/
}
