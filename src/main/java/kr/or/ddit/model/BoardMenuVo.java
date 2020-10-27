package kr.or.ddit.model;

public class BoardMenuVo {

	private int boardmenu_seq;
	private String board_name;
	private String board_delete;
	public int getBoardmenu_seq() {
		return boardmenu_seq;
	}
	public void setBoardmenu_seq(int boardmenu_seq) {
		this.boardmenu_seq = boardmenu_seq;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_delete() {
		return board_delete;
	}
	public void setBoard_delete(String board_delete) {
		this.board_delete = board_delete;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board_delete == null) ? 0 : board_delete.hashCode());
		result = prime * result + ((board_name == null) ? 0 : board_name.hashCode());
		result = prime * result + boardmenu_seq;
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
		BoardMenuVo other = (BoardMenuVo) obj;
		if (board_delete == null) {
			if (other.board_delete != null)
				return false;
		} else if (!board_delete.equals(other.board_delete))
			return false;
		if (board_name == null) {
			if (other.board_name != null)
				return false;
		} else if (!board_name.equals(other.board_name))
			return false;
		if (boardmenu_seq != other.boardmenu_seq)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardMenuVo [boardmenu_seq=" + boardmenu_seq + ", board_name=" + board_name + ", board_delete="
				+ board_delete + "]";
	}
	
	
	
	
}
