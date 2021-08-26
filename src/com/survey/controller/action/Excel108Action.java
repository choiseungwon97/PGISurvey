package com.survey.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.OccupationDAO;

public class Excel108Action implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      OccupationDAO oDao = OccupationDAO.getInstance();

      
      request.setAttribute("occup_108_excel", oDao.getAllOccupationList());
      

      response.setCharacterEncoding("UTF-8");
      RequestDispatcher dispatcher = request.getRequestDispatcher("excel_108.jsp");
      dispatcher.forward(request, response);

   }

}