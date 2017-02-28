package kr.withever.humanlibrary.domain.humanbook;

public class ServiceDay {
	private Long id;
	private String day; //Mon, Tue, Weds, Thur, Fri, Sat, Sun
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
}
