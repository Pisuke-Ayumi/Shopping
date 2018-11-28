package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ColorCodeBean;
import bean.ProductBean;
import dao.ColorCodeDAO;
import dao.ProductDAO;

/**
 * Servlet implementation class ProductListDP
 */
@WebServlet("/ProductListDP")
public class ProductListDP extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListDP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//商品一覧

		HttpSession session=request.getSession();

		ProductDAO productdao=new ProductDAO();
		ArrayList<ProductBean> productlist=new ArrayList<>();

		//商品情報取得
		productlist=productdao.getPrductall();

		session.setAttribute("productlist",productlist);

		request.getRequestDispatcher("/ProductList.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//商品カラーコード検索
		String key=(String)request.getParameter("key"); //キーワード

		HttpSession session=request.getSession();
		String producttype=(String)session.getAttribute("producttype");  //商品種別

		ColorCodeDAO colorcodedao=new ColorCodeDAO();
		ArrayList<ColorCodeBean> colorlist=new ArrayList<>();

		//キーワードのあるカラーコード取得
		colorlist=colorcodedao.searchColor(producttype,key);

		//セッションに格納
		session.setAttribute("colorlist",colorlist);

		request.getRequestDispatcher("ColorCodeList.jsp").forward(request,response);
	}
}
