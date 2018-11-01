package jxc.sys.vo;

import java.io.Serializable;

import jxc.sys.entity.SysUser;


public class SysUserRoleResult implements Serializable{
	private static final long serialVersionUID = 5477389876913514595L;
	      private SysUser sysUser;
	      private Integer roleId;
	      private String storeInfo;
		public SysUser getSysUser() {
			return sysUser;
		}
		public void setSysUser(SysUser sysUser) {
			this.sysUser = sysUser;
		}
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
		public String getStoreInfo() {
			return storeInfo;
		}
		public void setStoreInfo(String storeInfo) {
			this.storeInfo = storeInfo;
		}
		public SysUserRoleResult(SysUser sysUser, Integer roleId, String storeInfo) {
			this.sysUser = sysUser;
			this.roleId = roleId;
			this.storeInfo = storeInfo;
		}
		
		
	      
}
