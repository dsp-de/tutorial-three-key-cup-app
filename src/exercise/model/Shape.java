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

import java.util.List;
import java.util.Vector;

import exercise.basic.PolyLine;
import exercise.basic.Vertex;
import exercise.gui.Canvas;
import exercise.gui.ProblemReporter;

public abstract class Shape {

	private List<PolyLine> polylines = new Vector<PolyLine>();

	private Canvas canvas;

	private ProblemReporter reporter;

	public abstract String getName();

	@Override
	public String toString() {
		return getName();
	}

	public Shape() {
		canvas = null;
		reporter = null;
	}

	public Shape(Canvas c, ProblemReporter reporter) {
		this.canvas = c;
		this.reporter = reporter;
	}

	public PolyLine getPolyLine(int i) {
		return getPolylines().get(i);
	}

	public int getPolyLineCount() {
		return getPolylines().size();
	}

	public void addPolyLine(PolyLine p) {
		if (!getPolylines().contains(p)) {
			getPolylines().add(p);
		}
	}

	public abstract void handleKeyChar(char c);

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	/**
	 * @return an array expressing the bounding box of all vertices in this
	 *         shape. The array is of the form
	 *         <code> {minX,minY,maxX,maxY}</code>
	 */
	public double[] getBounds() {
		int m = getPolyLineCount();
		double minX = Double.POSITIVE_INFINITY;
		double maxX = Double.NEGATIVE_INFINITY;
		double minY = Double.POSITIVE_INFINITY;
		double maxY = Double.NEGATIVE_INFINITY;
		for (int j = 0; j < m; j++) {
			PolyLine pl = getPolyLine(j);
			int n = pl.getLength();
			for (int i = 0; i < n; i++) {
				Vertex v = pl.getVertexAt(i);
				if (v.x < minX) {
					minX = v.x;
				}
				if (v.x > maxX) {
					maxX = v.x;
				}
				if (v.y < minY) {
					minY = v.y;
				}
				if (v.y > maxY) {
					maxY = v.y;
				}

			}

		}
		return new double[] { minX, minY, maxX, maxY };
	}

	/**
	 * @return the center of the bounding box
	 */
	public double[] getCenter() {
		double[] bounds = getBounds();
		return new double[] { bounds[0] / 2 + bounds[2] / 2,
				bounds[1] / 2 + bounds[3] / 2 };
	}

	public ProblemReporter getReporter() {
		return reporter;
	}

	public void setReporter(ProblemReporter reporter) {
		this.reporter = reporter;
	}

	public void setPolylines(List<PolyLine> polylines) {
		this.polylines = polylines;
	}

	public List<PolyLine> getPolylines() {
		return polylines;
	}
}