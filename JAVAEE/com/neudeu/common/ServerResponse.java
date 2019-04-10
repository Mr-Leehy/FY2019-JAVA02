package com.neudeu.common;

import com.google.gson.Gson;

public class ServerResponse<T> {
		private int status;
		private String msg;
		private T data;
		
		private ServerResponse() {}
		private ServerResponse(int status) {
			this.status=status;
		}
		private ServerResponse(int status,String msg) {
			this.status=status;
			this.msg=msg;
		}
		private ServerResponse(int status,T data) {
			this.status=status;
			this.data=data;
		}
		private ServerResponse(int status,String msg,T data) {
			this.status=status;
			this.msg=msg;
			this.data=data;
		}
		/*
		 * ³É¹¦
		 * 
		 * **/
		
		public  String Obj2Str() {
			Gson  gson=new Gson();
			String responsetext= gson.toJson(this);
			return responsetext;
		} 
		
		
		
		public boolean isSucess() {
			return this.status==0;
		}
		
		
		
		public  static ServerResponse CreateServerResponseBySucess() {
			return new ServerResponse(0);
		}
		public static ServerResponse CreateServerResponseBySucess(String msg) {
			return new ServerResponse(0,msg);
		}
		public static <T> ServerResponse CreateServerResponseBySucess(T data) {
			return new ServerResponse(0,data);
		}
		public static <T> ServerResponse CreateServerResponseBySucess(String msg,T data) {
			return new ServerResponse(0,msg,data);
		}
		/**
		 * Ê§°Ü
		 * */
		public static ServerResponse CreateServerResponseByFile(int status) {
			return new ServerResponse(status);
		}
		public static ServerResponse CreateServerResponseByFile(int status,String msg) {
			return new ServerResponse(status,msg);
		}
		
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
	
}
