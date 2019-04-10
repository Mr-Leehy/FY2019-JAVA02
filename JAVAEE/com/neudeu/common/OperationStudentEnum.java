package com.neudeu.common;

public enum OperationStudentEnum {
	STUDENT_FINDALL(1,"�鿴ȫ��ѧ����Ϣ"),
	STUDENT_FINDSTUDENTBYID(2,"ͨ��ID��ѯѧ����Ϣ"),
	STUDENT_ADD(3,"����ѧ����Ϣ"),
	STUDENT_UPDATABYID(4,"ͨ��ID�ı�ѧ����Ϣ"),
	STUDENT_DELETEBYID(5,"ɾ��ѧ����Ϣͨ��ID")
	;
	private int operation_type;
	private String operation_desc;
	OperationStudentEnum(int operation_type,String operation_desc){
				this.operation_type=operation_type;
				this.operation_desc=operation_desc;
		}
	public int getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(int operation_type) {
		this.operation_type = operation_type;
	}
	public String getOperation_desc() {
		return operation_desc;
	}
	public void setOperation_desc(String operation_desc) {
		this.operation_desc = operation_desc;
	}
}
