package jxc.common.vo;

import java.io.Serializable;
import java.util.Date;
/**
 * 用于封装数据的节点对象
 * 1)sys_menus (存储的是菜单信息)
 * 2)sys_role_menus(存储的是菜单和角色的关系数据)
 */
public class Node implements Serializable{
	private static final long serialVersionUID = 4351174414771192644L;
	/*private Integer id;*/
	/**节点id(例如门店id)*/
	private Integer storeId;
	/**节点名(例如门店具体信息)*/
	private String storeName;
	/**节点名(例如门店具体信息)*/
	private String storeAddress;
	
	private String storeTelephone;
	
	private Date createTime;
	
	private Date modifiedTime;
	
	
	public String getStoreTelephone() {
		return storeTelephone;
	}
	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
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
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@Override
	public String toString() {
		return "Node [storeId=" + storeId + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", storeTelephone=" + storeTelephone + ", createTime=" + createTime + ", modifiedTime=" + modifiedTime
				+ "]";
	}
	
	

	 
}
