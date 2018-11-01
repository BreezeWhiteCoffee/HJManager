package jxc.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysEmployee implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String employeename;
	private String articleNumber;
	private Date createTime;
	private Double money;
	private Integer amount;
	private Integer storeId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getemployeename() {
		return employeename;
	}
	public void setemployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	@Override
	public String toString() {
		return "SysEmployee [id=" + id + ", employeename=" + employeename + ", articleNumber=" + articleNumber
				+ ", createTime=" + createTime + ", money=" + money + ", amount=" + amount + ", storeId=" + storeId
				+ "]";
	}
	
	
	
	
	
	
}
