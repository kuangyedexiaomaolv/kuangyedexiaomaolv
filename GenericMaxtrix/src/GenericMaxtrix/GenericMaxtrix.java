package GenericMaxtrix;
import java.util.Scanner;
abstract class GenericMatrix<T extends Number>{
	protected abstract T add(T x1,T x2);
	protected abstract T multiply(T x1,T x2);
	protected abstract T zero();
	public T[][] addMatrix(T[][] matrix1,T[][] matrix2){

		T[][] result =(T[][]) new Number[matrix1.length][matrix1[0].length];
		for(int i=0;i<matrix1.length;i++)
			for(int j=0;j<matrix1[0].length;j++)
			{
              result[i][j]=add(matrix1[i][j],matrix2[i][j]);   
            
			}
		return result;
		
	 }
	
	public T[][] multiplyMatrix(T[][] matrix1,T[][] matrix2){
		T[][] ts = (T[][])new Number[matrix1.length][matrix2[0].length];
		T[][] result=ts;
		System.out.println(matrix1.length+" "+matrix2[0].length+" "+matrix1[0].length);
		for(int i=0;i<matrix1.length;i++)
		{   
			for(int j=0;j<matrix2[0].length;j++)
			{       
				   result[i][j] = zero();
				    for(int k=0;k<matrix1[0].length;k++)
				    {
				      result[i][j]=add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
				    }
		    }
		}
		return result;
	}
	
	public  static void printMatrix(Number[][] matrix1 ,Number[][] matrix2 ,Number[][] matrix) {
		System.out.println("¾ØÕó1");
		for(int i=0;i<matrix1.length;i++)
		{
			for(int j=0;j<matrix1[0].length;j++)
			{
				System.out.print(matrix1[i][j]+" ");
			}
			System.out.println();
					
		}
		System.out.println("¾ØÕó2");
		for(int i=0;i<matrix2.length;i++)
		{
			for(int j=0;j<matrix2[0].length;j++)
			{
				System.out.print(matrix2[i][j]+" ");
			}
			
			System.out.println();		
		}
		System.out.println("ÔËËãºóµÄ¾ØÕóÊÇ:");
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
		System.out.println();
	}
	}

}

















