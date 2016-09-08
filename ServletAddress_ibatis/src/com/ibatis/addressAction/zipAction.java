package com.ibatis.addressAction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibatis.addressConfig.Config;
import com.ibatis.addressVO.AddressVO;
import com.ibatis.addressVO.zipCodeVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Servlet implementation class zipAction
 */
@WebServlet("/address/zipCheck.iba")
public class zipAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zipAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String dong =request.getParameter("dong");
		System.out.println(dong);
		SqlMapClient sqlmap=Config.getSqlMapInstance();
		
		try {
			List<zipCodeVO> arr =sqlmap.queryForList("zipData",dong);
			request.setAttribute("ziplists", arr);
			RequestDispatcher rd= request.getRequestDispatcher("zipResult.jsp");
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
