package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PasswordDAO;
import dao.UsersDAO;

/**
 * Servlet implementation class MemberRegist
 */
@WebServlet("/UsersRegist")
public class UsersRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersRegist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//セッション生成・確認フラグ取得
		HttpSession session=request.getSession();
		int frg=(int)session.getAttribute("frg");

		String path=null;

		String id=request.getParameter("id");               //ユーザID
		String name=request.getParameter("name");           //氏名
		String address=request.getParameter("address");     //住所
		String post=request.getParameter("post");           //郵便番号
		String phone=request.getParameter("phone");         //電話番号
		String birthday=request.getParameter("birthday");   //誕生日
		String sex=request.getParameter("sex");             //性別
		String pass=request.getParameter("pass");           //パスワード
		String authority=request.getParameter("authority"); //権限

		//DAOのインスタンス化
		UsersDAO usersdao=new UsersDAO();
		PasswordDAO passworddao=new PasswordDAO();

		String retrunID=usersdao.getUser2(id);

		//確認画面を一度通ったか（フラグ）
		if(retrunID != null){
			//重複するIDの存在確認
            //エラーメッセージ格納
			request.setAttribute("iderr","すでに登録されているメールアドレスです");
			path="Registration.jsp";
		}else{
			if(frg==1){
				//セッションから値取り出し
				id=(String)session.getAttribute("id");
				name=(String)session.getAttribute("name");
				address=(String)session.getAttribute("address");
				post=(String)session.getAttribute("post");
				phone=(String)session.getAttribute("phone");
				birthday=(String)session.getAttribute("birthday");
				sex=(String)session.getAttribute("sex");
				pass=(String)session.getAttribute("pass");
				authority=(String)session.getAttribute("authority");

				//DBに新規ユーザ情報登録(パスワード、ユーザ)
				usersdao.setUser(id, name, address, post, phone, birthday, sex);
				passworddao.setPass(id,pass,authority);
				path="Top.jsp";
            }else{
			    //セッションに格納、確認画面へ値を渡す
			    session.setAttribute("id",id);
			    session.setAttribute("name",name);
			    session.setAttribute("address",address);
			    session.setAttribute("post",post);
			    session.setAttribute("phone",phone);
			    session.setAttribute("birthday",birthday);
			    session.setAttribute("sex",sex);
			    session.setAttribute("pass",pass);
			    session.setAttribute("authority", authority);
			    path="Confirmation.jsp";
            }
		}
		request.getRequestDispatcher(path).forward(request,response);

	}

}
