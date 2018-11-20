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
import dao.CartDAO;

/**
 * Servlet implementation class CartDelete
 */
@WebServlet("/CartDelete")
public class CartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDelete() {
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

		String listnumber=(String)request.getParameter("listnumber");
		int listnum=Integer.parseInt(listnumber);
		System.out.println(listnum);

		System.out.println("a");
		HttpSession session=request.getSession();
		ArrayList<CartBean> cartlist=(ArrayList<CartBean>)session.getAttribute("cartlist");
		CartBean cartbean=cartlist.get(listnum);

		CartDAO cartdao=new CartDAO();
		//Beanから値を取り出し
		cartdao.deleteCart(cartbean.getUserid(),cartbean.getProductid(),cartbean.getColor());

		request.getRequestDispatcher("CartDP").forward(request,response);

	}

}
