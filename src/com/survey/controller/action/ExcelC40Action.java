package com.survey.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.OccupationDAO;

public class ExcelC40Action implements Action {

	@Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      OccupationDAO oDao = OccupationDAO.getInstance();

	      request.setAttribute("occup_competence_excel", oDao.getAllCompetenceList());

	      response.setCharacterEncoding("UTF-8");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("excel_c40.jsp");
	      dispatcher.forward(request, response);

	   }

}