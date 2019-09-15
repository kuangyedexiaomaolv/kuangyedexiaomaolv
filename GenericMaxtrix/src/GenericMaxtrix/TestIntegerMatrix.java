package GenericMaxtrix;
import java.util.Scanner;
public class TestIntegerMatrix {
    Scanner scan=new Scanner(System.in);
	public static void main(String[] args){
		IntegerMatrix integer=new IntegerMatrix();
		Integer[][] matrix1=new Integer[][] {{1,2,3},{1,2,3}};
		Integer[][] matrix2=new Integer[][] {{1,2,3},{1,2,3}};
		GenericMatrix.printMatrix(matrix1,matrix2,integer.addMatrix(matrix1, matrix2));   
		
		//整形矩阵的乘法
		Integer[][] matrix3=new Integer[][] {{1,2,3},{1,2,3}};
		Integer[][] matrix4=new Integer[][] {{1,2},{1,2},{1,2}};
		GenericMatrix.printMatrix(matrix3,matrix4,integer.multiplyMatrix(matrix3, matrix4));   
	}

}
