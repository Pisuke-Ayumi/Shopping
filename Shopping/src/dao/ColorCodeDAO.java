package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.ColorCodeBean;

public class ColorCodeDAO extends DaoBase{

	public ArrayList<ColorCodeBean> getColor(String product){

		ArrayList<ColorCodeBean> colorlist=new ArrayList<>();

		try{
			//connection確率
			super.DbOpen();

			//Stockのあるカラーコード取得
			String sql="select color_code,"+product+",image"
					+ " from color_code"
					+ " where "+product+" is not null";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch
			while(rs.next()){
				if(rs.getInt(product)!=0){
					ColorCodeBean colorbean=new ColorCodeBean(rs.getString("color_code"),rs.getInt(product),rs.getString("image"));
					colorlist.add(colorbean);
				}
			}

		}catch (Exception e){
			colorlist=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return colorlist;
	}

	//検索
	public ArrayList<ColorCodeBean> searchColor(String product,String key){

		ArrayList<ColorCodeBean> colorlist=new ArrayList<>();

		try{
			//connection確率
			super.DbOpen();

			//Stockのあるカラーコード取得
			String sql="select color_code,"+product+",image"
					+ " from color_code"
					+ " where "+product+" is not null "
							+ "and color_code like '"+key+"%'";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch
			while(rs.next()){
				if(rs.getInt(product)!=0){
					ColorCodeBean colorbean=new ColorCodeBean(rs.getString("color_code"),rs.getInt(product),rs.getString("image"));
					colorlist.add(colorbean);
				}
			}

		}catch (Exception e){
			colorlist=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return colorlist;
	}

	public int getStock(String product,String colorcode){
		int stock=0;

		try{
			//connection確率
			super.DbOpen();

			//Stockのあるカラーコード取得
			String sql="select "+product
					+ " from color_code"
					+ " where color_code=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,colorcode);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch
			rs.next();
			stock=rs.getInt(product);

		}catch (Exception e){
			stock=0;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return stock;
	}

	//在庫変更
	public void updateStock(String product,String color,int stock){


		try{
			//connection確率
			super.DbOpen();
			//DBにユーザ情報を更新
			String sql="update color_code set "+product+"= ? where color_code= ?";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1,stock);
			stmt.setString(2,color);
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
