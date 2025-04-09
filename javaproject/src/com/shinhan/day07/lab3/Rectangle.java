package com.shinhan.day07.lab3;

public class Rectangle extends Shape implements Resizable {

	double width;
	double height;

	Rectangle(double w, double h) {
		super(4);
		this.width = w;
		this.height = h;
	}

	@Override
	double getArea() {
		return width*height;

	}

	@Override
	double getPerimeter() {
		return 2*(width + height);
	}

	@Override
	public void resize(double s) {
		this.width *= s;
		this.height *= s;

	}

}
