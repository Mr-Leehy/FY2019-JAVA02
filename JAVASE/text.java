package com.text;

public class text {
		public static void main(String[] args) {
			text t=new text();
			
			t.change("afhuiGHIOhgoihwih5486156");
		}
		public void change(String S) {
			
			int i=0;int j=0;int l=0;
			@SuppressWarnings("unused")
			char n;
			for(int m=0;m<S.length();m++) {
				n=S.charAt(m);
				if(n>=65&&n<=90) {
					i++;
				}else if(n>=97&&n<=122) {
					j++;
				}else {
					l++;
				}
			}
			System.out.println("Сд��ĸ����"+i);
			System.out.println("��д��ĸ����"+j);
			System.out.println("���ָ����ǣ�"+l);
		}
}
