package com.ibatis.addressAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibatis.addressConfig.Config;
import com.ibatis.addressVO.AddressVO;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.oracle.jrockit.jfr.RequestableEvent;

/**
 * Servlet implementation class viewAction
 */
@WebServlet("/address/view.iba")
public class viewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int num=Integer.parseInt(request.getParameter("num"));
		SqlMapClient sqlMap =Config.getSqlMapInstance();
		AddressVO vo;
		try {
			vo = (AddressVO)sqlMap.queryForObject("viewData", num);
			request.setAttribute("dto", vo);
			RequestDispatcher rd= request.getRequestDispatcher("addressView.jsp");
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
