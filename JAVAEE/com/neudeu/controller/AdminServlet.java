package com.neudeu.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neudeu.Admin.Admin;
import com.neudeu.common.OperationEnum;
import com.neudeu.common.ServerResponse;
import com.neuedu.service.IAdminService;
import com.neuedu.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//operation 1:登录 2:注册
		HttpSession session=request.getSession();
		String IESSIONSID= session.getId();
		System.out.println(IESSIONSID);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		String operation=request.getParameter("operation");
		if(operation==null) {
			//返回客户端 operation 必须传递  传到客户端的是json类型
			/**
			 * 响应的数据格式统一为json类型
			 * json统一的格式：：：int  status  状态eg：0 返回成功 到data上，1：用户名不存在 2：密码错误 (自己决定)
			 * 				   String  msg   描述
			 * 				   Object  data  (什么类型都行 所以是Object)
			 * 
			 * */
			
			String responsetext=ServerResponse.CreateServerResponseByFile(3, "operation 必须有传递").Obj2Str();
			
			pw.write(responsetext);
			pw.close();
		}
		//字符串转int类型
		try {
			int _operation = 	Integer.parseInt(operation);
	
		if(_operation==OperationEnum.ADMIN_LOGIN.getOperation_type()) {//登录
			//获取用户名
			String username=request.getParameter("username");
			//获取密码
			String password=request.getParameter("password");
			
			IAdminService service=AdminServiceImpl.getInstance();
			
			ServerResponse<Admin> serverResponse=service.login(username, password);
			if(serverResponse.isSucess()) {
				session.setAttribute("user",true);
				//创建一个cookie密码
				Cookie username_cookie=new Cookie("username",username);
				//创建cookie的过期时间
				username_cookie.setMaxAge(7*24*3600);
				//讲cookie写到客户端浏览器
				response.addCookie(username_cookie);
				
				Cookie password_cookie=new Cookie("password",password);
				username_cookie.setMaxAge(7*24*3600);
				response.addCookie(password_cookie);
			}
			pw.write(serverResponse.Obj2Str());
		/*if(serverResponse.isSucess()) {//返回客户端,登录成功
			String responsetext="{\"status\":0,\"msg\":\"登录成功\"}";
			pw.write(responsetext);
			pw.close();
		}else {//返回客户端,登录失败
			String responsetext="{\"status\":1,\"msg\":\"用户名不存在\"}";
			pw.write(responsetext);
			pw.close();
		}*/
			
		}else if(_operation==OperationEnum.ADMIN_REGISTER.getOperation_type()) {//注册
			//获取用户名
			String username=request.getParameter("username");
			//获取密码
			String password1=request.getParameter("password1");
			String password2=request.getParameter("password2");
			IAdminService service=AdminServiceImpl.getInstance();
			
			ServerResponse<Admin> serverResponse=service.reginser(username, password1,password2);
			pw.write(serverResponse.Obj2Str());
			/*if(serverResponse.isSucess()) {
				String responsetext="{\"status\":0,\"msg\":\"注册成功\"}";
				pw.write(responsetext);
				pw.close();
			}else {//返回客户端,登录失败
				String responsetext="{\"status\":5,\"msg\":\"两次密码不一致\"}";
				pw.write(responsetext);
				pw.close();
			}*/
		}
		}catch(NumberFormatException e){
			//返回客户端 operation 必须是数字
			String responsetext="{\"status\":4,\"msg\":\" operation必须是数字\"}";
			pw.write(responsetext);
			pw.close();
		}
		
		
	}

}
