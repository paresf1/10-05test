package kr.or.ddit.model;

import java.util.Date;

public class ReplyVo {
	
	private int reply_seq    ;
	private String reply_content;
	private String reply_delete ;
	private Date create_date  ;
	private String user_id      ;
	private int board_seq    ;
	
	public int getReply_seq() {
		return reply_seq;
	}
	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_delete() {
		return reply_delete;
	}
	public void setReply_delete(String reply_delete) {
		this.reply_delete = reply_delete;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_seq;
		result = prime * result + ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result + ((reply_content == null) ? 0 : reply_content.hashCode());
		result = prime * result + ((reply_delete == null) ? 0 : reply_delete.hashCode());
		result = prime * result + reply_seq;
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyVo other = (ReplyVo) obj;
		if (board_seq != other.board_seq)
			return false;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (reply_content == null) {
			if (other.reply_content != null)
				return false;
		} else if (!reply_content.equals(other.reply_content))
			return false;
		if (reply_delete == null) {
			if (other.reply_delete != null)
				return false;
		} else if (!reply_delete.equals(other.reply_delete))
			return false;
		if (reply_seq != other.reply_seq)
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
	
	
}
