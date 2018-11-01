package jxc.common.vo;

import java.io.Serializable;

/**
 * VO对象：封装checkbox相关信息
 * @author ta
 */
public class CheckBox implements Serializable{
	private static final long serialVersionUID = -224148797542502698L;
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CheckBox [id=" + id + ", name=" + name + "]";
	}
	
}
