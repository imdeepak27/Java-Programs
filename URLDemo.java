import java.net.*;
public class URLDemo{
	public static void main(String[] args){
		try{
			URL url = new URL("http://www.javapoint.com/java-tutorial");
			System.out.println("Protocol:"+url.getProtocol());
			System.out.println("HostName:"+url.getHost());
			System.out.println("PortNumber:"+url.getPort());
			System.out.println("FileName:"+url.getFile());
		}catch(Exception e){
			System.out.println(e);
		}
	}
}