package com.neuedu.service.impl;
import java.util.HashMap;
import java.util.Map;

import com.neudeu.Admin.Const;
import com.neudeu.Admin.Student;
import com.neudeu.common.ServerResponse;
import com.neuedu.service.IStudentService;
public class StudentServiceImpl implements IStudentService{
	
	//List<Student> list=new ArrayList<Student>();
	Map<Integer,Student> map=new HashMap<Integer,Student>();
	private static StudentServiceImpl StudentServiceImpl;
	public synchronized static StudentServiceImpl getInstance() {
		if(StudentServiceImpl==null) {
			StudentServiceImpl=new StudentServiceImpl();
		}
		return StudentServiceImpl;
		
	}
	private StudentServiceImpl() {
		Student student=new Student(1,"����  ",18,50);
		Student student1=new Student(2,"С��  ",17,60);
		Student student2=new Student(3,"��쿡",17,90);
		Student student3=new Student(4,"�����",21,20);
		Student student4=new Student(5,"������",20,100);
		
		map.put(student.getId(),student);
		map.put(student1.getId(),student1);
		map.put(student2.getId(),student2);
		map.put(student3.getId(),student3);
		map.put(student4.getId(),student4);
	}
	@Override
	public Map<Integer,Student> findAll() {
		// TODO Auto-generated method stub
		
		
		System.out.println("\t"+"id"+"\t"+"����"+"\t"+"����"+"\t"+"����");
		return map;
	}
	@Override
	public ServerResponse<Student> findStudentById(int id) {
		// TODO Auto-generated method stub
		
		if(map.containsKey(id)) {
			Student student=map.get(id);
		}else {
			return ServerResponse.CreateServerResponseByFile(Const.NO_HAVE_INTEGER, "��ID������");
		}
		
		
		return ServerResponse.CreateServerResponseBySucess("�鿴ID�ɹ�",map.get(id));
	}
	
	@Override
	public ServerResponse<Student> Add(int id3, String name,int age,int sorce) {
		// TODO Auto-generated method stub
			
			/*for(int i=0;i<list.size();i++){	
			
			if(id3!=list.get(i).id){
				continue;
			}else {
				System.out.println("���д�id����������룺");
				
				return list;
			}
		
			
		 }*/
		
		if(map.containsKey(id3)){
			return ServerResponse.CreateServerResponseByFile(Const.HAVE_INTEGER,"��ID�Ѿ�����");
		}else {
			Student sss=new Student(id3,name,age,sorce);
			
			//list.add(sss);
			map.put(id3, sss);
		}
			
		
		return ServerResponse.CreateServerResponseBySucess("��ӳɹ�"); 
	
	}
	@Override
	public ServerResponse<Student> deleteStudentById(int id2) {
		// TODO Auto-generated method stub
		
		if(map.containsKey(id2)) {
			Student student=map.remove(id2);
		}else {
			return ServerResponse.CreateServerResponseByFile(Const.HAVE_INTEGER,"��ID�Ѿ�����");
		}
		
		return ServerResponse.CreateServerResponseBySucess("ɾ���ɹ�");
	}
	@Override
	public ServerResponse<Student> upDataById(int id1, String name, int age, int sorce) {
		// TODO Auto-generated method stub
		if(map.containsKey(id1)) {
			Student s=new Student(id1,name,age,sorce);
			map.put(id1,s);
			return  ServerResponse.CreateServerResponseBySucess("�ı�ɹ�",map.put(id1,s));
		}else {
			return ServerResponse.CreateServerResponseByFile(Const.NO_HAVE_INTEGER, "��ID������");
		}
		
		
		
	}
	
	

			
}
