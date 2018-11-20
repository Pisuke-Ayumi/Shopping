package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.PurchaseBean;

public class PurchaseDAO extends DaoBase{

	public PurchaseDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//購入履歴取得
	public ArrayList<PurchaseBean> getPurch(String id){
		ArrayList<PurchaseBean> purchlist=new ArrayList<>();
		System.out.println(id);

		try{
			//connection確率
			super.DbOpen();

			//DBに問い合わせ
			String sql="select d.history_id,d.product_id,p.product_name,d.color_code,d.quanty,d.payment_method "
					+ "from purchase_details d,product p "
					+ "where d.product_id=p.product_id and user_id=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,id);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch
			while(rs.next()){
				//PurchaseBeanへ取得情報を格納
				PurchaseBean purchasebean;
				purchasebean=new PurchaseBean(rs.getString("history_id"),rs.getInt("product_id"),rs.getString("product_name"),
						rs.getString("color_code"),rs.getInt("quanty"),rs.getString("payment_method"));
				purchlist.add(purchasebean);
			}

		}catch (Exception e){
			purchlist=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return purchlist;
	}

	//購入履歴追加
	public void setPurch(String history,String id,int productid,String color,int quanty,String payment){
		System.out.println(history+id+productid+color+quanty+payment);

		try{
			//connection確率
			super.DbOpen();

			//DBに追加
			String sql="insert into purchase_details values(?,?,?,?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,history);
			stmt.setString(2,id);
			stmt.setInt(3,productid);
			stmt.setString(4,color);
			stmt.setInt(5,quanty);
			stmt.setString(6,payment);
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
