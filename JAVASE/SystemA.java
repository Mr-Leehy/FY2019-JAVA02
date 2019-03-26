import java.util.Scanner;

public class SystemA{
	
	public static void main(String[] args){
		Administrators[] A=new Administrators[5];
		//Administrators a=new Administrators();
		student[] S=new student[10]; 
		//student s=new student();
		student a=new student(1,"唐三  ",18,"男","高级","北京","15848854445","2222@qq.com");
		student aa=new student(2,"小舞  ",17,"女","高级","北京","15848854445","2222@qq.com");
		student aaa=new student(3,"马红俊",17,"男","高级","北京","15848854445","2222@qq.com");
		student aaaa=new student(4,"戴沐白",21,"男","高级","北京","15848854445","2222@qq.com");
		student aaaaa=new student(5,"朱竹清",20,"女","高级","北京","15848854445","2222@qq.com");
		S[0]=a;
		S[1]=aa;
		S[2]=aaa;
		S[3]=aaaa;
		S[4]=aaaaa;
		sign();
		find();
		contain(A);   
		ergodic(A);
		studentS();
		action1(S);
		find1();
		student2(S);
		inCrease(S);
		delete(S);
		modify(S);
	}
	public static void sign(){
		System.out.println("----------欢迎登录学生管理系统----------");
		System.out.println("1.登录      2.退出");
		System.out.println("-----------------------------------------");
			
			
	}
	
	public static void find(){
		    Scanner scanner=new Scanner(System.in);  
			
            System.out.println("请输入1或2:");
			
            int i=scanner.nextInt(); 
			if(i==1){
				System.out.println("欢迎登录");
			}else if(i==2){
				System.exit(1);
			}else{
				System.out.println("请输入一个正确的数字：");
				find();
			}
	}
	

	public static void contain(Administrators[] A){
		
			Administrators a=new Administrators("张三丰","admin");
			Administrators aa=new Administrators("张无忌","admin");
			Administrators aaa=new Administrators("赵敏","admin");
			Administrators aaaa=new Administrators("杨潇","admin");
			Administrators aaaaa=new Administrators("周芷若","admin");
			A[0] = a;
			A[1] = aa;
			A[2] = aaa;
			A[3] = aaaa;
			A[4] = aaaa;
			
	}

	public static void ergodic( Administrators[] A){
		Scanner scanner=new Scanner(System.in);  
 
		System.out.println("请输入管理员账号：");
			
        String s=scanner.nextLine(); 
				
		System.out.println("请输入管理员密码：");	

		String ss=scanner.nextLine();
		//boolean a=true;
		int a=2;
		for(int i=0;i<A.length;i++){
			
			if(s.equals(A[i].username)&&ss.equals(A[i].password)){
				System.out.println("欢迎您："+A[i].username);
				a=1;
				break;
			}
			continue;
		}
		if(a==2){
			System.out.println("请输入正确的账号密码");
			ergodic(A);
		}
		
	}		
	

	
	public static void studentS(){
		System.out.println("----------------------请选择要操作的对应信息数字------------------");
		System.out.println("1.查看学生信息 2.添加学生信息 3.删除学生信息 4.修改学生信息 5.退出");
		System.out.println("--------------------------------------------------------------------");
	}
	public static void action1(student[] S){
		 Scanner scanner=new Scanner(System.in);  
			
         System.out.println("请输入1-5的数字:");
			
         int i=scanner.nextInt(); 
		  if(i==1){
			 student2(S);
		 }else if(i==2){
			inCrease(S);
		 } else if(i==3){
			delete(S);
		 } else if(i==4){
			modify(S);
		 } else if(i==5){
			System.exit(1);
		 }else{
			 System.out.println("尚未构建此功能");
			 action1(S);
		 }
	}
	public static void find1(){
		System.out.println("-------------------------查看学生信息------------------------------");
	}

