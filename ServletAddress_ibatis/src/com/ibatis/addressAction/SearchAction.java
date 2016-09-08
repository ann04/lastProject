package com.ibatis.addressAction;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibatis.addressConfig.Config;
import com.ibatis.addressVO.AddressVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Servlet implementation class ServletAction
 */
@WebServlet("/address/search.iba")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String field =request.getParameter("field");
		String word =request.getParameter("word");
		SqlMapClient sqlmap =Config.getSqlMapInstance();
		HashMap<String, String> hm =new HashMap<>();
		hm.put("field", field);
		hm.put("word", word);
		try {
			List<AddressVO> arr = sqlmap.queryForList("searchData",hm);
			request.setAttribute("sarr", arr);
			int count=(Integer)sqlmap.queryForObject("searchCount",hm);
			
			//sqlmap.queryForObject("searchCount");
			request.setAttribute("count", count);
			
			RequestDispatcher rd= request.getRequestDispatcher("searchResult.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
