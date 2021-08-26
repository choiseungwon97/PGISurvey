package com.survey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.survey.domain.MemberVO;

import util.CommonDao;

public class MemberDAO extends CommonDao {

	private static MemberDAO instance;

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public boolean loginCheck(String no, String pass) {

		boolean res = false;

		Connection conn = getConnection();

		ResultSet rs = null;
		PreparedStatement st;

		try {
			st = conn.prepareStatement("SELECT ID FROM TB_MEMBER WHERE ID=? AND PASSWORD =?");
			st.setString(1, no);
			st.setString(2, pass);
			rs = st.executeQuery();

			if (rs.next()) {

				res = true;
				return res;
			}

			dbClose();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;

	}

	public ArrayList<MemberVO> getMemberList(int cpp, int page, String srch_type, String srch_keyword) {

		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();

		Connection conn = getConnection();

		ResultSet rs = null;
		PreparedStatement st;

		System.out.println("CPP: " + cpp);
		System.out.println("page: " + page);

		String sql = "SELECT * FROM (SELECT t1.*, ceil(rownum/?) as page FROM "
				+ "(SELECT ID, PASSWORD, NAME, IDNUMBER, GENDER, "
				+ "      AGE, ETHNICBG,MAJOR, JOB, FJOB, MJOB  FROM TB_MEMBER";
		sql += " ORDER BY NAME DESC) t1) WHERE page = ?";

		try {

			System.out.println(sql);
			st = conn.prepareStatement(sql);
			st.setInt(1, cpp);
			st.setInt(2, page);
			rs = st.executeQuery();

			while (rs.next()) {

				MemberVO member = new MemberVO();

				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setFirstName(rs.getString("FIRSTNAME"));
				member.setLastName(rs.getString("LASTNAME"));
				// member.setIdNumber(rs.getInt("IDNUMBER"));
				member.setGender(rs.getString("GENDER").charAt(0));
				member.setAge(rs.getInt("AGE"));
				member.setEthnicBg(rs.getInt("ETHNICBG"));
				member.setMajor(rs.getString("MAJOR"));
				member.setJob(rs.getString("JOB"));
				member.setfJob(rs.getString("FJOB"));
				member.setmJob(rs.getString("MJOB"));

				memberList.add(member);

			}

			dbClose();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberList;
	}

	public MemberVO getMemberInfo(String id) {

		MemberVO member = new MemberVO();

		Connection conn = getConnection();

		ResultSet rs = null;
		PreparedStatement st;

		try {
			st = conn.prepareStatement("SELECT * FROM TB_MEMBER WHERE ID=? ");
			st.setString(1, id);
			rs = st.executeQuery();

			if (rs.next()) {

				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setFirstName(rs.getString("FIRSTNAME"));
				member.setLastName(rs.getString("LASTNAME"));
				// member.setIdNumber(rs.getInt("IDNUMBER"));
				member.setGender(rs.getString("GENDER").charAt(0));
				member.setAge(rs.getInt("AGE"));
				member.setEthnicBg(rs.getInt("ETHNICBG"));
				member.setMajor(rs.getString("MAJOR"));
				member.setJob(rs.getString("JOB"));
				member.setfJob(rs.getString("FJOB"));
				member.setmJob(rs.getString("MJOB"));

			}

			dbClose();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}

	public int updateMember(MemberVO member) {

		int res = 0;

		Connection conn = getConnection();

		PreparedStatement st;

		/*
		 * PASSWORD IDNUMBER GENDER AGE ETHNICBG MAJOR JOB FJOB MJOB NAME
		 */

		String sql = "UPDATE TB_MEMBER SET FIRSTNAME=?, PASSWORD=?, LASTNAME=?, GENDER=?, "
				+ "AGE=?, ETHNICBG=?, MAJOR=?, JOB=?, FJOB=?, MJOB=?   " + "WHERE ID=? ";

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, member.getFirstName());
			st.setString(2, member.getPassword());
			st.setString(3, member.getLastName());
			st.setString(4, String.valueOf(member.getGender()));
			st.setInt(5, member.getAge());
			st.setInt(6, member.getEthnicBg());
			st.setString(7, member.getMajor());
			st.setString(8, member.getJob());
			st.setString(9, member.getfJob());
			st.setString(10, member.getmJob());
			st.setString(11, member.getId());

			res = st.executeUpdate();

			dbClose();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = 0;
			e.printStackTrace();
		}

		return res;
	}

	public int deleteMember(String id) {

		int res = 0;

		Connection conn = getConnection();

		PreparedStatement st;

		try {
			st = conn.prepareStatement("DELETE FROM TB_MEMBER WHERE ID=? ");
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

	public int createMember(MemberVO member) {

		int res = 0;

		Connection conn = getConnection();

		PreparedStatement st;

		String sql = "INSERT INTO TB_MEMBER ( ID, FIRSTNAME, PASSWORD, LASTNAME, GENDER, AGE, ETHNICBG, MAJOR, JOB, FJOB, MJOB  )"
				+ "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			st = conn.prepareStatement(sql);

			st.setString(1, member.getId());
			st.setString(2, member.getFirstName());
			st.setString(3, member.getPassword());
			st.setString(4, member.getLastName());
			st.setString(5, String.valueOf(member.getGender()));
			st.setInt(6, member.getAge());
			st.setInt(7, member.getEthnicBg());
			st.setString(8, member.getMajor());
			st.setString(9, member.getJob());
			st.setString(10, member.getfJob());
			st.setString(11, member.getmJob());

			res = st.executeUpdate();

			dbClose();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = 0;
			e.printStackTrace();
		}

		return res;
	}

	public int getMemberCnt() {

		int cnt = 0;

		Connection conn = getConnection();

		ResultSet rs = null; //
		PreparedStatement st;

		try {
			st = conn.prepareStatement("SELECT COUNT(*) AS CNT FROM TB_MEMBER");
			rs = st.executeQuery(); //

			if (rs.next()) {

				cnt = rs.getInt("CNT");
				System.out.println("cnt" + cnt);

			}

			dbClose();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cnt;
	}

	// 회원 가입
	public void insertMember(MemberVO member) {

		/*
		 * TB_MEMBER
		 * 
		 * ID VARCHAR2(500) NOT NULL, PASSWORD VARCHAR2(250) NOT NULL, GENDER
		 * CHAR(1) DEFAULT 'M' NOT NULL, AGE NUMBER NULL, ETHNICBG NUMBER NULL,
		 * MAJOR VARCHAR2(250) NULL, JOB VARCHAR2(250) NULL, FJOB VARCHAR2(250)
		 * NULL, MJOB VARCHAR2(250) NULL, FIRSTNAME VARCHAR2(200) NULL, LASTNAME
		 * VARCHAR2(100) NULL,
		 * 
		 */
		String sql = "INSERT INTO TB_MEMBER"
				+ " ( ID, FIRSTNAME, PASSWORD, LASTNAME, GENDER, AGE, ETHNICBG, MAJOR, JOB, FJOB, MJOB)"
				+ " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = getConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getFirstName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getLastName());
			pstmt.setString(5, String.valueOf(member.getGender()));
			pstmt.setInt(6, member.getAge());
			pstmt.setInt(7, member.getEthnicBg());
			pstmt.setString(8, member.getMajor());
			pstmt.setString(9, member.getJob());
			pstmt.setString(10, member.getfJob());
			pstmt.setString(11, member.getmJob());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			dbClose();

		}

	}

	// ID 중복체크
	public int confirmID(String memberId) {

		int result = -1;

		String sql = "select id from tb_member where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				result = 1;

			} else {

				result = -1;

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return result;

	}

}