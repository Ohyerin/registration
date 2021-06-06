package registrations.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import registrations.dao.RegistrationDao;
import registrations.vo.Subject;

public class RegistrationDao {
	private static RegistrationDao dao = new RegistrationDao();
	private RegistrationDao() {}
	public static RegistrationDao getInstance() {
		return dao;
	}
	public Connection connect() 
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","hyerin453");
		}catch(Exception e)
		{
			System.out.println("MDAO:connect"+e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			}catch(Exception e)
			{
				System.out.print("PreparedStatement close error"+e);
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			}catch(Exception e)
			{
				System.out.print("Conn close error"+e);
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			}catch(Exception e)
			{
				System.out.print("rs close error"+e);
			}
		}
		close(conn,pstmt); 
	}
	public boolean Slogin(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt= conn.prepareStatement("select * from student where id =? and pwd =?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}
			else
			{
				result = false;
			}
			
		}catch(Exception e)
		{
			System.out.print("login error"+e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
		}
	
	public boolean Plogin(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt= conn.prepareStatement("select * from prof where id =? and pwd =?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}
			else
			{
				result = false;
			}
			
		}catch(Exception e)
		{
			System.out.print("login error"+e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}
		public void enrollSubject(Subject subject) {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement pstmt = null;
			try 
			{
				conn = connect();
				pstmt = conn.prepareStatement("insert into subject values(?,?,?,?);");
				pstmt.setString(1, subject.getId());
				pstmt.setString(2, subject.getName());
				pstmt.setString(3, subject.getCount()+"");
				pstmt.setString(4, subject.getProf());
				pstmt.executeUpdate();
				
			}catch(Exception e)
			{
				System.out.print("enroll error"+e);
			}
			finally
			{
				close(conn,pstmt);
			}
	}
}
