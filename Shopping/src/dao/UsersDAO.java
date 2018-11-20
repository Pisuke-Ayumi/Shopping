package dao;

import java.sql.SQLException;

import bean.UsersBean;

public class UsersDAO extends DaoBase{
	UsersBean userbean=new UsersBean();

	//ユーザ登録情報の取得
	public UsersBean getUser(String id){
		UsersBean userbean;

		try{
			//connection確率
			super.DbOpen();

			//DBに問い合わせ
			String sql="select * "
					+ "from users "
					+ "where user_id=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,id);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch
			rs.next();
			//UserBeanへ取得情報を格納
			userbean=new UsersBean(rs.getString("user_id"),rs.getString("user_name"),
					rs.getString("street_address"),rs.getString("postal_code"),
					rs.getString("phone_number"),rs.getString("birthday"),rs.getString("sex"));


		}catch (Exception e){
			userbean=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return userbean;
	}

	//ユーザのID（メールアドレス）確認
	public String getUser2(String id){
		String returnID=null;

		try{
			//connection確率
			super.DbOpen();

			//DBに問い合わせ
			String sql="select user_id "
					+ "from users "
					+ "where user_id= ?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,id);
			rs=stmt.executeQuery();

			//カーソルを1件目へ移動させる、データがなければcatch
			rs.next();
			//UserBeanへ取得情報を格納
			returnID=rs.getString("user_id");

		}catch (Exception e){
			userbean=null;
		}finally{
			try{
				//エラー時はclose処理
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return returnID;
	}


	//新規ユーザ登録
	public void setUser(String id,String name,String address,String post,
			String phone,String birthday,String sex){

		try{
			//connection確率
			super.DbOpen();

			//DBに登録
			String sql="insert into users values(?,?,?,?,?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.setString(2,name);
			stmt.setString(3,address);
			stmt.setString(4,post);
			stmt.setString(5,phone);
			stmt.setString(6,birthday);
			stmt.setString(7,sex);
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

	//ユーザ登録情報更新
	public void updateUser(String content,String id,String item){


		try{
			//connection確率
			super.DbOpen();

			//DBにユーザ情報を更新
			String sql="update users set "+item+"= ? where user_id= ?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,content);
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

	//登録ユーザ削除
	public void deleteUser(String id){
		try{
			//connection確率
			super.DbOpen();

			//DBのユーザ情報削除
			String sql="delete from users where user_id=?";
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

