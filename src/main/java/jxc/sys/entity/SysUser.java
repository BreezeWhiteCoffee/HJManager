package jxc.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;
	private String salt;
	private String gender;
	private Integer age;
	private String mobile;
	private Integer salary;
	private Integer storeId;
	private Date createTime;
	private Date modifiedTime;
	private SysRole sysRole;
	
	public SysRole getSysRole() {
		return sysRole;
	}
	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", gender=" + gender + ", age=" + age + ", mobile=" + mobile + ", salary=" + salary + ", storeId="
				+ storeId + ", createTime=" + createTime + ", modifiedTime=" + modifiedTime + ", sysRole=" + sysRole
				+ "]";
	}
	
	
	
	
	
	
}
