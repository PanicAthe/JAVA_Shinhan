package com.shinhan.day07.lab3;

public class RectTriangle extends Shape {

	RectTriangle(double w, double h) {
		super(3);
		this.width = w;
		this.height = h;
	}

	double width;
	double height;

	@Override
	double getArea() {
		return this.width * this.height / 2;
	}

	@Override
	double getPerimeter() { 
		return this.width + this.height + Math.sqrt(this.width*this.width+this.height*this.height);
	}

}
