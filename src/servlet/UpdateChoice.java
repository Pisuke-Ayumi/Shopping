package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UsersBean;

/**
 * Servlet implementation class UpdateChoice
 */
@WebServlet("/UpdateChoice")
public class UpdateChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateChoice() {
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

		String item=(String)request.getParameter("item"); //選択した変更項目
		String content=null;
		int contentsu=0;

		//セッション・Beanのインスタンス化
		HttpSession session=request.getSession();
		UsersBean userbean=new UsersBean();

		//変更選択項目をセッションに格納
		session.setAttribute("item", item);

		//ユーザ登録情報
		userbean=(UsersBean)session.getAttribute("userbean");

		//ユーザ情報変更項目の判別
		switch (item) {
		case "user_id":
			content=userbean.getId(); break;

		case "user_name":
			content=userbean.getUsername(); break;

		case "street_address":
			content=userbean.getAddress(); break;

		case "postal_code":
			content=userbean.getPost(); break;

		case "phone_number":
			content=userbean.getPhone();;break;

		}
		//変更項目の選択済みの場合セット
		if(content != null){
			request.setAttribute("content", content);
		}

		request.getRequestDispatcher("UserUpdate.jsp").forward(request,response);



	}

}
