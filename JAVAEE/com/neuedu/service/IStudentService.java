package com.neuedu.service;


import java.util.Map;

import com.neudeu.Admin.Student;
import com.neudeu.common.ServerResponse;

public interface IStudentService {
		public Map<Integer,Student> findAll();
		public ServerResponse<Student> Add(int id3, String name,int age,int sorce);
		public ServerResponse<Student> findStudentById(int id);
		public ServerResponse<Student> deleteStudentById(int id2);
		public ServerResponse<Student> upDataById(int id1, String name, int age, int sorce);
		
		
}
