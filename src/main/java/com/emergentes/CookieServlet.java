/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ela
 */
@WebServlet(name = "CookieServlet", urlPatterns = {"/CookieServlet"})
public class CookieServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String mensaje=null;
       boolean nuevaVisita =true;
       // Obtener el arreglo de cookie
       Cookie[]cookies =request.getCookies();
       
       if(cookies !=null){ 
           for(Cookie c: cookies){
               if ((c.getName().equals("visitante")) && c.getValue().equals("SI")){
              nuevaVisita = false;
              break;
           }
           
       }
    }

    if (nuevaVisita){
        Cookie ck = new Cookie("visitante","SI");
        ck.setMaxAge(120);
        ck.setComment("Control de nuevos visitantes");
      response.addCookie(ck) ; 
      mensaje ="gracias por visitar nuestra pagina";
      
    }
    else{
        mensaje ="estamos agradecidos por tenerle nuevamente";
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<h1>"+ mensaje +"</h1>");
    out.println("<a href='index.jsp'>Ir al inicio</a>");
    
    
    }
    
    }

    
    


