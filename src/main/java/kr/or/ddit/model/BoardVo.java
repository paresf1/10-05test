package kr.or.ddit.model;

import java.util.Date;

public class BoardVo {

	private String board_title       ;
	private String board_content     ;
	private int board_seq         ;
	private String board_delete      ;
	private Date create_date       ;
	private int boardmenu_seq     ;
	private int board_parent_seq  ;
	private String user_id           ;
	private int page ;
	private int pageSize ;
	private int boardlevel;
	

	public int getBoardlevel() {
		return boardlevel;
	}
	public void setBoardlevel(int boardlevel) {
		this.boardlevel = boardlevel;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_delete() {
		return board_delete;
	}
	public void setBoard_delete(String board_delete) {
		this.board_delete = board_delete;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getBoardmenu_seq() {
		return boardmenu_seq;
	}
	public void setBoardmenu_seq(int boardmenu_seq) {
		this.boardmenu_seq = boardmenu_seq;
	}
	public int getBoard_parent_seq() {
		return board_parent_seq;
	}
	public void setBoard_parent_seq(int board_parent_seq) {
		this.board_parent_seq = board_parent_seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board_content == null) ? 0 : board_content.hashCode());
		result = prime * result + ((board_delete == null) ? 0 : board_delete.hashCode());
		result = prime * result + board_parent_seq;
		result = prime * result + board_seq;
		result = prime * result + ((board_title == null) ? 0 : board_title.hashCode());
		result = prime * result + boardlevel;
		result = prime * result + boardmenu_seq;
		result = prime * result + ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result + page;
		result = prime * result + pageSize;
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
		BoardVo other = (BoardVo) obj;
		if (board_content == null) {
			if (other.board_content != null)
				return false;
		} else if (!board_content.equals(other.board_content))
			return false;
		if (board_delete == null) {
			if (other.board_delete != null)
				return false;
		} else if (!board_delete.equals(other.board_delete))
			return false;
		if (board_parent_seq != other.board_parent_seq)
			return false;
		if (board_seq != other.board_seq)
			return false;
		if (board_title == null) {
			if (other.board_title != null)
				return false;
		} else if (!board_title.equals(other.board_title))
			return false;
		if (boardlevel != other.boardlevel)
			return false;
		if (boardmenu_seq != other.boardmenu_seq)
			return false;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardVo [board_title=" + board_title + ", board_content=" + board_content + ", board_seq=" + board_seq
				+ ", board_delete=" + board_delete + ", create_date=" + create_date + ", boardmenu_seq=" + boardmenu_seq
				+ ", board_parent_seq=" + board_parent_seq + ", user_id=" + user_id + ", page=" + page + ", pageSize="
				+ pageSize + "]";
	}

	
	
}
