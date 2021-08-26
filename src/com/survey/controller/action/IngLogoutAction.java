package com.survey.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.survey.dao.OccupationDAO;

public class IngLogoutAction implements Action {

      @Override
      public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
   
            HttpSession session = request.getSession();
         String memberId = (String) session.getAttribute("memberId");
      request.setAttribute("DeleteOccupation108", OccupationDAO.getInstance().deleteOccupation(memberId));
         
         
   
         session.invalidate();
         
         response.sendRedirect("login.jsp");
         
   /*
         RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
         dispatcher.forward(request, response);
   */      
         
      }

   }