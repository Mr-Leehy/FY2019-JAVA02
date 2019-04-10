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
		//operation 1:��¼ 2:ע��
		HttpSession session=request.getSession();
		String IESSIONSID= session.getId();
		System.out.println(IESSIONSID);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		String operation=request.getParameter("operation");
		if(operation==null) {
			//���ؿͻ��� operation ���봫��  �����ͻ��˵���json����
			/**
			 * ��Ӧ�����ݸ�ʽͳһΪjson����
			 * jsonͳһ�ĸ�ʽ������int  status  ״̬eg��0 ���سɹ� ��data�ϣ�1���û��������� 2��������� (�Լ�����)
			 * 				   String  msg   ����
			 * 				   Object  data  (ʲô���Ͷ��� ������Object)
			 * 
			 * */
			
			String responsetext=ServerResponse.CreateServerResponseByFile(3, "operation �����д���").Obj2Str();
			
			pw.write(responsetext);
			pw.close();
		}
		//�ַ���תint����
		try {
			int _operation = 	Integer.parseInt(operation);
	
		if(_operation==OperationEnum.ADMIN_LOGIN.getOperation_type()) {//��¼
			//��ȡ�û���
			String username=request.getParameter("username");
			//��ȡ����
			String password=request.getParameter("password");
			
			IAdminService service=AdminServiceImpl.getInstance();
			
			ServerResponse<Admin> serverResponse=service.login(username, password);
			if(serverResponse.isSucess()) {
				session.setAttribute("user",true);
				//����һ��cookie����
				Cookie username_cookie=new Cookie("username",username);
				//����cookie�Ĺ���ʱ��
				username_cookie.setMaxAge(7*24*3600);
				//��cookieд���ͻ��������
				response.addCookie(username_cookie);
				
				Cookie password_cookie=new Cookie("password",password);
				username_cookie.setMaxAge(7*24*3600);
				response.addCookie(password_cookie);
			}
			pw.write(serverResponse.Obj2Str());
		/*if(serverResponse.isSucess()) {//���ؿͻ���,��¼�ɹ�
			String responsetext="{\"status\":0,\"msg\":\"��¼�ɹ�\"}";
			pw.write(responsetext);
			pw.close();
		}else {//���ؿͻ���,��¼ʧ��
			String responsetext="{\"status\":1,\"msg\":\"�û���������\"}";
			pw.write(responsetext);
			pw.close();
		}*/
			
		}else if(_operation==OperationEnum.ADMIN_REGISTER.getOperation_type()) {//ע��
			//��ȡ�û���
			String username=request.getParameter("username");
			//��ȡ����
			String password1=request.getParameter("password1");
			String password2=request.getParameter("password2");
			IAdminService service=AdminServiceImpl.getInstance();
			
			ServerResponse<Admin> serverResponse=service.reginser(username, password1,password2);
			pw.write(serverResponse.Obj2Str());
			/*if(serverResponse.isSucess()) {
				String responsetext="{\"status\":0,\"msg\":\"ע��ɹ�\"}";
				pw.write(responsetext);
				pw.close();
			}else {//���ؿͻ���,��¼ʧ��
				String responsetext="{\"status\":5,\"msg\":\"�������벻һ��\"}";
				pw.write(responsetext);
				pw.close();
			}*/
		}
		}catch(NumberFormatException e){
			//���ؿͻ��� operation ����������
			String responsetext="{\"status\":4,\"msg\":\" operation����������\"}";
			pw.write(responsetext);
			pw.close();
		}
		
		
	}

}
