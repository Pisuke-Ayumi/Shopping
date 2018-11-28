package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UsersBean;
import dao.UsersDAO;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
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

		//セッションの生成
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id"); //ユーザID

		UsersDAO usersdao=new UsersDAO();

		//ユーザ登録情報取得
		UsersBean userbean=usersdao.getUser(id);

		session.setAttribute("userbean", userbean);

		request.getRequestDispatcher("UserUPList.jsp").forward(request,response);

	}

}
