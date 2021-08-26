package com.survey.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.OccupationDAO;

public class OccupationLCWriteFormAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "surveyview.jsp";

		OccupationDAO oDao = OccupationDAO.getInstance();
		request.setAttribute("surveyList", oDao.getOccupationList());

		// 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}