package com.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAOLocal;
import com.utility.JNDILookupClass;

/**
 *
 * @author Vedang Rane
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @EJB
    private LoginDAOLocal loginDao;
    Boolean check=false;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
	    String userName = request.getParameter("userName");
	    String password = request.getParameter("password");
	    HttpSession session = request.getSession();
           
//	    loginDao = doLookup();
	    
        check = loginDao.checkUser(userName,password);
         System.out.println("check is"+check+" "+userName);
           if(check)     
           {
              session.setAttribute("loginName", userName);
              request.getRequestDispatcher("home.jsp").forward(request, response);
           }
           else
           {
               request.setAttribute("error", "Wrong Username or Password");
               request.getRequestDispatcher("error.jsp").forward(request, response);
           }
        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    private static LoginDAOLocal doLookup() {
        Context context = null;
        LoginDAOLocal dao = null;
        try {
            // 1. Obtaining Context
            context = JNDILookupClass.getInitialContext();
            // 2. Lookup and cast
            dao = (LoginDAOLocal) context.lookup("/MyEJBApplication/");
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dao;
    }

}
