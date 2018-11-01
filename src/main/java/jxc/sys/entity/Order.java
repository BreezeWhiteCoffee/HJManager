package jxc.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 这个类用于封装订单信息
 * @author Administrator
 *
 */
public class Order implements Serializable{
	private static final long serialVersionUID = -3338417281244330459L;
	private Integer id;
	private String  employeename;
	private String  articlenumber;
	private Date    createTime;
	private Double  money;
	private Integer amount;
	private Integer storeId;
	
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getArticlenumber() {
		return articlenumber;
	}
	public void setArticlenumber(String articlenumber) {
		this.articlenumber = articlenumber;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date creatTime) {
		this.createTime = creatTime;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", employeename=" + employeename + ", articlenumber=" + articlenumber
				+ ", creatTime=" + createTime + ", money=" + money + ", amount=" + amount + "]";
	}
	
}
