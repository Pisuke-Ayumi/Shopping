package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;

/**
 * Servlet implementation class CartIn
 */
@WebServlet("/CartIn")
public class CartIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartIn() {
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

		String color=(String)request.getParameter("color1");     //カラー
		String quantity=(String)request.getParameter("number1"); //個数

		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");             //ユーザID
		int productid=(int)session.getAttribute("productid");    //商品ID

		CartDAO cartdao=new CartDAO();

		//カートに追加
		cartdao.updateCart(id, productid, color, quantity);

		request.getRequestDispatcher("CartDP").forward(request,response);
	}

}
