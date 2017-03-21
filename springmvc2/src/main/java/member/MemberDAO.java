package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	public String membercheck(String userid, String password) {
		String result = "idno";
		MemberVO mvo = null;

		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.55:1521:xe", "hr", "hr");

			String idck = "select * from member where userid = ?";

			PreparedStatement pt = con.prepareStatement(idck);
			pt.setString(1, userid);
			ResultSet rs = pt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(userid)) {
					mvo = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6),
							rs.getString(7), rs.getString(8));
					if (mvo.getPassword().equals(password)) {
						result = "pass";
					} else
						result = "pwdno";
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 발견되지 않았습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}

		return result;
	}

}
