package com.bit.myhome.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bit.myhome.vo.UserVO;

public class UserDaoimpl implements UserDao{
	private String dbuser = null;
	private String dbpass = null;
	
	public UserDaoimpl() {
		this.dbuser = "bituser";
		this.dbpass = "bituser";
	}
	
	public UserDaoimpl(String dbuser, String dbpass) {
		this.dbuser = dbuser;
		this.dbpass = dbpass;
	}
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	
	@Override
	public List<UserVO> getLiST() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<UserVO> list= new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT no, name, password, email, gender, created_at FROM users ORDER BY creatd_at DESC";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Long no = rs.getLong(1);
				String name =rs.getString(2);
				String passWord = rs.getString(3);
				String Email = rs.getString(4);
				String gender = rs.getString(5);
				Date createdAt = rs.getDate(6);
				
				UserVO vo = new UserVO(no, name, passWord, Email, gender, createdAt);
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean insert(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO users (no, name, password, email, gender) VALUES(seq_user_pk.nextval,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getGender());
			
			insertedCount = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}

		return insertedCount == 1;
	}

	@Override
	public boolean update(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "UPDATE users SET no=?, name=?, password=?, email=?, gender=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getGender());
			
			updatedCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		return updatedCount == 1;
	}

	@Override
	public boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		String sql = "DELETE FROM users WHERE no=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			deletedCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				
			}catch(Exception e) {
				
			}
		}
		
		return deletedCount == 1;
	}

	@Override
	public UserVO getUserByIdAndPassword(String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO vo =null;
		try {
			conn = getConnection();
			String sql = "SELECT no, name, password, email, gender, created_at FROM users WHERE email=? And password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Long no = rs.getLong(1);
				String name =rs.getString(2);
				String passWord = rs.getString(3);
				String Email = rs.getString(4);
				String gender = rs.getString(5);
				Date createdAt = rs.getDate(6);
				
				vo = new UserVO(no, name, passWord, Email, gender, createdAt);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch(Exception e) {
				
			}
		}
		return vo;
	}

}
