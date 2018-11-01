package jxc.sys.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * POJO: 日志实体对象(对应jtsys数据库中sys_logs这个表)
 * 封装系统的日志信息
 */
public class SysLog implements Serializable{
	private static final long serialVersionUID = -4523256868571326166L;
	private Integer id;
	/**操作用户*/
	private String username;
	/**执行的操作*/
	private String operation;
	/**执行这个操作对应的方法*/
	private String method;
	/**调用方法时传入的参数*/
	private String params;
	/**方法的执行时间*/
	private Long time;
	/**用户端的ip地址*/
	private String ip;
	/**这个日志的创建时间*/
	private Date createTime;
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
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
}






