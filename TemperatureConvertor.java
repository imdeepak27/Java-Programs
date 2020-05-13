import java.util.Scanner;
public class TemperatureConvertor
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Temperature In Degree Celsius : ");
		float C = in.nextFloat();
		float F = C*(9f/5)+32;
		System.out.println(C + " Degree Celsius Is Equal To " + F + " Degree Fahrenheit. ");
	}
}