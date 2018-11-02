package com.pos.system.dto;

import java.sql.Timestamp;
import java.util.Date;

public class Service_Board_DTO {
	
	private int board_seq;
	private String service_id;
	private int readcount;
	private Timestamp regdate;
	private String title;
	private String content;
	private int ref;
	private int step;
	private int depth;
	private String type;
	private String delflag;
	
	@Override
	public String toString() {
		return "Service_Board_DTO{" +
			"board_seq=" + board_seq +
			", service_id='" + service_id + '\'' +
			", readcount=" + readcount +
			", regdate=" + regdate +
			", title='" + title + '\'' +
			", content='" + content + '\'' +
			", ref=" + ref +
			", step=" + step +
			", depth=" + depth +
			", type='" + type + '\'' +
			", delflag='" + delflag + '\'' +
			'}';
	}
	
	public int getBoard_seq() {
		return board_seq;
	}
	
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	
	public String getService_id() {
		return service_id;
	}
	
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	
	public int getReadcount() {
		return readcount;
	}
	
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	public Timestamp getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
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
	
	public int getRef() {
		return ref;
	}
	
	public void setRef(int ref) {
		this.ref = ref;
	}
	
	public int getStep() {
		return step;
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDelflag() {
		return delflag;
	}
	
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	public Service_Board_DTO() {
	}
	
	public Service_Board_DTO(int board_seq, String service_id, int readcount, Timestamp regdate, String title, String content, int ref, int step, int depth, String type, String delflag) {
		this.board_seq = board_seq;
		this.service_id = service_id;
		this.readcount = readcount;
		this.regdate = regdate;
		this.title = title;
		this.content = content;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.type = type;
		this.delflag = delflag;
	}
}
