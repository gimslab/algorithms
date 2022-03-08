package com.gimslab.dipexam_abs;

import com.gimslab.dipexam_impl.ShapeFactoryImpl;

public class SomeApp {
	public static void main(String[] args) {
		System.out.println("hi");
		ShapeFactory shapeFactory = new ShapeFactoryImpl();
		Shape square = shapeFactory.makeSquare();
		Shape circle = shapeFactory.makeCircle();
		System.out.println(square.name());
		System.out.println(circle.name());
	}
}
