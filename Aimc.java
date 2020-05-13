import java.util.Scanner;
class Aimc
{
	public static void main(String args[])
	{
		int temp,arm=0,c,rem;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter The Number : ");
		int a = S.nextline();
		temp = a;
		do{
			rem=temp%10;
			arm=arm+(int)Math.pow(rem,3);
			temp=temp/10;
		}
		while(temp!=0);
		{
			if (arm==a)
				System.out.println("Entered  Number Is Armstrong Number");
			else
				System.out.println("It Is Not A Armstrong Number");
		}
	}
}