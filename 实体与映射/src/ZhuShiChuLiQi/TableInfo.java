package ZhuShiChuLiQi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

public class TableInfo {
 private String tableName;//�������
 private Class<?>clazz ;//�ñ��Ӧ��ʵ��������Ϣ��
 private boolean needPersist=false;//�Ƿ���Ҫ�־û��洢
 private HashMap<String,ColumnInfo> columns=new HashMap<String,ColumnInfo>();//�ñ������ֶε���Ϣ
  
 
 public  static TableInfo parse(Class<?> clazz) {
	 TableInfo table=new TableInfo();
	 table.clazz=clazz;
	 table.tableName=table.clazz.getSimpleName();
	 Annotation[] annotations=(Annotation[]) table.clazz.getAnnotatedInterfaces();
	 for(Annotation annotation: annotations)
	 {
		 if(annotation.annotationType().equals(Entity.class)) {
			 table.needPersist=true;
			 Entity entity=(Entity)annotation;
			 if(!entity.value().equals("")) {
				 table.tableName=entity.value();
				 
			 }
			 break;
		 }
	 }
	 if(table.needPersist)
	 {
		 Field[] fields=table.getClass().getDeclaredFields();
		 for(Field field:fields) {
			 ColumnInfo column=new ColumnInfo();
			 column=column.parse(field);
			 if(column!=null) {
				 table.columns.put(field.getName(), column);
			 }
		 }
		 return table;
		 
	 }
	 else
       	 return null;
 }
 @Override
 public String toString() {
	 StringBuilder sql=new StringBuilder();
	 sql.append(Symbol.LINE);
	 sql.append("CREATE TABLE ");
	 sql.append(this.tableName+Symbol.BLANK);
	 sql.append("(");
	 for(ColumnInfo column:this.columns.values()) {
		 sql.append(Symbol.LINE);
		 sql.append(Symbol.TAB);
		 sql.append(column.toString());
		 
	 }
	 sql.append(Symbol.LINE);
	 sql.append(")");
	 return sql.toString();
 }
}
