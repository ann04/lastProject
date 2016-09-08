package com.code.Action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.config.SqlConfig;
import com.code.vo.codeVO;
import com.ibatis.sqlmap.client.SqlMapClient;


/**
 * Servlet implementation class testAction
 */
@WebServlet("/code/test1.go")
public class testAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		SqlMapClient sqlmap = SqlConfig.getSqlMapInstance();
		try {
			codeVO vo = (codeVO) sqlmap.queryForObject("viewData1",num);
			request.setAttribute("arr", vo);
			RequestDispatcher rd = request.getRequestDispatcher("code.jsp");
			rd.forward(request, response);
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
