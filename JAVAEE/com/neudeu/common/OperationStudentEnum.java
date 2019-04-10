package com.neudeu.common;

public enum OperationStudentEnum {
	STUDENT_FINDALL(1,"查看全部学生信息"),
	STUDENT_FINDSTUDENTBYID(2,"通过ID查询学生信息"),
	STUDENT_ADD(3,"增加学生信息"),
	STUDENT_UPDATABYID(4,"通过ID改变学生信息"),
	STUDENT_DELETEBYID(5,"删除学生信息通过ID")
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
