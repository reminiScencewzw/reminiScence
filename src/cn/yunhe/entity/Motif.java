package cn.yunhe.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 	主题实体类
 */
public class Motif implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主题ID
	 */
	private int id;
	/**
	 * 主题名称
	 */
	private String motif;
	/**
	 * 创建时间
	 */
	private Date create_date;
	
	/**
	 * 主题状态0已删除 1正常
	 */
	private String state;
	
	public Motif() {}

	public Motif(int id, String motif) {
		super();
		this.id = id;
		this.motif = motif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Motif [id=" + id + ", motif=" + motif + ", create_date=" + create_date + "]";
	}
}
