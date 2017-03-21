package board;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component // @Repository 와 동일
public class BoardDAO {

	@Autowired
	BoardVO vo;

	String filepath = "/Users/woong/Desktop/boardupload/";
	MultipartFile file2;
	MultipartFile file1;
	File f1;
	File f2;
	Scanner scan1;
	Scanner scan2;

	public int getBoardCount() {
		Connection con = null;
		int count = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			String sql = "select count(*) as c from board";

			PreparedStatement pt = con.prepareStatement(sql);

			ResultSet rs = pt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("c");
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
		return count;
	}

	public BoardVO getDetail(int seq) {
		BoardVO boardtemp = null;

		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			String up = "update board set review = review + 1 where num = ?";
			String sql = "select * from board where num = ? ";

			PreparedStatement pt = con.prepareStatement(up);
			pt.setInt(1, seq);
			pt.executeUpdate();

			pt = con.prepareStatement(sql);
			pt.setInt(1, seq);

			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				boardtemp = new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), null, null);
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

		return boardtemp;
	}

	public ArrayList<BoardVO> getBoardList(int pageNum) {
		ArrayList<BoardVO> boardtemp = new ArrayList<BoardVO>();

		Connection con = null;
		try {
			// con.setAutoCommit(false); // 자동 커밋 해제 문 con.commit , con.rollback
			// 으로 설정 및 해제
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String sql = "select r, num,title,content,writer,wri_date,passwd,review,file1,file2 "
					+ "from (select rownum r, b.* " + "from (select * from board " + "order by wri_date desc) b) e "
					+ "where r between ? and ?";

			PreparedStatement pt = con.prepareStatement(sql);
			int pn = ((pageNum - 1) * 5) + 1;
			int rp = 5 * pageNum;
			pt.setInt(1, pn);
			pt.setInt(2, rp);

			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				try {

					FileInputStream f1 = new FileInputStream(filepath + rs.getString(9));
					FileInputStream f2 = new FileInputStream(filepath + rs.getString(10));

				} catch (IOException e) {
				}
				BoardVO bv = new BoardVO(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), file1, file2);
				boardtemp.add(bv);
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

		return boardtemp;
	}

	public boolean insertBoard(BoardVO vo) {

		boolean val = false;
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String sql = "insert into board values(snum.nextval,?,?,?,DEFAULT,?,DEFAULT,?,?)";

			PreparedStatement pt = con.prepareStatement(sql);

			pt.setString(1, vo.getTitle());
			pt.setString(2, vo.getContents());
			pt.setString(3, vo.getWriter());
			pt.setInt(4, vo.getPassword());
			pt.setString(5, vo.getFile1().getOriginalFilename());
			pt.setString(6, vo.getFile1().getOriginalFilename());

			pt.executeUpdate();

			val = true;
			return val;

		} catch (Exception e) {
			System.out.println("드라이버가 발견되지 않았습니다");
			return val;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

	public boolean updateBoard(BoardVO vo) {

		Connection con = null;
		boolean is = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String title = vo.getTitle();
			String contents = vo.getContents();
			String writer = vo.getWriter();
			int password = vo.getPassword();

			String str = "update board " + "set title =?,content=?,writer=?,passwd=?,wri_date=sysdate "
					+ "where num = ?";

			PreparedStatement pt1 = con.prepareStatement(str);

			pt1.setString(1, title); // 제목

			pt1.setString(2, contents); // 내용

			pt1.setString(3, writer); // 작성자

			pt1.setInt(4, password); // 패스워드

			pt1.setInt(5, vo.getSeq()); // 게시물번호

			pt1.executeUpdate();

			is = true;
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

		return is;
	}

	public boolean deleteBoard(int seq) {
		Connection con = null;
		boolean is = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String str = "delete board where num =?";
			PreparedStatement pt1 = con.prepareStatement(str);
			pt1.setInt(1, seq);
			pt1.executeUpdate();
			is = true;

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

		return is;
	}

	public boolean checkPassword(int seq, int password) {

		Connection con = null;
		boolean ck = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String check = "select passwd from board where num = ?";
			PreparedStatement pt = con.prepareStatement(check);

			pt.setInt(1, seq);
			ResultSet rs = pt.executeQuery();

			if (rs.next()) {
				if (rs.getInt(1) == password) {
					ck = true;
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
		return ck;
	}

}