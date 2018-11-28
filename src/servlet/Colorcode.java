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
import dao.ColorCodeDAO;

/**
 * Servlet implementation class Colorcode
 */
@WebServlet("/Colorcode")
public class Colorcode extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Colorcode() {
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

		String product=(String)request.getParameter("product");  //商品の種類
		int productid=0;
		int product2=Integer.parseInt(product);

		//商品の種類判別
		if(product2 == 1){
			product="chao_stock";
			productid=315169311;
		}else if(product2 == 2){
			product="sketch_stock";
			productid=315169312;
		}else if(product2 == 3){
			product="classic_stock";
			productid=315169313;
		}else if(product2 == 4){
			product="inke_stock";
			productid=315169314;
		}

		HttpSession session=request.getSession();
		session.setAttribute("producttype",product);   //商品種別セッションに格納
		session.setAttribute("productid", productid);  //商品IDセッションに格納

		ColorCodeDAO colordao=new ColorCodeDAO();

		//商品種別のカラーコード取得・セッションに格納
		ArrayList<ColorCodeBean> colorlist=colordao.getColor(product);
		request.setAttribute("colorlist",colorlist);

		request.getRequestDispatcher("ColorCodeList.jsp").forward(request,response);


	}

}
