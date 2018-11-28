package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.PasswordBean;
import dao.PasswordDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.invalidate();
		request.getRequestDispatcher("Top.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=null; //遷移先URL

		String id=request.getParameter("id");     //ID取得
		String pass=request.getParameter("pass"); //パスワード取得



		//DAOファイルとBeanファイルをインスタンス化
		PasswordDAO passwroddao=new PasswordDAO();
		PasswordBean passwordbean=new PasswordBean();

		//idとpassword比較
		passwordbean=passwroddao.getPass(id,pass);


		if(passwordbean != null){
			//loginOK
			//ログインしてにユーザIDと権限をセッションに格納
			HttpSession session=request.getSession();
			session.setAttribute("id",id);
			session.setAttribute("authority", passwordbean.getAuthority());
			path="Top.jsp";
		}else{
			//G101画面へ飛ぶindex.html
			request.setAttribute("err", "ユーザID、パスワードが違います。");
			path="Login.jsp";
		}
		request.getRequestDispatcher(path).forward(request,response);

	}

}
