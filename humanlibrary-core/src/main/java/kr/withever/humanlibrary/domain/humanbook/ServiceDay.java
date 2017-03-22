package kr.withever.humanlibrary.domain.humanbook;

import kr.withever.humanlibrary.domain.common.DayOfWeek;

public class ServiceDay {
	
	private String day;

	public ServiceDay(){
	}

	public ServiceDay(DayOfWeek day){
		this.setDay(day.getName());
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
}
