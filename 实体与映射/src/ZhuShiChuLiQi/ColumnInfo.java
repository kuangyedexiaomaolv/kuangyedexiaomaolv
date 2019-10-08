package ZhuShiChuLiQi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class ColumnInfo {
  private String columName;//字段名称
  private Class<?>type;//字段类型
  private boolean isID=false;//是否是逐渐
  private boolean nullale=true;//是否可以为空
  private int length=32;//字段长度
  private boolean needPersist=false;//该字段是否需要保存到数据库
  public  static ColumnInfo parse(Field field) {
	  ColumnInfo columninfo=new ColumnInfo();
        columninfo.columName=field.getName();
        columninfo.type=field.getType();
        Annotation[] annotations=field.getAnnotations();
        for(Annotation annotation:annotations) {
        	if(annotation.annotationType().equals(Column.class)) {
        		columninfo.needPersist=true;
        		Column column=(Column)annotation;
        		if(!column.value().equals("")) {//若value不为空则将字符段设置成注解value的参数值
        			columninfo.columName=column.value();
        		}columninfo.nullale=column.nullable();
        		if(column.length()!=-1) {
        			columninfo.length=column.length();//若length不为空则设置字段的长度值
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
