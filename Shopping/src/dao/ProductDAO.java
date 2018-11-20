package dao;

import java.util.ArrayList;

import bean.ProductBean;

public class ProductDAO extends DaoBase{

	public ProductDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	//商品一覧
	public ArrayList<ProductBean> getPrductall(){
		ProductBean productbean;

		ArrayList<ProductBean> productlist=new ArrayList<>();

		try{
			//connection確率
			super.DbOpen();

			//DBに問い合わせ
			String sql="select * "
					+ "from product";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch

			//UserBeanへ取得情報を格納
			while(rs.next()){
				productbean=new ProductBean(rs.getInt("product_id"),rs.getString("product_name"),
						rs.getString("category"),rs.getInt("unit_price"),
						rs.getString("details"),rs.getString("image_URL"));
				productlist.add(productbean);
			}

		}catch (Exception e){
			productbean=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return productlist;
	}

	//商品検索
	public ArrayList<ProductBean> getPrductsearch(){
		ProductBean productbean;

		ArrayList<ProductBean> productlist=new ArrayList<>();

		try{
			//connection確率
			super.DbOpen();

			//DBに問い合わせ
			String sql="select * "
					+ "from product";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch

			//UserBeanへ取得情報を格納
			while(rs.next()){
				productbean=new ProductBean(rs.getInt("product_id"),rs.getString("product_name"),
						rs.getString("category"),rs.getInt("unit_price"),
						rs.getString("details"),rs.getString("image_URL"));
				productlist.add(productbean);
			}



		}catch (Exception e){
			productbean=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return productlist;
	}

	//商品詳細情報
	public ProductBean getPrductdeta(int productid){
		ProductBean productbean;

		try{
			//connection確率
			super.DbOpen();

			//DBに問い合わせ
			String sql="select * "
					+ "from product "
					+ "where product_id=?";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1,productid);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch

			//UserBeanへ取得情報を格納
			rs.next();

			productbean=new ProductBean(rs.getInt("product_id"),rs.getString("product_name"),
						rs.getString("category"),rs.getInt("unit_price"),
						rs.getString("details"),rs.getString("image_URL"));




		}catch (Exception e){
			productbean=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return productbean;
	}

}
