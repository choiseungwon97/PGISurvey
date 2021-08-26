package com.survey.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.survey.dao.MemberDAO;
import com.survey.dao.OccupationDAO;
import com.survey.domain.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		System.out.println(user);
		System.out.println(pass);

		if ((user != null && user.trim().length() > 0) && (pass != null && pass.trim().length() > 0)) {

			MemberDAO login = MemberDAO.getInstance();
			boolean grade = false;
			grade = login.loginCheck(user, pass);

			if (grade) { //

				MemberVO member = MemberDAO.getInstance().getMemberInfo(user);

				HttpSession session = request.getSession();
				session.setAttribute("memberId", member.getId());
				session.setAttribute("memberName", member.getFirstName() + " " + member.getLastName());

				if (user.equals("admin")) {

					response.sendRedirect("member?command=admin_main");

				} else {

					// 사용자면, 설문 했는지 유무를 판단
					OccupationDAO oDao = OccupationDAO.getInstance();
					boolean res = oDao.isSurveyComple108(member.getId());

					// 설문 했으면 결과 페이지로 이동
					if (res) {

						new OccupationLCResultAction().execute(request, response);

					} else {

						// 설문 안했으면 설문 페이지로 이동
						new OccupationWriteFormAction().execute(request, response);

					}

				}

			} else { //

				PrintWriter out = response.getWriter();
				out.print("<head>");
				out.print("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
				out.print("</head>");
				out.print("<script>alert('아이디와 비밀번호를 확인해주세요.'); history.go(-1);</script>");

			}
		}

	}

	/*
	 * String url = "/survey/login.jsp"; String no = request.getParameter("no");
	 * String pass = request.getParameter("pass");
	 * 
	 * MemberDao mDao = MemberDao.getInstance();
	 * 
	 * boolean result = mDao.loginCheck(no, pass);
	 * 
	 * if(result) {
	 * 
	 * MemberVO mVo = mDao.getMemberInfo(no);
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * session.setAttribute("loginUser", mVo); request.setAttribute("message",
	 * "로그인에 성공했습니다."); url = "main.jsp";
	 * 
	 * }
	 * 
	 * RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	 * dispatcher.forward(request, response);
	 */
}