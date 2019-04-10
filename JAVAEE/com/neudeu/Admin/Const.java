package com.neudeu.Admin;

/**
 * 常量类
 * */
public class Const {

	//用户名不能为空
	public static final int  USERNAME_NOT_NULL=10;
	//密码不能为空
	public static final int  PASSWORD_NOT_NULL=11;
	//用户名不存在
    public static final int  USERNAME_NOT_EXISTS=12;
    //密码错误
    public static final int  PASSWORD_ERROR=13;
    //两次输入的密码不一致
    public static final int TWO_PASSWORD_INCONSISTENCIES=14; 
    //已经有此ID
    public static final int HAVE_INTEGER=15;
    //此ID不存在
    public static final int NO_HAVE_INTEGER=16;
}
