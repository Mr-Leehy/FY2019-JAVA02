import java.util.Scanner;

public class SystemA{
	
	public static void main(String[] args){
		Administrators[] A=new Administrators[5];
		//Administrators a=new Administrators();
		student[] S=new student[10]; 
		//student s=new student();
		student a=new student(1,"����  ",18,"��","�߼�","����","15848854445","2222@qq.com");
		student aa=new student(2,"С��  ",17,"Ů","�߼�","����","15848854445","2222@qq.com");
		student aaa=new student(3,"��쿡",17,"��","�߼�","����","15848854445","2222@qq.com");
		student aaaa=new student(4,"�����",21,"��","�߼�","����","15848854445","2222@qq.com");
		student aaaaa=new student(5,"������",20,"Ů","�߼�","����","15848854445","2222@qq.com");
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
		//boolean a=true;
		int a=2;
		for(int i=0;i<A.length;i++){
			
			if(s.equals(A[i].username)&&ss.equals(A[i].password)){
				System.out.println("��ӭ����"+A[i].username);
				a=1;
				break;
			}
			continue;
		}
		if(a==2){
			System.out.println("��������ȷ���˺�����");
			ergodic(A);
		}
		
	}		
	

	
	public static void studentS(){
		System.out.println("----------------------��ѡ��Ҫ�����Ķ�Ӧ��Ϣ����------------------");
		System.out.println("1.�鿴ѧ����Ϣ 2.���ѧ����Ϣ 3.ɾ��ѧ����Ϣ 4.�޸�ѧ����Ϣ 5.�˳�");
		System.out.println("--------------------------------------------------------------------");
	}
	public static void action1(student[] S){
		 Scanner scanner=new Scanner(System.in);  
			
         System.out.println("������1-5������:");
			
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
			 System.out.println("��δ�����˹���");
			 action1(S);
		 }
	}
	public static void find1(){
		System.out.println("-------------------------�鿴ѧ����Ϣ------------------------------");
	}

	public static void student2(student[] S){
		Scanner scanner=new Scanner(System.in);  
			System.out.println("id     "+"����   "+" ���� "+" �Ա� "+"  �꼶 "+"   ��ַ " +"    ��ϵ��ʽ "+"    ��������  ");
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
		System.out.println("-------------------------���ѧ����Ϣ------------------------------");
		Scanner scanner=new Scanner(System.in);  
		
		System.out.println("������ѧ��ID��");	
		int id3=scanner.nextInt();
		for(int i=0;i<S.length;i++){	
		if(id3!=S[i].id){
		
		System.out.println("������ѧ��������");
		String name=scanner.next();
		
		System.out.println("������ѧ�����䣺");
		int age=scanner.nextInt();
		
		System.out.println("������ѧ���Ա�");
		String stx=scanner.next();
		
		System.out.println("������ѧ���꼶��");
		String _class=scanner.next();
		
		System.out.println("������ѧ����ַ��");
		String site=scanner.next();
		
		System.out.println("������ѧ����ϵ��ʽ��");
		String phoneNum=scanner.next();
		
		System.out.println("������ѧ���������䣺");
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
		System.out.println("���д�id����������룺");
		inCrease(S);
		return;
				}
				
		}
	        studentS();
			action1(S);
	   }
	
	public static void delete(student[] S){
		Scanner scanner=new Scanner(System.in);  
		System.out.println("������ѧ��ID��");	
		int id1=scanner.nextInt();	
		for(int i=0;i<S.length;i++){
			if(S[i].id==id1){
				S[i]=null;
				break;
			}
		}
		System.out.println("�޸ĳɹ���ϵͳ���Զ�������һ��Ŀ¼");
		studentS();
		action1(S);
	}
	public static void modify(student[] S){
		Scanner scanner=new Scanner(System.in);  
		System.out.println("������ѧ��ID��");	
		int id2=scanner.nextInt();
		for(int i=0;i<S.length;i++){
			if(S[i].id==id2){
		System.out.println("����������ѧ��ID��");	
		int id=scanner.nextInt();	
			
		System.out.println("������ѧ��������");
		String name=scanner.next();
		
		System.out.println("������ѧ�����䣺");
		int age=scanner.nextInt();
		
		System.out.println("������ѧ���Ա�");
		String stx=scanner.next();
		
		System.out.println("������ѧ���꼶��");
		String _class=scanner.next();
		
		System.out.println("������ѧ����ַ��");
		String site=scanner.next();
		
		System.out.println("������ѧ����ϵ��ʽ��");
		String phoneNum=scanner.next();
		
		System.out.println("������ѧ���������䣺");
		String email=scanner.next();
		student ssss=new student(id,name,age,stx,_class,site,phoneNum,email);
		S[i]=ssss;
		break;
			}else {
				System.out.println("����������ѧ���˺ţ�");
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