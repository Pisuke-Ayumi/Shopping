package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import bean.ProductBean;
import bean.UsersBean;
import dao.ProductDAO;
import dao.UsersDAO;

/**
 * Servlet implementation class Settlement
 */
@WebServlet("/Settlement")
public class Settlement extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Settlement() {
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
		String id=(String)session.getAttribute("id");  //ユーザID
		int sum=0;

		//カート内の情報を取得
		ArrayList<CartBean> cartlist=new ArrayList<>();
		cartlist=(ArrayList<CartBean>)session.getAttribute("cartlist");

		//DAOのインスタンス化
		ProductDAO productdao=new ProductDAO();
		UsersDAO usersdao=new UsersDAO();

		//カート内の金額合計算出
		for(int i=0; i<cartlist.size(); i++){
			ProductBean productbean=new ProductBean();
			sum=sum+(cartlist.get(i).getPrice()*cartlist.get(i).getQuantity());
		}

		//ユーザ情報取得
		UsersBean usersbean=usersdao.getUser(id);

		//セッションに格納
		session.setAttribute("usersbean",usersbean);
		session.setAttribute("sum",sum);

		request.getRequestDispatcher("Settlement.jsp").forward(request,response);


	}

}
