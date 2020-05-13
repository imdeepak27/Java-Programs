class Q
{
	synchronized int get()
	{
		System.out.println("Got : "+n);
		return n;
	}
	synchronized void put(int n)
	{
		this.n=n;
		System.out.println("Put : "+n);
	}
}
class Producer implements Runnable{
	Qq;
	Producer(Qq)
	{
		this.q=q;
		new Thread(this,"Producer")
	}
	public void run()
	{
		int i=0;
		while(true)
		{
			q.put(i++);
		}
	}
}
class Consumer implements Runnable
;{
	Qq;
	Consumer(Qq)
	{
		this.q=q;
		new Thread(this,"Consumer").start();
	}
	public void run()
	{
		while(true)
		{
			q.get();
		}
	}
}
class CP
{
	public class void main(String[]args)
	{
		Qq=new Q();
		new Producer(q);
		new Consumer(q)
	}
}