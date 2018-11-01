package jxc.sys.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * POJO:
 * 1)封装数据(客户端表单数据,服务端表中数据)
 * 2)数据传递(dao<-->controller)
 * @author ta
 */
public class SysRole implements Serializable{
	private static final long serialVersionUID = -2113802202295967078L;
	private Integer roleId;
	private String note;
	private String permission;
	private String name;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "SysRole [roleId=" + roleId + ", note=" + note + ", permission=" + permission + ", name=" + name + "]";
	}
	
	
}
