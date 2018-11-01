package jxc.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 这个类用于封装产品信息
 * @author Administrator
 *
 */
public class Product implements Serializable{
	private static final long serialVersionUID = 8394459164929887162L;
	private Integer  id;
	private String   articlenumber;
	private String   gender;
	private String   season;
	private Integer  size;
	private Double   price;
	private Double   saleprice;
	private String   color;
	private Date     Purchasetime;
	private Integer  amount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArticlenumber() {
		return articlenumber;
	}
	public void setArticlenumber(String articlenumber) {
		this.articlenumber = articlenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(Double saleprice) {
		this.saleprice = saleprice;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public Date getPurchasetime() {
		return Purchasetime;
	}
	public void setPurchasetime(Date purchasetime) {
		Purchasetime = purchasetime;
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
		return "Product [id=" + id + ", articlenumber=" + articlenumber + ", gender=" + gender + ", season=" + season
				+ ", size=" + size + ", price=" + price + ", saleprice=" + saleprice + ", color=" + color
				+ ", Purchasetime=" + Purchasetime + ", amount=" + amount+ "]";
	}
	
}
