package kpu.web.club.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kpu.web.club.domain.QuestionnaireVO;


public class QuestionnaireDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "passwd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean add(QuestionnaireVO vo) {
		connect();
		String sql = "insert into questionnaire (name, tel, birth, sex, Q1, Q2, Q3) values (?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getBirth());
			pstmt.setString(4, vo.getSex());
			pstmt.setBoolean(5, vo.getQ1());
			pstmt.setBoolean(6, vo.getQ2());
			pstmt.setBoolean(7, vo.getQ3());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<QuestionnaireVO> getUserlist(String name, String tel) {
		connect();
		ArrayList<QuestionnaireVO> userList = new ArrayList<QuestionnaireVO>();
		String sql = "select * from questionnaire where name = ? and tel = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionnaireVO vo = new QuestionnaireVO();
				vo.setNo(rs.getString("no"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setBirth(rs.getString("birth"));
				vo.setSex(rs.getString("sex"));
				if(rs.getString("Q1").equals("1")) {
					vo.setQ1(true);
				}else {
					vo.setQ1(false);
				}
				if(rs.getString("Q2").equals("1")) {
					vo.setQ2(true);
				}else {
					vo.setQ2(false);
				}
				if(rs.getString("Q3").equals("1")) {
					vo.setQ3(true);
				}else {
					vo.setQ3(false);
				}
				vo.setRegister_date(rs.getString("register_date"));
				userList.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return userList;
	}
	
	public ArrayList<QuestionnaireVO> getAllUserlist(){
		connect();
		ArrayList<QuestionnaireVO> userList = new ArrayList<QuestionnaireVO>();
		String sql = "select * from questionnaire";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionnaireVO vo = new QuestionnaireVO();
				vo.setNo(rs.getString("no"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setBirth(rs.getString("birth"));
				vo.setSex(rs.getString("sex"));
				if(rs.getString("Q1").equals("1")) {
					vo.setQ1(true);
				}else {
					vo.setQ1(false);
				}
				if(rs.getString("Q2").equals("1")) {
					vo.setQ2(true);
				}else {
					vo.setQ2(false);
				}
				if(rs.getString("Q3").equals("1")) {
					vo.setQ3(true);
				}else {
					vo.setQ3(false);
				}
				vo.setRegister_date(rs.getString("register_date"));
				userList.add(vo);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return userList;
	}
	
	public QuestionnaireVO read(String no) {
		connect();
		QuestionnaireVO user = new QuestionnaireVO();
		String sql = "select * from questionnaire where no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setName(rs.getString("name"));
				user.setTel(rs.getString("tel"));
				user.setBirth(rs.getString("birth"));
				user.setSex(rs.getString("sex"));
				if(rs.getString("Q1").equals("1")) {
					user.setQ1(true);
				}else {
					user.setQ1(false);
				}
				if(rs.getString("Q2").equals("1")) {
					user.setQ2(true);
				}else {
					user.setQ2(false);
				}
				if(rs.getString("Q3").equals("1")) {
					user.setQ3(true);
				}else {
					user.setQ3(false);
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user;
	}
	
	public boolean update(QuestionnaireVO vo) {
		connect();
		return true;
	}
	
	public boolean deleteHistory() {
		connect();
		String sql = "delete from questionnaire";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<QuestionnaireVO> getSortedUser(){
		connect();
		ArrayList<QuestionnaireVO> userList = new ArrayList<QuestionnaireVO>();
		String sql = "select * from questionnaire where Q1 = 1 or Q2 = 1 or Q3 = 1";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionnaireVO vo = new QuestionnaireVO();
				vo.setNo(rs.getString("no"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setBirth(rs.getString("birth"));
				vo.setSex(rs.getString("sex"));
				if(rs.getString("Q1").equals("1")) {
					vo.setQ1(true);
				}else {
					vo.setQ1(false);
				}
				if(rs.getString("Q2").equals("1")) {
					vo.setQ2(true);
				}else {
					vo.setQ2(false);
				}
				if(rs.getString("Q3").equals("1")) {
					vo.setQ3(true);
				}else {
					vo.setQ3(false);
				}
				vo.setRegister_date(rs.getString("register_date"));
				userList.add(vo);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return userList;
	}
	
	
}
