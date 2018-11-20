package bean;

public class PurchaseBean {
	private String history,puroductname,color,payment;   //日付,ユーザID,カラー,支払い方法
	private int productid,quanty;              //商品ID,個数

	public PurchaseBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public PurchaseBean(String history,int productid,String productname,String color,int quanty,String payment){
		this.history=history;
		this.productid=productid;
		this.setPuroductname(productname);
		this.color=color;
		this.quanty=quanty;
		this.payment=payment;
	}


	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getPuroductname() {
		return puroductname;
	}

	public void setPuroductname(String puroductname) {
		this.puroductname = puroductname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}




}
