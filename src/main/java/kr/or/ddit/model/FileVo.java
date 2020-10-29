package kr.or.ddit.model;

public class FileVo {
	private String file_name     ;
	private String file_realname ;
	private int file_seq      ;
	private String file_delete   ;
	private int board_seq     ;
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_realname() {
		return file_realname;
	}
	public void setFile_realname(String file_realname) {
		this.file_realname = file_realname;
	}
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	public String getFile_delete() {
		return file_delete;
	}
	public void setFile_delete(String file_delete) {
		this.file_delete = file_delete;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	@Override
	public String toString() {
		return "FileVo [file_name=" + file_name + ", file_realname=" + file_realname + ", file_seq=" + file_seq
				+ ", file_delete=" + file_delete + ", board_seq=" + board_seq + "]";
	}
	
	
	
}
