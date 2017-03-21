package board;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class BoardVO {  // board 테이블 레코드 .
	private int seq;
	private String title;
	private String contents;
	private String writer;
	private String time;
	private int password;
	private int review;
	MultipartFile file1;
	MultipartFile file2;
	
	
	public BoardVO(){}

	
	public BoardVO(int seq, String title, String contents, String writer, String time, int password, int review,
			MultipartFile file1, MultipartFile file2) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.time = time;
		this.password = password;
		this.review = review;
		this.file1 = file1;
		this.file2 = file2;
	}

	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public MultipartFile getFile2() {
		return file2;
	}
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
	public int getSeq() {
		return seq;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public String getWriter() {
		return writer;
	}

	public String getTime() {
		return time;
	}

	public int getPassword() {
		return password;
	}
	
	public String getPassal() {
		String result = String.valueOf(this.password);
		for(int i = 0; i< result.length(); i++)
		{
			result = result.replace(result.charAt(i),'*');
		}
		return result;
	}

	public int getReview() {
		return review;
	}
	
	@Override
	public String toString() {
		return  "게시물 번호 : "+seq +"\t제목 :"+ title +"\t내용:"+ contents +"\t작성자:"
				+ writer +"\t작성시간:"+ time +"\t비밀번호:"+ password +"\t조회수:"+ review +"\n";
	}

	

}