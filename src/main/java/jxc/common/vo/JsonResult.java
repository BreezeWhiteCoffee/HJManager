package jxc.common.vo;
/**
 * 通过此对象封装控制层数据
 * @author ta
 */
public class JsonResult {//{"id":1,"message":"ok"}
    /**状态码：1表示正确，0表示错误*/
	private int state=1;
	/**状态码对应的信息*/
	private String message="ok";
	/**正确数据通过此属性进行封装，例如查询结果*/
	private Object data;
	public JsonResult() {}
	
	public JsonResult(String message){
		this.message=message;
	}
	/***
	 * 初始化正确的数据
	 * @param data
	 */
	public JsonResult(Object data) {
		this.data=data;
	}
	/**出现异常时可通过此方法初始化异常信息*/
	public JsonResult(Throwable e) {
		this.state=0;//表示错误信息
		this.message=e.getMessage();//异常信息
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
}

