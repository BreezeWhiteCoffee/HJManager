package jxc.sys.entity;

import java.math.BigDecimal;

public class UnmarketInfo {
	private String articleNumber;//货号
	private BigDecimal buyPrice;//进货价
	private BigDecimal salePrice;//定价
	private String Purchasetime;//入库时间
	private Integer num;//销量
	public String getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getPurchasetime() {
		return Purchasetime;
	}
	public void setPurchasetime(String purchasetime) {
		Purchasetime = purchasetime;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
