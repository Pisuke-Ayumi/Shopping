package dao;

import java.sql.SQLException;

import bean.Hash;
import bean.PasswordBean;

public class PasswordDAO extends DaoBase{
	PasswordBean passwordbean=new PasswordBean();
	//登録されている情報比較
	public PasswordBean getPass(String id,String pass){
		PasswordBean passwordbean;
		Hash hash=new Hash();
		String pass2=hash.encryptPass(pass);
		try{
			//connection確率
			super.DbOpen();

			//IDとパスワード同が存在するか・OK権限取得
			String sql="select user_id,authority "
					+ "from password "
					+ "where user_id= ? and password= ?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.setString(2,pass2);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch
			rs.next();
			//UserBeanへIDとパスワードと権限を格納
			passwordbean=new PasswordBean(rs.getString("user_id"),rs.getString("authority"));


		}catch (Exception e){
			passwordbean=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return passwordbean;
	}

	public void setPass(String id,String pass,String authority){
		Hash hash=new Hash();
		String pass2=hash.encryptPass(pass);

		try{
			//connection確率
			super.DbOpen();

			//DBに登録
			String sql="insert into password values(?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.setString(2,pass2);
			stmt.setString(3,authority);
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

	//パスワード変更
		public void updatePass(String pass,String id){
			try{
				//connection確率
				super.DbOpen();

				//DBにユーザ情報を更新
				String sql="update schedules_table set password= ? where user_id= ?";
				stmt=con.prepareStatement(sql);
				stmt.setString(1,pass);
				stmt.setString(2,id);
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

	//パスワード・権限の削除
	public void deletePass(String id){
		try{
			//connection確率
			super.DbOpen();

			//DBの情報削除
			String sql="delete from password where user_id=?";
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
