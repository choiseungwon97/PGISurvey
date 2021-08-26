package com.survey.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.survey.dao.OccupationDAO;
import com.survey.domain.BasicInterestDescVO;
import com.survey.domain.OccupationDescVO;
import com.survey.domain.OccupationVO;

public class OccupationWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// 설문정보의 PK
		String memberId = (String) session.getAttribute("memberId");

		// 설문정보의 PK 각 VO에 설정
		OccupationVO occ = new OccupationVO();
		occ.setId(memberId);

		// 사용자가 등록한 정보 가져오기 getParameter()
		ArrayList<OccupationDescVO> descList = new ArrayList<OccupationDescVO>();

		// Job108 설문 데이터
		for (int i = 1; i <= 108; i++) {

			OccupationDescVO occDesc = new OccupationDescVO();
			occDesc.setOccNumber("I" + i);
			occDesc.setOccValue(Integer.valueOf(request.getParameter("I" + i)));
			descList.add(occDesc);

			System.out.println(i + " Value : " + occDesc.getOccValue());

		}

		OccupationDAO oDao = OccupationDAO.getInstance();

		occ.setOccValueList(descList);

		// 설문 DB 저장 --OccupationDAO 1095번줄
		oDao.insertOccupation(occ);

		// J108 설문 점수 DB 저장
		BasicInterestDescVO basic = new BasicInterestDescVO();
		basic = oDao.getBasicInterest(memberId);
		oDao.insertBasicInterest(memberId, basic);

		// 설문 결과 확인
		boolean res = false;

		res = oDao.isSurveyComple108(memberId);

		if (res) {

			new OccupationLCWriteFormAction().execute(request, response);

		} else {

			new OccupationWriteFormAction().execute(request, response);

		}

	}

}