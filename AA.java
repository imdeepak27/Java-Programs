class A extends Thread{
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(i);
		}
	}
}
class B extends Thread{
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(i);
		}
	}
}
public class AA {
	public static void main(String args[]){
		new A().start();
		new B().start();
		new C().start();
	}
}