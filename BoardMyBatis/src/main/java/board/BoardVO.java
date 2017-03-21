package board;

public class BoardVO {
	int num;
	String title;
	String content;
	String writer;
	String wri_date;
	int passwd;
	int review;
	String file1;
	String file2;
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWri_date() {
		return wri_date;
	}
	public void setWri_date(String wri_date) {
		this.wri_date = wri_date;
	}
	public int getPasswd() {
		return passwd;
	}
	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public String getFile2() {
		return file2;
	}
	public void setFile2(String file2) {
		this.file2 = file2;
	}
	
	@Override
	public String toString() {
		return "게시물번호=" + num + ", 제목=" + title + ", 내용=" + content + ", 작성자=" + writer
				+ ", 작성일=" + wri_date + ", 암호=" + passwd + ", 조회수=" + review + ", 파일1=" + file1
				+ ", 파일2=" + file2;
	}
	
}
