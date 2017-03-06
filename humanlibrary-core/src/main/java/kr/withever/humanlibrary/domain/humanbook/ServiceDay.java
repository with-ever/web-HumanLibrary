package kr.withever.humanlibrary.domain.humanbook;

import kr.withever.humanlibrary.domain.common.DayOfWeek;

public class ServiceDay {
	
	private String dayId;

	public ServiceDay(){
	}

	public ServiceDay(DayOfWeek day){
		this.setDayId(day.getName());
	}

	public String getDayId() {
		return dayId;
	}

	public void setDayId(String dayId) {
		this.dayId = dayId;
	}
}
