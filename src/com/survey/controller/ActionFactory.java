package com.survey.controller;

import com.survey.controller.action.Action;
import com.survey.controller.action.AdminMainAction;
import com.survey.controller.action.Excel108Action;
import com.survey.controller.action.ExcelC40Action;
import com.survey.controller.action.ExcelL40Action;
import com.survey.controller.action.IngLogoutAction;
import com.survey.controller.action.LoginAction;
import com.survey.controller.action.LoginFormAction;
import com.survey.controller.action.LogoutAction;
import com.survey.controller.action.MemberIdCheckAction;
import com.survey.controller.action.MemberWriteAction;
import com.survey.controller.action.MemberWriteFormAction;
import com.survey.controller.action.OccupationLCResultAction;
import com.survey.controller.action.OccupationLCWriteAction;
import com.survey.controller.action.OccupationLCWriteFormAction;
import com.survey.controller.action.OccupationWriteAction;
import com.survey.controller.action.OccupationWriteFormAction;

public class ActionFactory {

   // singleton pattern
   private static ActionFactory instance = new ActionFactory();

   public ActionFactory() {
      super();
   }

   public static ActionFactory getInstance() {
      return instance;
   }

   public Action getAction(String command) {
      Action action = null;
      System.out.println("ActionFactory :" + command);

      // 108가지 직업 선호도 설문 조사 화면으로 이동
      if (command.equals("occupation_write_form")) {
         
         action = new OccupationWriteFormAction();
      
      // 108가지 직업 선도호 설문 조사 
      } else if (command.equals("occupation_write")) {
         
         action = new OccupationWriteAction();
         
      // 40가지 직무 선호도/수행능력 설문 조사 화면으로 이동
      } else if (command.equals("occupation_lc_write_form")) {
         
         action = new OccupationLCWriteFormAction();
         
      // 40가지 직무 선호도/수행능력 설문 조사
      } else if (command.equals("occupation_lc_write")) {
         
         action = new OccupationLCWriteAction();
         
      // 40가지 직무 선호도/수행능력 설문 조사 결과
      } else if (command.equals("occupation_lc_result")) {
         
         action = new OccupationLCResultAction();
         
      // 로그인
      } else if (command.equals("login")) {
         
         action = new LoginAction();
         
      // 로그아웃   
      } else if (command.equals("logout")) {
         
         action = new LogoutAction();
         
      // 관리자 화면
      } else if (command.equals("admin_main")) {
         
         action = new AdminMainAction();
         
      // 회원가입 화면으로 이동 
      } else if (command.equals("member_write_form")) {
         
         action = new MemberWriteFormAction();
         
      // 회원가입
      } else if (command.equals("member_write")) {
         
         action = new MemberWriteAction();
         
      // 108가지 직업 선호도 설문 조사 결과 EXCEL 파일로 다운로드
      } else if (command.equals("excel108")) {
         
         action = new Excel108Action();
         
      // 40가지 직무 선호도 설문 조사 결과 EXCEL 파일로 다운로드
      } else if (command.equals("excell40")) {
         
         action = new ExcelL40Action();
      
      // 40가지 직무 수행능력 설문 조사 결과 EXCEL 파일로 다운로드
      } else if (command.equals("excelc40")) {
         
         action = new ExcelC40Action();
      
      // ID 중복확인 
      } else if (command.equals("member_Id_Check")) {
         
         action = new MemberIdCheckAction();
         
      // 로그인 화면으로 이동
      } else if (command.equals("login_form")) {
         
         action = new LoginFormAction();
      
      // 40가지 직무 수행능력 설문 조사 참여 중 로그아웃
      } else if (command.equals("ing_logout")) {
         
         action = new IngLogoutAction();
         
      }
      
      return action;
   }
}