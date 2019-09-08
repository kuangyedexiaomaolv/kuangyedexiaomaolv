package drawing;
import  java.util.Scanner;
enum ElementType{NOTSET, SQUARE,RECTANGLE,CIRCLE,ELLIPSE,TRIANGLE,TEXT};
public  class menu 
{
	
	public float width;
	public float height;
	public float orgx;
	public float orgy;
	public int borderType;
	public int fillType ;//填充类型
	public int borderwidth; //边框宽度
	
	public menu()
	{
		width=10;orgx=500;
		height=10;orgy=500;
		borderType=2;	
	}
	void Draw() {};//绘制图形
	boolean IsMatch() {return false;};//匹配鼠标是否落在了图形范围内部 
    public static void main(String[] args)
    {
      
      int option;
      Scanner scan=new Scanner(System.in);
      
      if(scan.hasNextInt())
      {
    	 option=scan.nextInt();
    	 System.out.println(option);
    	if(option==0)
    	{
    		System.out.println("正方形绘制成功");
    	}
      }  
      else
    	  System.out.println("输入的不是整数");
      scan.close();
    }
   
} 