	public static void student2(student[] S){
		Scanner scanner=new Scanner(System.in);  
			System.out.println("id     "+"姓名   "+" 年龄 "+" 性别 "+"  年级 "+"   地址 " +"    联系方式 "+"    电子邮箱  ");
		for(int i=0;i<S.length;i++){
			
		if(S[i] == null){
			continue;
		}
			System.out.println(" "+S[i].id+"    "+S[i].name+"     "+S[i].age+
				"    "+S[i].stx+"    "+S[i]._class+"  "+S[i].site+" "+S[i].phoneNum+"  "+S[i].email);
		}
			studentS();
			action1(S);
	}
	public static void inCrease(student[] S) {
		System.out.println("-------------------------添加学生信息------------------------------");
		Scanner scanner=new Scanner(System.in);  
		
		System.out.println("请输入学生ID：");	
		int id3=scanner.nextInt();
		for(int i=0;i<S.length;i++){	
		if(id3!=S[i].id){
		
		System.out.println("请输入学生姓名：");
		String name=scanner.next();
		
		System.out.println("请输入学生年龄：");
		int age=scanner.nextInt();
		
		System.out.println("请输入学生性别：");
		String stx=scanner.next();
		
		System.out.println("请输入学生年级：");
		String _class=scanner.next();
		
		System.out.println("请输入学生地址：");
		String site=scanner.next();
		
		System.out.println("请输入学生联系方式：");
		String phoneNum=scanner.next();
		
		System.out.println("请输入学生电子邮箱：");
		String email=scanner.next();
		student sss=new student(id3,name,age,stx,_class,site,phoneNum,email);
		
		for(int j=0;j<S.length;j++){	
				if(S[j]!=null){
					continue;
				}else{
					S[j]=sss;
					break;
				}
			}
			break;
				}
				else{
		System.out.println("已有此id，请从新输入：");
		inCrease(S);
		return;
				}
				
		}
	        studentS();
			action1(S);
	   }
	
	public static void delete(student[] S){
		Scanner scanner=new Scanner(System.in);  
		System.out.println("请输入学生ID：");	
		int id1=scanner.nextInt();	
		for(int i=0;i<S.length;i++){
			if(S[i].id==id1){
				S[i]=null;
				break;
			}
		}
		System.out.println("修改成功，系统将自动返回上一层目录");
		studentS();
		action1(S);
	}
	public static void modify(student[] S){
		Scanner scanner=new Scanner(System.in);  
		System.out.println("请输入学生ID：");	
		int id2=scanner.nextInt();
		for(int i=0;i<S.length;i++){
			if(S[i].id==id2){
		System.out.println("请重新输入学生ID：");	
		int id=scanner.nextInt();	
			
		System.out.println("请输入学生姓名：");
		String name=scanner.next();
		
		System.out.println("请输入学生年龄：");
		int age=scanner.nextInt();
		
		System.out.println("请输入学生性别：");
		String stx=scanner.next();
		
		System.out.println("请输入学生年级：");
		String _class=scanner.next();
		
		System.out.println("请输入学生地址：");
		String site=scanner.next();
		
		System.out.println("请输入学生联系方式：");
		String phoneNum=scanner.next();
		
		System.out.println("请输入学生电子邮箱：");
		String email=scanner.next();
		student ssss=new student(id,name,age,stx,_class,site,phoneNum,email);
		S[i]=ssss;
		break;
			}else {
				System.out.println("请重新输入学生账号：");
				modify(S);
			}
			
		}
	
		studentS();
		action1(S);
	}
}
class Administrators{
		public String username;
		public String password;
		
		public Administrators(String username,String password){
			this.username=username;
			this.password=password;
		}
		
		public String getUsername(){
			return username;
		}
		public void setUsername(String username){
			this.username=username;
		}
		
		public String getPassword(){
			return password;
		}
		public void setPassword(String password){
			this.password=password;
		}
	}
	
class student{
	public int id;
	public String name;
	public int age;
	public String stx;
	public String _class;
	public String site;
	public String phoneNum;
	public String email;
	public student(int id, String name,int age,String stx,String _class,String site, String phoneNum,String email){
		this.id=id;this.name=name;this.age=age;this.stx=stx;this._class=_class;
		this.site=site;this.phoneNum=phoneNum;this.email=email;
	}
	public int getId(){
		return id;
		}
	public void setId(int id){
		this.id=id;
		}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge(){
		return age;
		}
	public void setAge(int age){
		this.age=age;
		}
	public String getStx(){
		return stx;
		}
	public void setStx(String stx){
		this.stx=stx;
		}
	public String get_Class(){
		return _class;
	}
	public void set_Class(String _class){
		this._class=_class;
	}
	public String getSite(){
		return site;
	}
	public void setSite(String site){
		this.site=site;
	}
	public String getPhoneNum(){
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum){
		this.phoneNum=phoneNum;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	
}