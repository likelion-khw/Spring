package board.servlet;

public class ReplyVO {
	String nickname;
	String contents;
	
	public ReplyVO(String nickname, String contents) {
		super();
		this.nickname = nickname;
		this.contents = contents;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	

}
