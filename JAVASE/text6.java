package com.text;

public class text6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			text6 t=new text6();
			t.pan();
	}
	public void pan() {
		String S=("bdmnnmdb");
		int x=0;
		int y=S.length()-1;
		char[]c=S.toCharArray();
		while(c[x++]==c[y--]){
			if(c[x]!=c[y]) 
			{
				System.out.println("这个字符串是不对称的");
				break;
			}
			else if(c[x]==c[y]) {
				System.out.println("这个字符串是对称的");
				return;
				
			}
			
			
		}
		
			System.out.println("这个字符串是不对称的");
	
		
	}

}
