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
				System.out.println("����ַ����ǲ��ԳƵ�");
				break;
			}
			else if(c[x]==c[y]) {
				System.out.println("����ַ����ǶԳƵ�");
				return;
				
			}
			
			
		}
		
			System.out.println("����ַ����ǲ��ԳƵ�");
	
		
	}

}
