import java.util.*;  
import java.text.*;  
import java.applet.*;  
import java.awt.*;  
public class SimpleAnalogClock extends Applet implements Runnable  
{  
    int clkhours = 0, clkminutes = 0, clkseconds = 0;  
    String clkString = "";  
    int clkwidth, clkheight;  
    Thread thr = null;  
    boolean threadSuspended;  
    public void init()  
    {  
        clkwidth = getSize().width;  
        clkheight = getSize().height;  
        setBackground(Color.black);  
    }  
    public void start()  
    {  
        if (thr == null)  
        {  
            thr = new Thread(this);  
            thr.setPriority(Thread.MIN_PRIORITY);  
            threadSuspended = false;  
            thr.start();  
        } else  
        {  
            if (threadSuspended)  
            {  
                threadSuspended = false;  
                synchronized(this)  
                {  
                    notify();  
                }  
            }  
        }  
    }  
    public void stop()  
    {  
        threadSuspended = true;  
    }  
    public void run()  
    {  
        try  
        {  
            while (true)  
            {  
                Calendar clndr = Calendar.getInstance();  
                clkhours = clndr.get(Calendar.HOUR_OF_DAY);  
                if (clkhours > 12) clkhours -= 12;  
                clkminutes = clndr.get(Calendar.MINUTE);  
                clkseconds = clndr.get(Calendar.SECOND);  
                SimpleDateFormat frmatter = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());  
                Date d = clndr.getTime();  
                clkString = frmatter.format(d);  
                if (threadSuspended)  
                {  
                    synchronized(this)  
                    {  
                        while (threadSuspended)  
                        {  
                            wait();  
                        }  
                    }  
                }  
                repaint();  
                thr.sleep(1000);  
            }  
        } catch (Exception e)  
        {}  
    }  
    void drawHand(double angle, int radius, Graphics grp)  
    {  
        angle -= 0.5 * Math.PI;  
        int a = (int)(radius * Math.cos(angle));  
        int b = (int)(radius * Math.sin(angle));  
        grp.drawLine(clkwidth / 2, clkheight / 2, clkwidth / 2 + a, clkheight / 2 + b);  
    }  
    void drawWedge(double angle, int radius, Graphics grp)  
    {  
        angle -= 0.5 * Math.PI;  
        int a = (int)(radius * Math.cos(angle));  
        int b = (int)(radius * Math.sin(angle));  
        angle += 2 * Math.PI / 3;  
        int a2 = (int)(5 * Math.cos(angle));  
        int b2 = (int)(5 * Math.sin(angle));  
        angle += 2 * Math.PI / 3;  
        int a3 = (int)(5 * Math.cos(angle));  
        int b3 = (int)(5 * Math.sin(angle));  
        grp.drawLine(clkwidth / 2 + a2, clkheight / 2 + b2, clkwidth / 2 + a, clkheight / 2 + b);  
        grp.drawLine(clkwidth / 2 + a3, clkheight / 2 + b3, clkwidth / 2 + a, clkheight / 2 + b);  
        grp.drawLine(clkwidth / 2 + a2, clkheight / 2 + b2, clkwidth / 2 + a3, clkheight / 2 + b3);  
    }  
    public void paint(Graphics grp)  
    {  
        grp.setColor(Color.gray);  
        drawWedge(2 * Math.PI * clkhours / 12, clkwidth / 5, grp);  
        drawWedge(2 * Math.PI * clkminutes / 60, clkwidth / 3, grp);  
        drawHand(2 * Math.PI * clkseconds / 60, clkwidth / 2, grp);  
        grp.setColor(Color.white);  
        grp.drawString(clkString, 10, clkheight - 10);  
        grp.drawString("C-Sharpcorner.com", 113, 300);  
    }  
}  
/*  
<applet code="SimpleAnalogClock.class" width="350" height="350">  
</applet>  
*/  