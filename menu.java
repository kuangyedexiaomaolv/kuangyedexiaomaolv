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
	public int fillType ;//�������
	public int borderwidth; //�߿���
	
	public menu()
	{
		width=10;orgx=500;
		height=10;orgy=500;
		borderType=2;	
	}
	void Draw() {};//����ͼ��
	boolean IsMatch() {return false;};//ƥ������Ƿ�������ͼ�η�Χ�ڲ� 
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
    		System.out.println("�����λ��Ƴɹ�");
    	}
      }  
      else
    	  System.out.println("����Ĳ�������");
      scan.close();
    }
   
} 
