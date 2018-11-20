package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.CartBean;


public class CartDAO extends DaoBase{

	//カートの内表示
	public ArrayList<CartBean> getCart(String id){

		ArrayList<CartBean> cartlist=new ArrayList<>();

		try{
			//connection確率
			super.DbOpen();

			//Stockのあるカラーコード取得
			String sql="select c.user_id,c.product_id,p.product_name,c.color_code,c.quantity,p.unit_price"
					+ " from cart c,product p"
					+ " where c.product_id=p.product_id and user_id=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,id);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch
			while(rs.next()){
				CartBean cartbean=new CartBean(rs.getString("user_id"),rs.getInt("product_id"),rs.getString("product_name"),
						rs.getString("color_code"),rs.getInt("quantity"),rs.getInt("unit_price"));
				cartlist.add(cartbean);
			}

		}catch (Exception e){
			cartlist=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return cartlist;
	}

	//カートに商品追加
	public void updateCart(String id,int product,String color,String quantity){
		int quantity2=Integer.parseInt(quantity);

		try{
			//connection確率
			super.DbOpen();

			//DBにユーザ情報を更新
			String sql="insert into cart values(?,?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.setInt(2,product);
			stmt.setString(3,color);
			stmt.setInt(4,quantity2);
			stmt.executeUpdate();



		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//接続したものが空でなければ閉じる
			try{
				if(stmt != null){stmt.close();}
				if(con != null){con.close();}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

	}

	//カート内更新
	public void deleteCart(String id,String product,String color,String quantity){
		int product2=Integer.parseInt(product);
		int quantity2=Integer.parseInt(quantity);

		try{
			//connection確率
			super.DbOpen();

			//DBにユーザ情報を更新
			String sql="update cart set quantity=? "
					+ "where user_id=? and product_id=? color_code=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,quantity);
			stmt.setString(2,id);
			stmt.setInt(3,product2);
			stmt.setString(4,color);
			stmt.executeUpdate();



		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//接続したものが空でなければ閉じる
			try{
				if(stmt != null){stmt.close();}
				if(con != null){con.close();}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	//カート内商品削除
	public void deleteCart(String id,int product,String color){

		try{
			//connection確率
			super.DbOpen();

			//DBにユーザ情報を更新
			String sql="delete from cart where user_id=? and "
					+ "product_id=? and color_code=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.setInt(2,product);
			stmt.setString(3,color);
			stmt.executeUpdate();



		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//接続したものが空でなければ閉じる
			try{
				if(stmt != null){stmt.close();}
				if(con != null){con.close();}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	//カート内リセット
		public void resetCart(String id){

			try{
				//connection確率
				super.DbOpen();

				//DBにユーザ情報を更新
				String sql="delete from cart where user_id=? ";
				stmt=con.prepareStatement(sql);
				stmt.setString(1,id);
				stmt.executeUpdate();



			}catch(Exception e){
				e.printStackTrace();
			}finally{
				//接続したものが空でなければ閉じる
				try{
					if(stmt != null){stmt.close();}
					if(con != null){con.close();}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}

}
