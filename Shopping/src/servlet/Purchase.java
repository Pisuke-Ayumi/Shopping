package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import bean.UsersBean;
import dao.CartDAO;
import dao.ColorCodeDAO;
import dao.PurchaseDAO;

/**
 * Servlet implementation class Purchase
 */
@WebServlet("/Purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Purchase() {
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

		//購入日付を取得
		Date dt = new Date();
		DateFormat df =DateFormat.getDateInstance(); //DateFormatの取得
		String formatStr = df.format(dt);

		//セッション・DAOインスタンス化
		HttpSession session=request.getSession();
		PurchaseDAO purchasedao=new PurchaseDAO();
		CartDAO cartdao=new CartDAO();
		ColorCodeDAO colorcodedao=new ColorCodeDAO();


		//ユーザの登録情報、カート内容、支払い方法取得
		UsersBean usersbean=(UsersBean)session.getAttribute("usersbean");
		ArrayList<CartBean> cartlist=new ArrayList<>();
		cartlist=(ArrayList<CartBean>)session.getAttribute("cartlist");
		String payment=(String)session.getAttribute("payment");


		for(int i=0; i<cartlist.size(); i++){
			//購入履歴に追加
			purchasedao.setPurch(formatStr,usersbean.getId(),cartlist.get(i).getProductid(),
					cartlist.get(i).getColor(), cartlist.get(i).getQuantity(), payment);

			//商品の種類判別
			String product=null;
			if(cartlist.get(i).getProductid() == 315169311){
				product="chao_stock";
			}else if(cartlist.get(i).getProductid() == 315169312){
				product="sketch_stock";
			}else if(cartlist.get(i).getProductid() == 315169313){
				product="classic_stock";
			}else if(cartlist.get(i).getProductid() == 315169314){
				product="inke_stock";
			}

			//在庫数取得、在庫変更
			int stock=colorcodedao.getStock(product,cartlist.get(i).getColor());
			stock=stock-cartlist.get(i).getQuantity();
			colorcodedao.updateStock(product,cartlist.get(i).getColor(),stock);
		}


		//カート内削除
		cartdao.resetCart(usersbean.getId());

		request.getRequestDispatcher("Top.jsp").forward(request,response);


	}

}
