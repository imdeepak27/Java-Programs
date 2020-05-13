import java.util.Scanner;
class Aimb{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Two Numbers : ");
		int a=s.nextline();
		int b=s.nextline();
		if(a>b)
			System.out.println(a+"Is Greater");
		else
			System.out.println(b+"Is Greater");
	}
}