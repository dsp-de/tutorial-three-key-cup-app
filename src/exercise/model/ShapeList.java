/**
 * "Three Key Cup App" demonstrates design flaws for educational purposes.
 * Copyright (C) 2005-2013 Lukas Degener, Daniel Speicher, University of Bonn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package exercise.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class ShapeList {

	private static ShapeList instance;

	public static ShapeList getInstance() {
		if (instance == null) {
			instance = new ShapeList();
		}
		return instance;
	}

	private Vector<Shape> shapes = new Vector<Shape>();

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public void replaceShape(Shape oldShape, Shape shape) {
		int i = shapes.indexOf(oldShape);
		if (i == -1) {
			addShape(shape);
			return;
		}
		shape.setCanvas(oldShape.getCanvas());
		shape.setReporter(oldShape.getReporter());
		shape.setPolylines(oldShape.getPolylines());
		shapes.set(i, shape);
	}

	public Shape getShape(int i) {
		return shapes.get(i);
	}

	public int getSize() {
		return shapes.size();
	}

	private int current = 0;

	private KeyAdapter keyAdapter = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			if (code == KeyEvent.VK_SPACE) {
				cycleCurrent();
			} else {
				handleKeyChar(e.getKeyChar());
			}
		}

		private void cycleCurrent() {
			Shape currentShape = (Shape) shapes.get(current);
			if (currentShape instanceof RotatableCup) {
				replaceShape(currentShape, new HorizRelocatableCup());
			} else if (currentShape instanceof HorizRelocatableCup) {
				replaceShape(currentShape, new VertRelocatableCup());
			} else if (currentShape instanceof VertRelocatableCup) {
				replaceShape(currentShape, new RotatableCup());
				current++;
				if (current == shapes.size())
					current = 0;
			} else if (currentShape instanceof ResizableSmoke) {
				replaceShape(currentShape, new HorizRelocatableSmoke());
			} else if (currentShape instanceof HorizRelocatableSmoke) {
				replaceShape(currentShape, new VertRelocatableSmoke());
			} else if (currentShape instanceof VertRelocatableSmoke) {
				replaceShape(currentShape, new ResizableSmoke());
				current++;
				if (current == shapes.size())
					current = 0;
			}
			currentShape.getCanvas().redrawShapes();
		}

		private void handleKeyChar(char keyChar) {
			if (current < 0) {
				return;
			}
			Shape shape = shapes.get(current);
			shape.handleKeyChar(keyChar);
		}

	};

	public KeyAdapter getKeyAdapter() {
		return keyAdapter;
	}

}
