package com.ibatis.addressAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibatis.addressConfig.Config;
import com.ibatis.addressVO.AddressVO;
import com.ibatis.sqlmap.client.SqlMapClient;


/**
 * Servlet implementation class insertAction
 */
@WebServlet("/address/insert.iba")
public class insertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
//		String name= request.getParameter("name");
//		String zipcode= request.getParameter("zipcode");
//		String addr= request.getParameter("addr");
//		String tel= request.getParameter("tel");
		AddressVO vo= new AddressVO();
		vo.setAddr(request.getParameter("addr"));
		vo.setName(request.getParameter("name"));
		vo.setTel(request.getParameter("tel"));
		vo.setZipcode(request.getParameter("zipcode"));
		
		SqlMapClient sqlMap =Config.getSqlMapInstance();
		try {
			sqlMap.insert("insertData",vo);
			response.sendRedirect("list.iba");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
