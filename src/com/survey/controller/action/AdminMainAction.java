package com.survey.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.OccupationDAO;

public class AdminMainAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("occup_108", OccupationDAO.getInstance().getOccupCnt());
		request.setAttribute("occup_l40", OccupationDAO.getInstance().getLoccupCnt());
		request.setAttribute("occup_c40", OccupationDAO.getInstance().getCoccupCnt());

		response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
		dispatcher.forward(request, response);
		
	}

}
