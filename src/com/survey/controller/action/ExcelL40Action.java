package com.survey.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.OccupationDAO;

public class ExcelL40Action implements Action {

   
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      OccupationDAO oDao = OccupationDAO.getInstance();

      request.setAttribute("occup_liking_excel", oDao.getAllLikingList());

      response.setCharacterEncoding("UTF-8");
      RequestDispatcher dispatcher = request.getRequestDispatcher("excel_l40.jsp");
      dispatcher.forward(request, response);

   }
}