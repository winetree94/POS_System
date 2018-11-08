package com.pos.system.dto;

import java.util.Date;

public class Service_File_DTO {
	
	private int file_seq;
	private int board_seq;
	private String origin_fname;
	private String stored_fname;
	private int file_size;
	private Date regdate;
	private String delflag;
	
	
	public Service_File_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Service_File_DTO(int file_seq, int board_seq, String origin_fname, String stored_fname, int file_size,
			Date regdate, String delflag) {
		super();
		this.file_seq = file_seq;
		this.board_seq = board_seq;
		this.origin_fname = origin_fname;
		this.stored_fname = stored_fname;
		this.file_size = file_size;
		this.regdate = regdate;
		this.delflag = delflag;
	}


	@Override
	public String toString() {
		return "Service_File_DTO [file_seq=" + file_seq + ", board_seq=" + board_seq + ", origin_fname=" + origin_fname
				+ ", stored_fname=" + stored_fname + ", file_size=" + file_size + ", regdate=" + regdate + ", delflag="
				+ delflag + "]";
	}


	public int getFile_seq() {
		return file_seq;
	}


	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}


	public int getBoard_seq() {
		return board_seq;
	}


	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}


	public String getOrigin_fname() {
		return origin_fname;
	}


	public void setOrigin_fname(String origin_fname) {
		this.origin_fname = origin_fname;
	}


	public String getStored_fname() {
		return stored_fname;
	}


	public void setStored_fname(String stored_fname) {
		this.stored_fname = stored_fname;
	}


	public int getFile_size() {
		return file_size;
	}


	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public String getDelflag() {
		return delflag;
	}


	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	
	
}
