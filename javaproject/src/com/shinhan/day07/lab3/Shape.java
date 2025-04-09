package com.shinhan.day07.lab3;

public abstract class Shape {
	
	int numSides;
	Shape(int numSides){
		this.numSides = numSides;
	}
	public int getNumSides() {
		return numSides;
	}

	abstract double getArea();
	abstract double getPerimeter();
	
	
}
