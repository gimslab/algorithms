package com.gimslab.dipexam_impl;

import com.gimslab.dipexam_abs.Shape;
import com.gimslab.dipexam_abs.ShapeFactory;

public class ShapeFactoryImpl implements ShapeFactory {
	@Override
	public Shape makeSquare() {
		return new Square();
	}

	@Override
	public Shape makeCircle() {
		return new Circle();
	}
}
