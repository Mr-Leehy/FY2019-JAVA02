package com.neudeu.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neudeu.common.ServerResponse;
import com.neuedu.service.IAdminService;
import com.neuedu.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/Session.do")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies=request.getCookies();
		String username=null;
		String password=null;
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				Cookie cookie=cookies[i];
				String name_cookie=cookie.getName();
				String value_cookie=cookie.getValue();
				if(name_cookie.equals("username")) {
					username=value_cookie;
				}
				if(name_cookie.equals("password")) {
					password=value_cookie;
				}
			}
		}
		
		if(username!=null&&password!=null) {
			IAdminService service=AdminServiceImpl.getInstance();
			ServerResponse serverResponse=service.login(username, password);
			response.getWriter().write(serverResponse.Obj2Str());
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
