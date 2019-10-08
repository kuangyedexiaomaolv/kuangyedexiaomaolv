package ZhuShiChuLiQi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class ColumnInfo {
  private String columName;//�ֶ�����
  private Class<?>type;//�ֶ�����
  private boolean isID=false;//�Ƿ�����
  private boolean nullale=true;//�Ƿ����Ϊ��
  private int length=32;//�ֶγ���
  private boolean needPersist=false;//���ֶ��Ƿ���Ҫ���浽���ݿ�
  public  static ColumnInfo parse(Field field) {
	  ColumnInfo columninfo=new ColumnInfo();
        columninfo.columName=field.getName();
        columninfo.type=field.getType();
        Annotation[] annotations=field.getAnnotations();
        for(Annotation annotation:annotations) {
        	if(annotation.annotationType().equals(Column.class)) {
        		columninfo.needPersist=true;
        		Column column=(Column)annotation;
        		if(!column.value().equals("")) {//��value��Ϊ�����ַ������ó�ע��value�Ĳ���ֵ
        			columninfo.columName=column.value();
        		}columninfo.nullale=column.nullable();
        		if(column.length()!=-1) {
        			columninfo.length=column.length();//��length��Ϊ���������ֶεĳ���ֵ
        		}
        	}else if(annotation.annotationType().equals(ID.class)) {
        		columninfo.needPersist=true;
        		ID id=(ID)annotation;
        		columninfo.isID=true;
        		if(!id.value().equals("")) {
        			columninfo.columName=id.value();
        		}
        	}
        }
        if(columninfo.needPersist) {
        	return columninfo;
        }
        else
        {
        	return null;
        }
	};
	@Override
	public String toString() {
		StringBuilder sql=new StringBuilder(this.columName);
		if(this.type.equals(String.class)) {
			sql.append(Symbol.BLANK+"VARCHAR("+this.length+")");
			
		}else if(this.type.equals(Integer.class)) {
			sql.append(Symbol.BLANK+"INT");
		}
		if(this.isID) {
			sql.append(Symbol.BLANK+"NOT NULL");
		}
		if(!this.nullale) {
			sql.append(Symbol.BLANK+"not NULL");
			
		}
		sql.append(";");
		return sql.toString();
	}
	  
	
	
}
