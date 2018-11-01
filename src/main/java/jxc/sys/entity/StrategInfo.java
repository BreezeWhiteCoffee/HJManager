package jxc.sys.entity;
/**
 *此类用来封装销售策略的信息
 */
import java.math.BigDecimal;

public class StrategInfo {
	private String articleNumber;//货号
	private Integer num;//销售数量
	private BigDecimal buyPrice;//进货价
	private BigDecimal salePrice;//定价价
	
	private BigDecimal saleMoney;//销售额
	private BigDecimal profit;//利润
	public String getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public BigDecimal getSaleMoney() {
		return saleMoney;
	}
	public void setSaleMoney(BigDecimal saleMoney) {
		this.saleMoney = saleMoney;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
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

	
}  
