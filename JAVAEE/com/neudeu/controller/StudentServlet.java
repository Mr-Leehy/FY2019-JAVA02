package com.neudeu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neudeu.Admin.Student;
import com.neudeu.common.OperationStudentEnum;
import com.neudeu.common.ServerResponse;
import com.neuedu.service.IStudentService;

import com.neuedu.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/Student.do")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		String operation=request.getParameter("operation");
		String ID=request.getParameter("ID");
		String AGE=request.getParameter("AGE");
		String Sorce=request.getParameter("Sorce");
		
		IStudentService iss=StudentServiceImpl.getInstance();
		
		if(operation==null) {
			String responsetext=ServerResponse.CreateServerResponseByFile(3, "operation 必须有传递").Obj2Str();
			pw.write(responsetext);
			pw.close();
		}
		
		try {
			int _operation =Integer.parseInt(operation);
			
		if(_operation==OperationStudentEnum.STUDENT_FINDALL.getOperation_type()) {
			Map<Integer,Student> issucc=iss.findAll();
			String responsetext=ServerResponse.CreateServerResponseBySucess("查询成功", issucc).Obj2Str();
			pw.write(responsetext);
			pw.close();			
		}else if(_operation==OperationStudentEnum.STUDENT_FINDSTUDENTBYID.getOperation_type()) {
			String id=request.getParameter("id");
			int _Id=Integer.parseInt(id);
			ServerResponse<Student> issucc=iss.findStudentById(_Id);
			String responsetext=ServerResponse.CreateServerResponseBySucess("查询成功", issucc).Obj2Str();
			pw.write(responsetext);
			pw.close();
		}else if(_operation==OperationStudentEnum.STUDENT_ADD.getOperation_type()){
			String id3=request.getParameter("id3");
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String sorce=request.getParameter("sorce");
			//IStudentService iss=new StudentServiceImpl();
			int _Id = 	Integer.parseInt(id3);
			int _AGE = 	Integer.parseInt(age);
			int _Sorce = 	Integer.parseInt(sorce);
			ServerResponse<Student> issucc=iss.Add(_Id, name,_AGE,_Sorce);
			String responsetext=ServerResponse.CreateServerResponseBySucess("查询成功", issucc).Obj2Str();
			pw.write(responsetext);
			pw.close();	
			/*if(issucc != null) {
				String responsetext="{\"status\":0,\"msg\":\"查看成功\"issucc}";
				pw.write(responsetext);
				pw.close();
			}else {
				String responsetext="{\"status\":1,\"msg\":\"用户不存在\"}";
				pw.write(responsetext);
				pw.close();
			}*/
			
		}else if(_operation==OperationStudentEnum.STUDENT_UPDATABYID.getOperation_type()) {
			String id1=request.getParameter("id1");
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String sorce=request.getParameter("sorce");
			//IStudentService iss=new StudentServiceImpl();
			int _Id = 	Integer.parseInt(id1);
			int _AGE = 	Integer.parseInt(age);
			int _Sorce = 	Integer.parseInt(sorce);
			ServerResponse<Student> issucc=iss.upDataById(_Id, name,_AGE,_Sorce);
			String responsetext=ServerResponse.CreateServerResponseBySucess("改变成功", issucc).Obj2Str();
			pw.write(responsetext);
			pw.close();	
			
		}else if(_operation==OperationStudentEnum.STUDENT_DELETEBYID.getOperation_type()) {
			String id2=request.getParameter("id2");
			int _Id=Integer.parseInt(id2);
			ServerResponse<Student> issucc=iss.deleteStudentById(_Id);
			String responsetext=ServerResponse.CreateServerResponseBySucess("删除成功", issucc).Obj2Str();
			pw.write(responsetext);
			pw.close();
		}
		}catch(NumberFormatException e){
			//返回客户端 operation 必须是数字
			String responsetext=ServerResponse.CreateServerResponseByFile(4, "operation 必须是数字").Obj2Str();
			pw.write(responsetext);
			pw.close();
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
