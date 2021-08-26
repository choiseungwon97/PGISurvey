package com.survey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.survey.domain.BasicInterestDescVO;
import com.survey.domain.BasicOderVO;
import com.survey.domain.OccupationDescVO;
import com.survey.domain.OccupationVO;

import util.CommonDao;

public class OccupationDAO extends CommonDao {

   private static OccupationDAO instance;

   public static OccupationDAO getInstance() {
      if (instance == null) {
         instance = new OccupationDAO();
      }
      return instance;
   }

   // 설문된 competence의 갯수 admin login.do에 위치
   public String getCoccupCnt() {

      Connection conn = getConnection();

      String res = "";

      ResultSet rs = null;
      PreparedStatement st;

      try {
         st = conn.prepareStatement("SELECT count(*) AS CNT FROM TB_OCCLCOMPETENCE");
         rs = st.executeQuery();

         while (rs.next()) {

            res = rs.getString("CNT");
         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return res;
   }

   // 설문된 liking의 갯수 admin login.do에 위치
   public String getLoccupCnt() {

      Connection conn = getConnection();

      String res = "";

      ResultSet rs = null;
      PreparedStatement st;

      try {
         st = conn.prepareStatement("SELECT count(*) AS CNT FROM TB_OCCLIKING");
         rs = st.executeQuery();

         while (rs.next()) {

            res = rs.getString("CNT");
         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return res;
   }

   // 설문된 직업108개 갯수 admin login.do에 위치
   public String getOccupCnt() {

      Connection conn = getConnection();

      String res = "";

      ResultSet rs = null;
      PreparedStatement st;

      try {
         st = conn.prepareStatement("SELECT count(*) AS CNT FROM TB_OCCUPATION");
         rs = st.executeQuery();

         while (rs.next()) {

            res = rs.getString("CNT");
         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return res;
   }

   // liking competence에 관한 설명
   public ArrayList<OccupationDescVO> getOccupationList() {

      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      ArrayList<OccupationDescVO> descList = new ArrayList<OccupationDescVO>();

      try {
         st = conn.prepareStatement("SELECT * FROM TB_SIMPLE_OCCUPATION_DESC ORDER BY OCCNUMBER ASC");
         rs = st.executeQuery();

         while (rs.next()) {

            OccupationDescVO occDesc = new OccupationDescVO();
            occDesc.setOccNumber(rs.getString("OCCNUMBER"));
            occDesc.setOccName(rs.getString("OCCNAME"));
            descList.add(occDesc);

         }

         dbClose();

      } catch (SQLException e) {

         e.printStackTrace();
      }

      return descList;
   }

   // liking제작 simple_Occupation가 없어도 OccupationVO가 있으면 제작가능
   public int insertLikingOccupation(OccupationVO occ) {

      int res = 0;
      String q = "";

      for (int i = 0; i <= 39; i++) {

         q += "?, ";
      }

      Connection conn = getConnection();

      PreparedStatement st;

      String sql = "INSERT INTO TB_OCCLIKING  ";
      sql += "VALUES(" + q + " ?)";

      System.out.println(sql);

      try {
         st = conn.prepareStatement(sql);

         st.setString(1, occ.getId());

         for (int i = 0; i <= 39; i++) {

            int value = occ.getOccValueList().get(i).getOccValue();

            st.setInt(i + 2, value);
            System.out.println(i + 2 + " : value : " + value);

         }

         res = st.executeUpdate();

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         res = 0;
         e.printStackTrace();
      }

      return res;
   }

   // competence제작 simple_Occupation가 없어도 OccupationVO가 있으면 제작가능
   public int insertCompOccupation(OccupationVO occ) {

      int res = 0;
      String q = "";

      for (int i = 0; i <= 39; i++) {

         q += "?, ";
      }

      Connection conn = getConnection();

      PreparedStatement st;

      String sql = "INSERT INTO TB_OCCLCOMPETENCE  ";
      sql += "VALUES(" + q + " ?)";

      System.out.println(sql);

      try {
         st = conn.prepareStatement(sql);

         st.setString(1, occ.getId());

         for (int i = 0; i <= 39; i++) {

            int value = occ.getOccValueList().get(i).getOccValue();

            st.setInt(i + 2, value);
            System.out.println(i + 2 + " : value : " + value);

         }

         res = st.executeUpdate();

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         res = 0;
         e.printStackTrace();
      }

      return res;
   }

   // 결과값 8개 만들기
   public int insertBasicInterest(String id, BasicInterestDescVO basic) {

      int res = 0;

      Connection conn = getConnection();

      PreparedStatement st;

      try {
         st = conn.prepareStatement("INSERT INTO TB_BASIC_INTEREST VALUES(?, ?, ? , ?, ?, ?, ? ,? ,?) ");
         st.setString(1, id);
         st.setInt(2, basic.getSocialFacilitating());
         st.setInt(3, basic.getManaging());
         st.setInt(4, basic.getBusinessDetail());
         st.setInt(5, basic.getDataProcessing());
         st.setInt(6, basic.getMechanical());
         st.setInt(7, basic.getNature());
         st.setInt(8, basic.getArtistic());
         st.setInt(9, basic.getHelping());

         res = st.executeUpdate();

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return res;
   }

   // liking 결과값 8개 만들기
   public int insertLBasicInterest(String id, BasicInterestDescVO basic) {

      int res = 0;

      Connection conn = getConnection();

      PreparedStatement st;

      try {
         st = conn.prepareStatement("INSERT INTO TB_LBASIC_INTEREST VALUES(?, ?, ? , ?, ?, ?, ? ,? ,?) ");
         st.setString(1, id);
         st.setInt(2, basic.getSocialFacilitating());
         st.setInt(3, basic.getManaging());
         st.setInt(4, basic.getBusinessDetail());
         st.setInt(5, basic.getDataProcessing());
         st.setInt(6, basic.getMechanical());
         st.setInt(7, basic.getNature());
         st.setInt(8, basic.getArtistic());
         st.setInt(9, basic.getHelping());

         res = st.executeUpdate();

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return res;
   }

   // competence 결과값8개 만들기
   public int insertCBasicInterest(String id, BasicInterestDescVO basic) {

      int res = 0;

      Connection conn = getConnection();

      PreparedStatement st;

      try {
         st = conn.prepareStatement("INSERT INTO TB_CBASIC_INTEREST VALUES(?, ?, ? , ?, ?, ?, ? ,? ,?) ");
         st.setString(1, id);
         st.setInt(2, basic.getSocialFacilitating());
         st.setInt(3, basic.getManaging());
         st.setInt(4, basic.getBusinessDetail());
         st.setInt(5, basic.getDataProcessing());
         st.setInt(6, basic.getMechanical());
         st.setInt(7, basic.getNature());
         st.setInt(8, basic.getArtistic());
         st.setInt(9, basic.getHelping());

         res = st.executeUpdate();

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return res;
   }

   // 결과값산출(계산)
   public BasicInterestDescVO getBasicInterest(String id) {

      BasicInterestDescVO basic = new BasicInterestDescVO();
      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      String sql = "SELECT (I1 + I9 + I17 + I25 + I33 + I41) AS SCORE1,  "
            + "(i2 + i10 + i18 + i26 + i34 + i42) AS SCORE2 , " + "(i3 + i11 + i19 + i27 + i35 + i43) AS SCORE3 , "
            + "(i4 + i12 + i20 + i28 + i36 + i44) AS SCORE4 , " + "(i5 + i13 + i21 + i29 + i37 + i45) AS SCORE5 , "
            + "(i6 + i14 + i22 + i30 + i38 + i46) AS SCORE6 , " + "(i7 + i15 + i23 + i31 + i39 + i47) AS SCORE7 , "
            + "(i8 + i16 + i24 + i32 + i40 + i48) AS SCORE8 " + "FROM TB_OCCUPATION WHERE ID=?";

      try {
         st = conn.prepareStatement(sql);
         st.setString(1, id);
         rs = st.executeQuery();

         if (rs.next()) {

            basic.setSocialFacilitating(rs.getInt("SCORE1"));
            basic.setManaging(rs.getInt("SCORE2"));
            basic.setBusinessDetail(rs.getInt("SCORE3"));
            basic.setDataProcessing(rs.getInt("SCORE4"));
            basic.setMechanical(rs.getInt("SCORE5"));
            basic.setNature(rs.getInt("SCORE6"));
            basic.setArtistic(rs.getInt("SCORE7"));
            basic.setHelping(rs.getInt("SCORE8"));

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return basic;

   }

   // liking 결과값산출(계산)
      public BasicInterestDescVO getLBasicInterest(String id) {

         BasicInterestDescVO basic = new BasicInterestDescVO();
         Connection conn = getConnection();

         ResultSet rs = null;
         PreparedStatement st;

         String sql = "SELECT (L1 + L9 + L17 + L25 + L33) AS SCORE1,  " + "(L2 + L10 + L18 + L26 + L34) AS SCORE2 , "
               + "(L3 + L11 + L19 + L27 + L35) AS SCORE3 , " + "(L4 + L12 + L20 + L28 + L36) AS SCORE4 , "
               + "(L5 + L13 + L21 + L29 + L37) AS SCORE5 , " + "(L6 + L14 + L22 + L30 + L38) AS SCORE6 , "
               + "(L7 + L15 + L23 + L31 + L39) AS SCORE7 , " + "(L8 + L16 + L24 + L32 + L40) AS SCORE8 "
               + "FROM TB_OCCLIKING WHERE ID=?";

         try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();

            if (rs.next()) {

               basic.setSocialFacilitating(rs.getInt("SCORE1"));
               basic.setManaging(rs.getInt("SCORE2"));
               basic.setBusinessDetail(rs.getInt("SCORE3"));
               basic.setDataProcessing(rs.getInt("SCORE4"));
               basic.setMechanical(rs.getInt("SCORE5"));
               basic.setNature(rs.getInt("SCORE6"));
               basic.setArtistic(rs.getInt("SCORE7"));
               basic.setHelping(rs.getInt("SCORE8"));

            }

            dbClose();

         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

         return basic;

      }
   
   
   // Liking에 대한 결과값 배열
   public ArrayList<BasicOderVO> getLBasicOrderBy(String id) {

      ArrayList<BasicOderVO> basicOrder = new ArrayList<BasicOderVO>();

      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      String sql = "SELECT * FROM " + "(SELECT (L1 + L9 + L17 + L25 + L33) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =1) AS SCORENAME "
            + " FROM TB_OCCLIKING WHERE id = ? ) UNION " +

            "(SELECT (L2 + L10 + L18 + L26 + L34) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =2) AS SCORENAME "
            + " FROM TB_OCCLIKING WHERE id = ? ) UNION " +

            "(SELECT (L3 + L11 + L19 + L27 + L35) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =3) AS SCORENAME "
            + " FROM TB_OCCLIKING WHERE id = ? ) UNION " +

            "(SELECT (L4 + L12 + L20 + L28 + L36) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =4) AS SCORENAME "
            + " FROM TB_OCCLIKING WHERE id = ? ) UNION " +

            "(SELECT (L5 + L13 + L21 + L29 + L37) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =5) AS SCORENAME "
            + " FROM TB_OCCLIKING WHERE id = ? ) UNION " +

            "(SELECT (L6 + L14 + L22 + L30 + L38) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =6) AS SCORENAME "
            + " FROM TB_OCCLIKING WHERE id = ? ) UNION " +

            "(SELECT (L7 + L15 + L23 + L31 + L39) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =7) AS SCORENAME "
            + " FROM TB_OCCLIKING WHERE id = ? ) UNION " +

            "(SELECT (L8 + L16 + L24 + L32 + L40) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =8) AS SCORENAME "
            + " FROM TB_OCCLIKING WHERE id = ? ) ORDER BY SCORE  DESC ";

      try {
         st = conn.prepareStatement(sql);
         st.setString(1, id);
         st.setString(2, id);
         st.setString(3, id);
         st.setString(4, id);
         st.setString(5, id);
         st.setString(6, id);
         st.setString(7, id);
         st.setString(8, id);

         rs = st.executeQuery();

         System.out.println(sql);

         while (rs.next()) {

            BasicOderVO basic = new BasicOderVO();
            basic.setName(rs.getString("SCORENAME"));
            basic.setValue(rs.getInt("SCORE"));

            basicOrder.add(basic);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return basicOrder;

   }

   // Competence 결과값산출(계산)
   public BasicInterestDescVO getCBasicInterest(String id) {

      BasicInterestDescVO basic = new BasicInterestDescVO();
      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      String sql = "SELECT (C1 + C9 + C17 + C25 + C33) AS SCORE1,  " + "(C2 + C10 + C18 + C26 + C34) AS SCORE2 , "
            + "(C3 + C11 + C19 + C27 + C35) AS SCORE3 , " + "(C4 + C12 + C20 + C28 + C36) AS SCORE4 , "
            + "(C5 + C13 + C21 + C29 + C37) AS SCORE5 , " + "(C6 + C14 + C22 + C30 + C38) AS SCORE6 , "
            + "(C7 + C15 + C23 + C31 + C39) AS SCORE7 , " + "(C8 + C16 + C24 + C32 + C40) AS SCORE8 "
            + "FROM TB_OCCLCOMPETENCE WHERE ID=?";

      try {
         st = conn.prepareStatement(sql);
         st.setString(1, id);
         rs = st.executeQuery();

         if (rs.next()) {

            basic.setSocialFacilitating(rs.getInt("SCORE1"));
            basic.setManaging(rs.getInt("SCORE2"));
            basic.setBusinessDetail(rs.getInt("SCORE3"));
            basic.setDataProcessing(rs.getInt("SCORE4"));
            basic.setMechanical(rs.getInt("SCORE5"));
            basic.setNature(rs.getInt("SCORE6"));
            basic.setArtistic(rs.getInt("SCORE7"));
            basic.setHelping(rs.getInt("SCORE8"));

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return basic;

   }

   // Competence에 대한 결과값 배열
   // getLBasicOrderBy
   public ArrayList<BasicOderVO> getCBasicOrderBy(String id) {

      ArrayList<BasicOderVO> basicOrder = new ArrayList<BasicOderVO>();

      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      String sql = "SELECT * FROM " + "(SELECT (C1 + C9 + C17 + C25 + C33) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =1) AS SCORENAME "
            + " FROM TB_OCCLCOMPETENCE WHERE id = ? ) UNION " +

            "(SELECT (C2 + C10 + C18 + C26 + C34) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =2) AS SCORENAME "
            + " FROM TB_OCCLCOMPETENCE WHERE id = ? ) UNION " +

            "(SELECT (C3 + C11 + C19 + C27 + C35) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =3) AS SCORENAME "
            + " FROM TB_OCCLCOMPETENCE WHERE id = ? ) UNION " +

            "(SELECT (C4 + C12 + C20 + C28 + C36) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =4) AS SCORENAME "
            + " FROM TB_OCCLCOMPETENCE WHERE id = ? ) UNION " +

            "(SELECT (C5 + C13 + C21 + C29 + C37) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =5) AS SCORENAME "
            + " FROM TB_OCCLCOMPETENCE WHERE id = ? ) UNION " +

            "(SELECT (C6 + C14 + C22 + C30 + C38) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =6) AS SCORENAME "
            + " FROM TB_OCCLCOMPETENCE WHERE id = ? ) UNION " +

            "(SELECT (C7 + C15 + C23 + C31 + C39) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =7) AS SCORENAME "
            + " FROM TB_OCCLCOMPETENCE WHERE id = ? ) UNION " +

            "(SELECT (C8 + C16 + C24 + C32 + C40) AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =8) AS SCORENAME "
            + " FROM TB_OCCLCOMPETENCE WHERE id = ? ) ORDER BY SCORE  DESC ";

      try {
         st = conn.prepareStatement(sql);
         st.setString(1, id);
         st.setString(2, id);
         st.setString(3, id);
         st.setString(4, id);
         st.setString(5, id);
         st.setString(6, id);
         st.setString(7, id);
         st.setString(8, id);

         rs = st.executeQuery();

         System.out.println(sql);

         while (rs.next()) {

            BasicOderVO basic = new BasicOderVO();
            basic.setName(rs.getString("SCORENAME"));
            basic.setValue(rs.getInt("SCORE"));

            basicOrder.add(basic);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return basicOrder;

   }

   // Liking설문했는지 확인
   public boolean isSurveyComple(String id) {

      boolean res = false;
      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      try {
         st = conn.prepareStatement("SELECT ID FROM TB_OCCLIKING WHERE ID=? ");
         st.setString(1, id);
         rs = st.executeQuery();

         if (rs.next()) {

            res = true;

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return res;
   }

   // 계산식 ex) B1은 8가지중 하나에 대한 계산식
   // getLBasicOrderBy 이 아니라 getBasicOrderBy 같은데 전자로 써있음
   public ArrayList<BasicOderVO> getBasicInterestResult(String id) {

      ArrayList<BasicOderVO> basicOrder = new ArrayList<BasicOderVO>();

      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      String sql = "SELECT * FROM " + "(SELECT B1 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =1) AS SCORENAME "
            + " FROM TB_BASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B2 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =2) AS SCORENAME "
            + " FROM TB_BASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B3 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =3) AS SCORENAME "
            + " FROM TB_BASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B4 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =4) AS SCORENAME "
            + " FROM TB_BASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B5 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =5) AS SCORENAME "
            + " FROM TB_BASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B6 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =6) AS SCORENAME "
            + " FROM TB_BASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B7 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =7) AS SCORENAME "
            + " FROM TB_BASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B8 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =8) AS SCORENAME "
            + " FROM TB_BASIC_INTEREST WHERE id = ? ) ORDER BY SCORE  DESC ";

      try {
         st = conn.prepareStatement(sql);
         st.setString(1, id);
         st.setString(2, id);
         st.setString(3, id);
         st.setString(4, id);
         st.setString(5, id);
         st.setString(6, id);
         st.setString(7, id);
         st.setString(8, id);

         rs = st.executeQuery();

         System.out.println(sql);

         while (rs.next()) {

            BasicOderVO basic = new BasicOderVO();
            basic.setName(rs.getString("SCORENAME"));
            basic.setValue(rs.getInt("SCORE"));

            basicOrder.add(basic);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return basicOrder;

   }

   // 계산식 ex) B1은 8가지중 하나에 대한 계산식
   // getLBasicOrderBy
   public ArrayList<BasicOderVO> getLBasicOrderByResult(String id) {

      ArrayList<BasicOderVO> basicOrder = new ArrayList<BasicOderVO>();

      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      String sql = "SELECT * FROM " + "(SELECT B1 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =1) AS SCORENAME "
            + " FROM TB_LBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B2 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =2) AS SCORENAME "
            + " FROM TB_LBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B3 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =3) AS SCORENAME "
            + " FROM TB_LBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B4 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =4) AS SCORENAME "
            + " FROM TB_LBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B5 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =5) AS SCORENAME "
            + " FROM TB_LBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B6 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =6) AS SCORENAME "
            + " FROM TB_LBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B7 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =7) AS SCORENAME "
            + " FROM TB_LBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B8 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =8) AS SCORENAME "
            + " FROM TB_LBASIC_INTEREST WHERE id = ? ) ORDER BY SCORE  DESC ";

      try {
         st = conn.prepareStatement(sql);
         st.setString(1, id);
         st.setString(2, id);
         st.setString(3, id);
         st.setString(4, id);
         st.setString(5, id);
         st.setString(6, id);
         st.setString(7, id);
         st.setString(8, id);

         rs = st.executeQuery();

         System.out.println(sql);

         while (rs.next()) {

            BasicOderVO basic = new BasicOderVO();
            basic.setName(rs.getString("SCORENAME"));
            basic.setValue(rs.getInt("SCORE"));

            basicOrder.add(basic);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return basicOrder;

   }

   public ArrayList<BasicOderVO> getCBasicOrderByResult(String id) {

      ArrayList<BasicOderVO> basicOrder = new ArrayList<BasicOderVO>();

      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      String sql = "SELECT * FROM " + "(SELECT B1 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =1) AS SCORENAME "
            + " FROM TB_CBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B2 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =2) AS SCORENAME "
            + " FROM TB_CBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B3 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =3) AS SCORENAME "
            + " FROM TB_CBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B4 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =4) AS SCORENAME "
            + " FROM TB_CBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B5 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =5) AS SCORENAME "
            + " FROM TB_CBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B6 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =6) AS SCORENAME "
            + " FROM TB_CBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B7 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =7) AS SCORENAME "
            + " FROM TB_CBASIC_INTEREST WHERE id = ? ) UNION " +

            "(SELECT B8 AS SCORE, "
            + "(SELECT BASNAME FROM TB_BASIC_INTEREST_DESC WHERE BASNUMBER =8) AS SCORENAME "
            + " FROM TB_CBASIC_INTEREST WHERE id = ? ) ORDER BY SCORE  DESC ";

      try {
         st = conn.prepareStatement(sql);
         st.setString(1, id);
         st.setString(2, id);
         st.setString(3, id);
         st.setString(4, id);
         st.setString(5, id);
         st.setString(6, id);
         st.setString(7, id);
         st.setString(8, id);

         rs = st.executeQuery();

         System.out.println(sql);

         while (rs.next()) {

            BasicOderVO basic = new BasicOderVO();
            basic.setName(rs.getString("SCORENAME"));
            basic.setValue(rs.getInt("SCORE"));

            basicOrder.add(basic);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return basicOrder;

   }

   // Competence 8가지 분류에 대한 계산완료값. -화면에 사용자한테 보여주는 값
   public BasicInterestDescVO getCBasicInterestResult(String id) {

      BasicInterestDescVO basic = new BasicInterestDescVO();
      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      String sql = "SELECT B1, B2, B3, B4, B5, B6, B7, B8 " + "FROM TB_CBASIC_INTEREST WHERE ID=?";

      try {
         st = conn.prepareStatement(sql);
         st.setString(1, id);
         rs = st.executeQuery();

         if (rs.next()) {

            basic.setSocialFacilitating(rs.getInt("B1"));
            basic.setManaging(rs.getInt("B2"));
            basic.setBusinessDetail(rs.getInt("B3"));
            basic.setDataProcessing(rs.getInt("B4"));
            basic.setMechanical(rs.getInt("B5"));
            basic.setNature(rs.getInt("B6"));
            basic.setArtistic(rs.getInt("B7"));
            basic.setHelping(rs.getInt("B8"));

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return basic;
   }

   // liking 8가지 분류에 대한 계산완료값. -화면에 사용자한테 보여주는 값
   public BasicInterestDescVO getLBasicInterestResult(String id) {

      BasicInterestDescVO basic = new BasicInterestDescVO();
      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      String sql = "SELECT B1, B2, B3, B4, B5, B6, B7, B8 " + "FROM TB_LBASIC_INTEREST WHERE ID=?";

      try {
         st = conn.prepareStatement(sql);
         st.setString(1, id);
         rs = st.executeQuery();

         if (rs.next()) {

            basic.setSocialFacilitating(rs.getInt("B1"));
            basic.setManaging(rs.getInt("B2"));
            basic.setBusinessDetail(rs.getInt("B3"));
            basic.setDataProcessing(rs.getInt("B4"));
            basic.setMechanical(rs.getInt("B5"));
            basic.setNature(rs.getInt("B6"));
            basic.setArtistic(rs.getInt("B7"));
            basic.setHelping(rs.getInt("B8"));

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return basic;
   }

   // 모든 사용자들의 40개 LIKING에 대한 점수
   public ArrayList<OccupationVO> getAllLikingList() {
      // TODO Auto-generated method stub
      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      ArrayList<OccupationVO> allList = new ArrayList<OccupationVO>();

      try {
         st = conn.prepareStatement("SELECT * FROM TB_OCCLIKING");
         rs = st.executeQuery();

         while (rs.next()) {

            OccupationVO occ = new OccupationVO();
            ArrayList<OccupationDescVO> descList = new ArrayList<OccupationDescVO>();

            for (int i = 1; i <= 40; i++) {

               OccupationDescVO occDesc = new OccupationDescVO();
               occDesc.setOccNumber("L" + i);
               occDesc.setOccValue(rs.getInt("L" + i));
               descList.add(occDesc);

            }

            occ.setId(rs.getString("ID"));
            occ.setOccValueList(descList);
            allList.add(occ);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return allList;
   }

   public ArrayList<OccupationVO> getAllCompetenceList() {
      // TODO Auto-generated method stub
      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      ArrayList<OccupationVO> allList = new ArrayList<OccupationVO>();

      try {
         st = conn.prepareStatement("SELECT * FROM TB_OCCLCOMPETENCE");
         rs = st.executeQuery();

         while (rs.next()) {

            OccupationVO occ = new OccupationVO();
            ArrayList<OccupationDescVO> descList = new ArrayList<OccupationDescVO>();

            for (int i = 1; i <= 40; i++) {

               OccupationDescVO occDesc = new OccupationDescVO();
               occDesc.setOccNumber("C" + i);
               occDesc.setOccValue(rs.getInt("C" + i));
               descList.add(occDesc);

            }

            occ.setId(rs.getString("ID"));
            occ.setOccValueList(descList);
            allList.add(occ);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return allList;
   }

   // user가 108개 설문을 한 후의 답
   public OccupationVO getOccupationInfo(String id) {

      OccupationVO occ = new OccupationVO();

      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      ArrayList<OccupationDescVO> descList = new ArrayList<OccupationDescVO>();

      try {
         st = conn.prepareStatement("SELECT * FROM TB_OCCUPATION WHERE ID=? ");
         st.setString(1, id);
         rs = st.executeQuery();

         if (rs.next()) {

            occ.setId(rs.getString("ID"));

            for (int i = 1; i <= 108; i++) {

               OccupationDescVO occDesc = new OccupationDescVO();
               occDesc.setOccNumber("I" + i);
               occDesc.setOccValue(rs.getInt("I" + i));
               descList.add(occDesc);

            }

            occ.setOccValueList(descList);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return occ;
   }

   // 108개의 설문에 질문 insert
   public int insertOccupation(OccupationVO occ) {

      int res = 0;
      String q = "";

      for (int i = 0; i <= 107; i++) {

         q += "?, ";
      }

      Connection conn = getConnection();

      PreparedStatement st;

      String sql = "INSERT INTO TB_OCCUPATION  ";
      sql += "VALUES(" + q + " ?)";

      System.out.println(sql);

      try {
         st = conn.prepareStatement(sql);

         st.setString(1, occ.getId());

        for (int i = 0; i <= 107; i++) {

            int value = occ.getOccValueList().get(i).getOccValue();

            st.setInt(i + 2, value);
            System.out.println(i + 2 + " : value : " + value);

         }

         res = st.executeUpdate();

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         res = 0;
         e.printStackTrace();
      }

      return res;
   }

   // 설문을 안했을시 테이블에 이름이 남지않아 완성하지 못한 설문으로 가게 해주는 로직
   public boolean isSurveyComple108(String id) {

      boolean res = false;
      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      try {
         st = conn.prepareStatement("SELECT ID FROM TB_OCCUPATION WHERE ID=? ");
         st.setString(1, id);
         rs = st.executeQuery();

         if (rs.next()) {

            res = true;

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return res;
   }

   // TB_OCCUPATION_DESC 오름차순으로 정렬
   public ArrayList<OccupationDescVO> getOccupation108List() {

      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      ArrayList<OccupationDescVO> descList = new ArrayList<OccupationDescVO>();

      try {
         st = conn.prepareStatement("SELECT * FROM TB_OCCUPATION_DESC ORDER BY OCCNUMBER ASC");
         rs = st.executeQuery();

         while (rs.next()) {

            OccupationDescVO occDesc = new OccupationDescVO();
            occDesc.setOccNumber(rs.getString("OCCNUMBER"));
            occDesc.setOccName(rs.getString("OCCNAME"));
            descList.add(occDesc);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return descList;
   }

   // 모든 사용자들의 108개 직업에 대한 점수
   public ArrayList<OccupationVO> getAllOccupationList() {

      // TODO Auto-generated method stub
      Connection conn = getConnection();

      ResultSet rs = null;
      PreparedStatement st;

      ArrayList<OccupationVO> allList = new ArrayList<OccupationVO>();

      try {
         st = conn.prepareStatement("SELECT * FROM TB_OCCUPATION");
         rs = st.executeQuery();

         while (rs.next()) {

            OccupationVO occ = new OccupationVO();
            ArrayList<OccupationDescVO> descList = new ArrayList<OccupationDescVO>();

            for (int i = 1; i <= 108; i++) {

               OccupationDescVO occDesc = new OccupationDescVO();
               occDesc.setOccNumber("I" + i);
               occDesc.setOccValue(rs.getInt("I" + i));
               descList.add(occDesc);

            }

            occ.setId(rs.getString("ID"));
            occ.setOccValueList(descList);
            allList.add(occ);

         }

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return allList;
   }

   public int createServey(HttpServletRequest req) {

      int res = 0;
      OccupationVO likingOcc = new OccupationVO();
      likingOcc.setId(req.getSession().getAttribute("memberId").toString());

      OccupationVO compOcc = new OccupationVO();
      compOcc.setId(req.getSession().getAttribute("memberId").toString());

      ArrayList<OccupationDescVO> likingDescList = new ArrayList<OccupationDescVO>();
      ArrayList<OccupationDescVO> compDescList = new ArrayList<OccupationDescVO>();

      for (int i = 1; i <= 40; i++) {

         OccupationDescVO occDesc = new OccupationDescVO();
         occDesc.setOccNumber("L" + i);
         occDesc.setOccValue(Integer.valueOf(req.getParameter("L" + i)));
         likingDescList.add(occDesc);

         System.out.println(i + " Value : " + occDesc.getOccValue());

      }

      for (int i = 1; i <= 40; i++) {

         OccupationDescVO occDesc = new OccupationDescVO();
         occDesc.setOccNumber("C" + i);
         occDesc.setOccValue(Integer.valueOf(req.getParameter("C" + i)));
         compDescList.add(occDesc);

         System.out.println(i + " Value : " + occDesc.getOccValue());

      }

      likingOcc.setOccValueList(likingDescList);
      compOcc.setOccValueList(compDescList);

      res = OccupationDAO.getInstance().insertLikingOccupation(likingOcc);
      res = OccupationDAO.getInstance().insertCompOccupation(compOcc);

      return res;

   }
   
   //like,competence설문에서 로그아웃시  108 Occupation 데이터 삭제 
   public int deleteOccupation(String id) {

      int res = 0;

      Connection conn = getConnection();

      PreparedStatement st;

      try {
         st = conn.prepareStatement("DELETE FROM TB_OCCUPATION WHERE ID=? ");
         st.setString(1, id);
         res = st.executeUpdate();

         dbClose();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         res = 0;
         e.printStackTrace();
      }

      return res;
   }

   

}