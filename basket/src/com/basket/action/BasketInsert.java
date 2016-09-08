package com.basket.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basket.config.Config;
import com.basket.vo.BasketVo;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Servlet implementation class BasketInsert
 */
@WebServlet("/code/insert1.go")
public class BasketInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		BasketVo bk=new BasketVo();
		bk.setProductName(request.getParameter("productname"));
		bk.setColor(request.getParameter("color"));
		bk.setNumbers(Integer.parseInt(request.getParameter("numbers")));
		bk.setPrice(Integer.parseInt(request.getParameter("price")));
		
		SqlMapClient sqlmap=Config.getSqlMapInstance();
		try {
			sqlmap.insert("insertdata", bk);
			response.sendRedirect("basketList.go");
		} catch (SQLException e) {
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
