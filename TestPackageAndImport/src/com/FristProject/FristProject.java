package com.FristProject;

import java.util.Scanner;

public class FristProject {
	
	public static void main(String[] args) throws RegisterException, LoginException {
		// TODO Auto-generated method stub
		 User u= new User("username","password","name","email");
		
		 User u1= new User("admin" , "admin" ,"Administrator"  , "admin@123.com");
		 User  u2= new User(  "tom"," cat"  ,"tomcat", "tomcat@cat.com");
		 
		 LoginException i1=new LoginException("longin");
		 i1.LoginException();
		 
		 RegisterException r=new RegisterException("register");
		 r.RegisterException();
		 
		 implUserBiz a= new implUserBiz();
		 a.register("admin" , "admin", "admin" ,"Administrator"  , "admin@123.com");
		 a.login("admin" , "admin");
		 
		 implUserView i=new implUserView();
		 i.register();
		 i.login();
	}

	
}

class User{
	public String username;
	public String password;
	public String name;
	public String email;
	
	public User(String username,String password,String name,String email) {
		this.username=username;
		this.password=password;
		this.name=name;
		this.email=email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
}
 class LoginException extends  Exception{
	
	
	public LoginException(String longin) {
		super(longin);
	}

	public void LoginException() {
		// TODO Auto-generated method stub
		
	}

	


}
 class RegisterException extends  Exception{

	public RegisterException(String register) {
		super(register);
	}

	public void RegisterException() {
		// TODO Auto-generated method stub
		
	}

	

}
 
 interface UserBiz {
 void register(String username, String password, String password2,
		    String name, String email)throws RegisterException;
	 
 void login(String username, String password) throws LoginException;
  }
 
 
 
 class implUserBiz implements UserBiz{
	   
		@Override
		public void register(String username, String password, String password2, String name, String email)
				throws RegisterException {
			// TODO Auto-generated method stub
			
	            if(username.equals(username)) {
	            	throw new RegisterException("存在");
	            }if(!(password.equals(password2))) {
	            	throw new RegisterException("两个密码不一样");
	            }
			
		}

		@Override
		public void login(String username, String password) throws LoginException {
			// TODO Auto-generated method stub
			
            if(!(username.equals(username))) {
            	throw new LoginException("用户名不一致");
            }if(username.equals(password)) {
            	throw new LoginException("账户与密码不匹配");
            }
		}

		
 }
 
 interface UserView {
	 void login();
	 void register();
 }
 
 class implUserView implements UserView{
	 void register(String username, String password, String password2,
			    String name, String email) {
		   Scanner scanner1=new Scanner(System.in); 
	      
		    System.out.println("请输入用户名：");
		    String s =scanner1.next(); ;
		    System.out.println("请输入密码");
		    String s1 = scanner1.next();
	 }
	       void login(String username, String password){
	    	Scanner scanner=new Scanner(System.in); 
	      
		    System.out.println("请输入用户名：");
		    String S =scanner.next(); ;
		    System.out.println("请输入密码");
		    String S1 = scanner.next();;
		    if(S.equals(username)&&S1.equals(password)) {
		    	System.out.println("登录成功");
		    }
	       }
	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}
	
	
	 
 }
 
