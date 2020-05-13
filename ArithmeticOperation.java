import java.util.Scanner;
public class ArithmeticOperation
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter First Number : ");
		int a = in.nextInt();
		System.out.println("Enter Second Number : ");
		int b = in.nextInt();

		int sum = a+b;
		int difference = a-b;
		int product = a*b;
		int quotient = a/b;
		int modulo = a%b;

		System.out.println("Sum : " +sum);
		System.out.println("Difference : " +difference);
		System.out.println("Product : " +product);
		System.out.println("Quotient : "+quotient);
		System.out.println("Modulo : "+modulo);

	}
}