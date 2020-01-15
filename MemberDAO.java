package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO {

	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "ca2";
	public static final String PASSWORD = "ca2";

	public MemberDAO() {
		try {
			Class.forName(DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(MemberDTO dto) {

		Connection conn = null;
		PreparedStatement pt = null;
		String sql = "insert into member2(id,name,age)values(?,?,?)";

		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pt = conn.prepareStatement(sql);
			pt.setString(1, dto.getId());
			pt.setString(2, dto.getName());
			pt.setInt(3, dto.getAge());
			pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pt != null) {
					pt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
