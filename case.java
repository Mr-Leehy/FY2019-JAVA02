
/*
public class case1{
	public static void main(String[] args){
	 
	for(int i=100;i<=999;i++){
		int num1=i%10;
		int num2=i/10%10;
		int num3=i/100;
		int result=num1*num1*num1+num2*num2*num2+num3*num3*num3;
		if(result==i){
			System.out.println(i);
		}
	}
	}
}*/



public class case1{
	public static void main(String[] args){
		int i=100;
		while(i<=999){
		int num1=i%10;
		int num2=i/10%10;
		int num3=i/100;
		int result=num1*num1*num1+num2*num2*num2+num3*num3*num3;
		if(result==i){
			System.out.println(i);
		}
		i++;
		}
	}
}



/*public class case1{
public static void main(String[] args){
	int i=100;
	do{
	int num1=i%10;
		int num2=i/10%10;
		int num3=i/100;
		int result=num1*num1*num1+num2*num2*num2+num3*num3*num3;
		if(result==i){
			System.out.println(i);
	}
	i++;
	}
		while(i<=999);
	
}
}*/