package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.PurchaseBean;
import dao.PurchaseDAO;

/**
 * Servlet implementation class PurchaseDP
 */
@WebServlet("/PurchaseDP")
public class PurchaseDP extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseDP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id"); //ユーザID

		//DAOとListのインスタンス化
		PurchaseDAO purchasedao=new PurchaseDAO();
		ArrayList<PurchaseBean> parchlist=new ArrayList<>();

		//購入履歴取得
		parchlist=purchasedao.getPurch(id);

		//セッションに格納
		session.setAttribute("purchlist",parchlist);
		request.getRequestDispatcher("PurchaseList.jsp").forward(request,response);
	}

}
