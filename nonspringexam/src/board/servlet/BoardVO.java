package board.servlet;

public class BoardVO {
	int seq;
	String title;
	String contents;
	String writer;
	ReplyVO reply;
	
	public BoardVO(int seq, String title, String contents, String writer)
	{
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public ReplyVO getReply() {
		return reply;
	}

	public void setReply(ReplyVO reply) {
		this.reply = reply;
	}
	
	public void setBoard(String title, String contents, String writer)
	{
		this.title =title;
		this.contents = contents;
		this.writer = writer;
	}
	
	

}
