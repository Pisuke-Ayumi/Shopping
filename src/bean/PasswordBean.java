package bean;

public class PasswordBean {
	private String userid,authority;

	public PasswordBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public PasswordBean(String id,String authority){
		this.userid=id;
		this.authority=authority;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
