package cn.hankchan.data.root.entity;

/**
 * Root实体类
 * @author hankChan
 * @Email hankchan101@gmail.com
 * @time 13 Oct 2016-11:55:46
 * @detail
 */
public class Root {

	public String root;
	public String password;
	public String phone;
	public String tips;
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	@Override
	public String toString() {
		return "Root [root=" + root + ", password=" + password + ", phone=" + phone + ", tips=" + tips + "]";
	}
	
}
