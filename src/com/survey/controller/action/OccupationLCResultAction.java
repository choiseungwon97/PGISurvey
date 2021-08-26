package com.survey.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.survey.dao.OccupationDAO;

public class OccupationLCResultAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String memberId = (String) session.getAttribute("memberId");

		request.setAttribute("LBresultList", OccupationDAO.getInstance().getLBasicOrderByResult(memberId));
		request.setAttribute("CBresultList", OccupationDAO.getInstance().getCBasicOrderByResult(memberId));

		response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);

	}
}