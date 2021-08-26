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

public class OccupationLCWriteAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// 설문정보의 PK
		String memberId = (String) session.getAttribute("memberId");

		// 설문정보의 PK 각 VO에 설정
		OccupationVO likingOcc = new OccupationVO();
		likingOcc.setId(memberId);

		OccupationVO compOcc = new OccupationVO();
		compOcc.setId(memberId);

		// 사용자가 등록한 정보 가져오기 getParameter()
		ArrayList<OccupationDescVO> likingDescList = new ArrayList<OccupationDescVO>();
		ArrayList<OccupationDescVO> compDescList = new ArrayList<OccupationDescVO>();

		// liking40 설문 데이터
		for (int i = 1; i <= 40; i++) {

			OccupationDescVO occDesc = new OccupationDescVO();
			occDesc.setOccNumber("L" + i);
			occDesc.setOccValue(Integer.valueOf(request.getParameter("L" + i)));
			likingDescList.add(occDesc);

			System.out.println(i + " Value : " + occDesc.getOccValue());

		}

		// comp40 설문 데이터
		for (int i = 1; i <= 40; i++) {

			OccupationDescVO occDesc = new OccupationDescVO();
			occDesc.setOccNumber("C" + i);
			occDesc.setOccValue(Integer.valueOf(request.getParameter("C" + i)));
			compDescList.add(occDesc);

			System.out.println(i + " Value : " + occDesc.getOccValue());

		}

		OccupationDAO oDao = OccupationDAO.getInstance();

		likingOcc.setOccValueList(likingDescList);
		compOcc.setOccValueList(compDescList);

		// 설문 DB 저장
		oDao.insertLikingOccupation(likingOcc);
		oDao.insertCompOccupation(compOcc);

		// liking40 설문 점수 DB 저장
		BasicInterestDescVO lBasic = new BasicInterestDescVO();
		lBasic = oDao.getLBasicInterest(memberId);
		oDao.insertLBasicInterest(memberId, lBasic);

		// comp40 설문 점수 DB 저장
		BasicInterestDescVO cBasic = new BasicInterestDescVO();
		cBasic = oDao.getCBasicInterest(memberId);
		oDao.insertCBasicInterest(memberId, cBasic);

		// 설문 결과 확인
		boolean res = false;
		res = oDao.isSurveyComple(memberId);

		if (res) {

			new OccupationLCResultAction().execute(request, response);

		} else {

			new OccupationLCWriteFormAction().execute(request, response);

		}

	}
}