package ZhuShiChuLiQi;

 

public class Person {
    @Entity("People")
	@ID
	@Column(nullable=false)
	private Integer id;
    @Column(nullable=false,length=16)
    private String name;
    public  Integer getID() {
    	return id;
    }
    public  void SsetID(Integer id) {
    	this.id=id;
    }
	public String getName() {
		return name;
	}
	public   void setName(String  name) {
		this.name=name;
	}
}
