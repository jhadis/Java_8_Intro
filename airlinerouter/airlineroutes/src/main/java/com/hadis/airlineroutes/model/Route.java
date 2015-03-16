package com.hadis.airlineroutes.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Stores two points in an airline route
 * @author Jonathan
 *
 */
public class Route {

	ToStringBuilder toStringUtil = new ToStringBuilder(this);
	
	public Route(String start, String end) {
		/*this.setStartingPoint(start);
		this.setEndingPoint(end);
		*/
		this.startingPoint = start;
		this.endingPoint = end;
	}
	
	private String startingPoint = null;
	private String endingPoint = null;
	public String getStartingPoint() {
		return startingPoint;
	}
	/*
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	*/
	public String getEndingPoint() {
		return endingPoint;
	}
	/*
	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}
	*/
	@Override
	public String toString() {
		toStringUtil.append("Point 1", this.startingPoint).append("Point 2", this.endingPoint);
		return toStringUtil.build();
	}
	
	
}
