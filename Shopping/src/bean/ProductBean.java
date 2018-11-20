package bean;

public class ProductBean {
	private String productname,category,details,url;
	private int productid,price;

	public ProductBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public ProductBean(int productid,String productname,String category,int price,String details,String url){
		this.productid=productid;
		this.productname=productname;
		this.category=category;
		this.price=price;
		this.details=details;
		this.url=url;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getMaker() {
		return category;
	}

	public void setMaker(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
