package main;

public class EjercicioSerie1 {
	
public static void main(String[] args) {
	
	int num1=0,num2=1,aux;
	
	System.out.println(num1+"\n"+num2);
	
	for(int i = 2;i<=19;i ++) {
		aux=num2+num1;
		System.out.println(aux);
		num1=num2;
		num2=aux;
		
		
	}
}
}
