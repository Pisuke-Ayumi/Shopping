package bean;

public class ColorCodeBean {
	String code,img;  //カラーコード
	int stock;    //商品在庫

	public ColorCodeBean(){
	}

	public ColorCodeBean(String code,int stock,String img) {
		this.code=code;
		this.stock=stock;
		this.img=img;
	}

	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code=code;
	}

	public int getStock(){
		return stock;
	}

	public void setStck(int stock){
		this.stock=stock;
	}

	public String getImg(){
		return img;
	}

	public void setImg(String img){
		this.img=img;
	}

}
