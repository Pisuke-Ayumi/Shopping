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
 * Servlet implementation class UsersUpdate
 */
@WebServlet("/UsersUpdate")
public class UsersUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersUpdate() {
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

		String content=request.getParameter("content");  //変更後内容

		HttpSession session=request.getSession();
		String item=(String)session.getAttribute("item"); //変更項目
		String id=(String)session.getAttribute("id");     //ユーザID

		UsersDAO usersdao=new UsersDAO();
		PasswordDAO passworddao=new PasswordDAO();


		System.out.println("たかのだいき");


		//DBをアップデート
		if(item.equals("password")){
			System.out.println("たばこ");
			passworddao.updatePass(content,id);
		}else{
			System.out.println("test");
			usersdao.updateUser(content, id, item);
		}
		System.out.println("あいうえお");
		request.getRequestDispatcher("UserInfo").forward(request,response);
	}

}