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
package exercise.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import exercise.basic.PolyLine;
import exercise.basic.Vertex;
import exercise.model.Shape;
import exercise.model.ShapeList;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;

	private int current = 0;

	public Canvas() {
		this.setFocusable(true);
		this.addKeyListener(ShapeList.getInstance().getKeyAdapter());
	}

	public void redrawShapes() {
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		for (int i = 0; i < ShapeList.getInstance().getSize(); i++) {
			Shape shape = ShapeList.getInstance().getShape(i);
			g.setColor(i == current ? Color.RED : Color.BLUE);
			for (int j = 0; j < shape.getPolyLineCount(); j++) {
				drawPolyLine(g, shape.getPolyLine(j));
			}
		}
	}

	private void drawPolyLine(Graphics g, PolyLine pl) {
		int n = pl.getLength();
		int[] xcords = new int[n];
		int[] ycords = new int[n];
		for (int i = 0; i < n; i++) {
			Vertex v = pl.getVertexAt(i);
			xcords[i] = (int) ((1.0 + v.x) * getWidth() / 2);
			ycords[i] = (int) ((1.0 + v.y) * getHeight() / 2);
		}
		g.drawPolyline(xcords, ycords, n);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(350, 350);
	}
}