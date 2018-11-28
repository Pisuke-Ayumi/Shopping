package bean;

public class CartBean {
	private String userid,productname,color;
	private int productid,quantity,price;

	public CartBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public CartBean(String id,int prodact,String productname,String color,int quantity,int price){
		this.userid=id;
		this.productid=prodact;
		this.productname=productname;
		this.color=color;
		this.quantity=quantity;
		this.price=price;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color=color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
