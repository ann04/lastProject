package com.basket.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basket.config.Config;
import com.basket.vo.BasketVo;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Servlet implementation class basket
 */
@WebServlet("/code/basketList.go")
public class BasketList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketList() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
//		BasketVo bk=new BasketVo();
//		bk.setProductName(request.getParameter("productName"));
//		bk.setColor(request.getParameter("color"));
//		bk.setNumbers(Integer.parseInt(request.getParameter("numbers")));
//		bk.setPrice(Integer.parseInt(request.getParameter("price")));
		 
		SqlMapClient sqlmap=Config.getSqlMapInstance();
		try {
			List<BasketVo> arr=(List<BasketVo>)sqlmap.queryForList("listData");
			request.setAttribute("lists", arr);
			int count=(Integer)sqlmap.queryForObject("countData");
			request.setAttribute("count", count);
			RequestDispatcher rd=request.getRequestDispatcher("/basket/basketView.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
