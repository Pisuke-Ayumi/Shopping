package bean;

public class UsersBean {
	private String  id,username,address,post,phone,birthday,sex ;

	public UsersBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UsersBean(String id,String username,String address,String post,String phone,String birthday,String sex){
		this.id=id;
		this.username=username;
		this.address=address;
		this.post=post;
		this.phone=phone;
		this.birthday=birthday;
		this.sex=sex;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
