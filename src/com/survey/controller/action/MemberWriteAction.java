package com.survey.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.MemberDAO;
import com.survey.domain.MemberVO;

public class MemberWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberVO mVo = new MemberVO();

		mVo.setId(request.getParameter("memberId"));
		mVo.setPassword(request.getParameter("memberPw"));
		mVo.setFirstName(request.getParameter("memberFName"));
		mVo.setLastName(request.getParameter("memberLName"));
		mVo.setGender(request.getParameter("memberGender").charAt(0));
		mVo.setAge(request.getParameter("memberAge") == null ? 0 : Integer.valueOf(request.getParameter("memberAge")));

		mVo.setEthnicBg(request.getParameter("ethnicBd") == null || request.getParameter("ethnicBd") == "" ? 0
				: Integer.valueOf(request.getParameter("ethnicBd")));

		mVo.setMajor(request.getParameter("memberMajor"));
		mVo.setJob(request.getParameter("memberJob"));
		mVo.setfJob(request.getParameter("memberFjob"));
		mVo.setmJob(request.getParameter("memberMjob"));

		// DB 에 insert 한다
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.insertMember(mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);

		/*
		 * // 결과 값 리턴 new mainAction().execute(request, response);
		 */
	}

}