import java.util.Scanner;

public class SystemA{
	
	public static void main(String[] args){
		Administrators[] A=new Administrators[5];
		//Administrators a=new Administrators();
		student[] S=new student[5]; 
		//student s=new student();
		sign();
		find();
		contain(A);   
		ergodic(A);
		action();
		studentS();
		action1();
		find1();
		student1(S);
		student2(S);
		
	}
	public static void sign(){
		System.out.println("----------��ӭ��¼ѧ������ϵͳ----------");
		System.out.println("1.��¼      2.�˳�");
		System.out.println("-----------------------------------------");
			
			
	}
	
	public static void find(){
		    Scanner scanner=new Scanner(System.in);  
			
            System.out.println("������1��2:");
			
            int i=scanner.nextInt(); 
			if(i==1){
				System.out.println("��ӭ��¼");
			}else if(i==2){
				System.exit(1);
			}else{
				System.out.println("������һ����ȷ�����֣�");
				find();
			}
	}
	

	public static void contain(Administrators[] A){
		
			Administrators a=new Administrators("������","admin");
			Administrators aa=new Administrators("���޼�","admin");
			Administrators aaa=new Administrators("����","admin");
			Administrators aaaa=new Administrators("����","admin");
			Administrators aaaaa=new Administrators("������","admin");
			A[0] = a;
			A[1] = aa;
			A[2] = aaa;
			A[3] = aaaa;
			A[4] = aaaa;
			
	}

	public static void ergodic( Administrators[] A){
		Scanner scanner=new Scanner(System.in);  
 
		System.out.println("���������Ա�˺ţ�");
			
        String s=scanner.nextLine(); 
				
		System.out.println("���������Ա���룺");	

		String ss=scanner.nextLine();
		
		for(int i=0;i<A.length;i++){
			
			if(s.equals(A[i].username)&&ss.equals(A[i].password)){
				System.out.println("��ӭ����"+A[i].username);
				break;
			}
			
		}
		boolean a=true;
		boolean b=false;
			for(int i=0;i<A.length;i++){	
			if(s.equals(A[i].username)&&ss.equals(A[i].password)==b){
				System.out.println("���������룺");
				ergodic(A);
				break;}
		}
	}		
	

	public static void action(){
		System.out.println("----------------------��ѡ��Ҫ�����Ķ�Ӧ��Ϣ����------------------");
	}
	public static void studentS(){
		System.out.println("1.�鿴ѧ����Ϣ 2.���ѧ����Ϣ 3.ɾ��ѧ����Ϣ 4.�޸�ѧ����Ϣ 5.�˳�");
		System.out.println("--------------------------------------------------------------------");
	}
	public static void action1(){
		 Scanner scanner=new Scanner(System.in);  
			
         System.out.println("������1-5������:");
			
         int i=scanner.nextInt(); 
		 if(i==1){
			 
		 }else{
			 
		 }
	}
	public static void find1(){
		System.out.println("-------------------------�鿴ѧ����Ϣ------------------------------");
	}
	public static void student1(student[] S){
		student a=new student(1,"����",18,"��","�߼�","����","15848854445","2222@qq.com");
		student aa=new student(1,"С��",17,"Ů","�߼�","����","15848854445","2222@qq.com");
		student aaa=new student(1,"��쿡",17,"��","�߼�","����","15848854445","2222@qq.com");
		student aaaa=new student(1,"�����",21,"��","�߼�","����","15848854445","2222@qq.com");
		student aaaaa=new student(1,"������",20,"Ů","�߼�","����","15848854445","2222@qq.com");
		S[0]=a;
		S[1]=aa;
		S[2]=aaa;
		S[3]=aaaa;
		S[4]=aaaaa;
	}

	public static void student2(student[] S){
		Scanner scanner=new Scanner(System.in);  
			
            System.out.println("������0-4������");
			
            int ii=scanner.nextInt(); 
		for(int i=0;i<S.length;i++){
			if(ii==i){
				System.out.println(S);
				break;
			}else{
				System.out.println("��������ȷ����");
				student2(S);
			}
		}
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
	public student(int id, String name,int age,String stx,String _class,String site1, String phoneNum,String email){
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