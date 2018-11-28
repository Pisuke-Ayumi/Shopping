package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.PasswordDAO;
import dao.UsersDAO;

/**
 * Servlet implementation class UsersDelete
 */
@WebServlet("/UsersDelete")
public class UsersDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id"); //ユーザID

		//DAOのインスタンス化
		UsersDAO usersdao=new UsersDAO();
		PasswordDAO passworddao=new PasswordDAO();
		CartDAO cartdao=new CartDAO();

		usersdao.deleteUser(id);     //ユーザ情報削除
		passworddao.deletePass(id);  //パスワード情報削除
		cartdao.resetCart(id);       //カート情報削除

		session.invalidate();        //セッションの破棄
		request.getRequestDispatcher("Top.jsp").forward(request,response);


	}

}
