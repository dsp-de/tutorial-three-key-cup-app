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
package exercise;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import exercise.gui.ProblemReporter;
import exercise.gui.Canvas;
import exercise.model.RelocatableCup;
import exercise.model.RelocatableSmoke;
import exercise.model.ResizableSmoke;
import exercise.model.RotatableCup;
import exercise.model.ShapeList;

public class CupApp {

	private static JFrame frame;

	public static void main(final String[] args) {
		Canvas canvas = new Canvas();

		ProblemReporter reporter = new ProblemReporter();
		frame = new JFrame("Three Key Cup App (Use: 1, 2, SPACE)");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				System.exit(0);
			}
		});

		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		content.add(canvas, BorderLayout.CENTER);
		content.add(reporter, BorderLayout.SOUTH);

		ShapeList list = ShapeList.getInstance();

		RelocatableCup cup = new RotatableCup(canvas, reporter);
		cup.relocate(0.0, 0.5 * Math.random());
		list.addShape(cup);

		RelocatableSmoke smoke = new ResizableSmoke(canvas, reporter);
		smoke.relocate(-0.1 * Math.random(), -0.35);
		list.addShape(smoke);

		frame.pack();
		frame.setVisible(true);
	}
}
