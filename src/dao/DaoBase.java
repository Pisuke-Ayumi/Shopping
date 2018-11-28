package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DaoBase {
	Connection con=null;          //DBMSへ接続や切断を行う
	PreparedStatement stmt=null;   //SQLの送信を行う
	ResultSet rs=null;            //DBMSからの検索結果を受け取る
	int rsno=0;                   //DBMSからの処理件数を受け取る

	//データソース
	DataSource ds=null;

	public DaoBase() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Connection DbOpen(){
		//JDBCドライバのロード(java6から(現在は)省略可)
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//指定するデータベースへ接続(引数:URL/利用ユーザ/パスワード)
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1601135","root","root");

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	public void DbClose(){
		//
		try{
			if(rs !=null){rs.close();}
			if(con !=null){con.close();}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
