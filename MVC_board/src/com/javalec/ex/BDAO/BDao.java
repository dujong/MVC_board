package com.javalec.ex.BDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.BDTO.BDto;

public class BDao {
	
	DataSource dataSource;
	public BDao() {
		try {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
	}catch (Exception e) {
		e.printStackTrace();
		
		}
	}
	
	
	public void write(String BName, String BTitle, String BContent) {
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into MVC_board (BId, BName, BTitle, BContent, BHit, BGroup, BStep, BIndent) values(MVC_board_seq.nextval, ?, ?, ?, 0, MVC_board_seq.currval,0,0)";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, BName);
			stmt.setString(2, BTitle);
			stmt.setString(3, BContent);
			int ri = stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
			
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select BId, BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent from MVC_board order by BGroup desc, BStep asc";
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				int BId = rs.getInt("BId");
				String BName = rs.getString("BName");
				String BTitle = rs.getString("BTitle");
				String BContent = rs.getString("BContent");
				Timestamp BDate = rs.getTimestamp("BDate");
				int BHit = rs.getInt("BHit");
				int BGroup = rs.getInt("BGroup");
				int BStep = rs.getInt("BStep");
				int BIndent = rs.getInt("BIndent");
				
				BDto dto = new BDto(BId, BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent);
				dtos.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	public BDto contentView(String strID) {
		
		if(strID == null)
			System.out.println("포기하지 않아요");
		
		upHit(strID);
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from MVC_board where BId = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strID));
			resultset = pstmt.executeQuery();
			
			if(resultset.next())
			{
				int BId = resultset.getInt("BId");
				String BName = resultset.getString("BName");
				String BTitle = resultset.getString("BTitle");
				String BContent = resultset.getString("BContent");
				Timestamp BDate = resultset.getTimestamp("BDate");
				int BHit = resultset.getInt("BHit");
				int BGroup = resultset.getInt("BGroup");
				int BStep = resultset.getInt("BStep");
				int BIndent = resultset.getInt("BIndent");
				
				dto = new BDto(BId,BName, BTitle, BContent, BDate, BHit, BGroup, BStep, BIndent);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
			if(resultset != null) resultset.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
			
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
		
	}
	
	private void upHit(String BId) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update MVC_board set BHit = BHit+1 where BId = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, BId);
			int ri = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
				
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void Modify(String BName, String BTitle, String BContent, String BId) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update MVC_board set BName = ?, BTitle = ? ,BContent = ? where BId = ?";
			
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, BName);
			pstmt.setString(2,BTitle);
			pstmt.setString(3, BContent);
			pstmt.setInt(4, Integer.parseInt(BId));
			int ri = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
				
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void delete(String BId) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		
		try {
			
			connection = dataSource.getConnection();
			String query = "delete from MVC_board where BId = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(BId));
			int ri = pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			}catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public BDto reply_view(String StrBID) {
		BDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			
			connection = dataSource.getConnection();
			String query = "select * from MVC_board where BId = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1,Integer.parseInt(StrBID));
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next())
			{
				int BId = resultset.getInt("BId");
				String BName = resultset.getString("BName");
				String BTitle = resultset.getString("BTitle");
				String BContent = resultset.getString("BContent");
				Timestamp BDate = resultset.getTimestamp("BDate");
				int BHit = resultset.getInt("BHit");
				int BGroup = resultset.getInt("BGroup");
				int BStep = resultset.getInt("BStep");
				int BIndent = resultset.getInt("BIndent");
				
				dto = new BDto(BId, BName,BTitle,BContent, BDate,BHit,BGroup,BStep,BIndent);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedstatement != null) preparedstatement.close();
				if(connection != null) connection.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public void reply(String BName, String BTitle, String BContent, String BGroup, String BStep, String BIndent) {
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			String query = "insert into MVC_board (BId, BName, BTitle, BContent, BGroup, BStep, BIndent) values(MVC_board_seq.nextval,?,?,?,?,?,?)";
			preparedstatement = connection.prepareStatement(query);
			
			preparedstatement.setString(1, BName);
			preparedstatement.setString(2, BTitle);
			preparedstatement.setString(3, BContent);
			preparedstatement.setInt(4, Integer.parseInt(BGroup));
			preparedstatement.setInt(5, Integer.parseInt(BStep)+1);
			preparedstatement.setInt(6, Integer.parseInt(BIndent)+1);
			
			int ri = preparedstatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		try {
			if(preparedstatement != null) preparedstatement.close();
			if(connection != null) connection.close();
		}catch (Exception e2) {
			e2.printStackTrace();
		}
	}
		
  }

	
	private void replyShape(String strGroup, String strStep) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update MVC_board set BStep = BStep + 1 where BGroup = ? and BStep > ?";
			preparedstatement = connection.prepareStatement(query);
			
			preparedstatement.setInt(1, Integer.parseInt(strGroup));
			preparedstatement.setInt(2, Integer.parseInt(strStep));
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedstatement != null) preparedstatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
