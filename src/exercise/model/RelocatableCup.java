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

import java.util.Iterator;

import exercise.basic.PolyLine;
import exercise.basic.Vertex;
import exercise.gui.ProblemReporter;
import exercise.gui.Canvas;

public abstract class RelocatableCup extends Shape {

	public RelocatableCup(Canvas c, ProblemReporter reporter) {
		super(c, reporter);
		PolyLine cup = new PolyLine();
		cup.addVertex(new Vertex(-.6, -.3));
		cup.addVertex(new Vertex(.6, -.3));
		cup.addVertex(new Vertex(.5, .3));
		cup.addVertex(new Vertex(-.5, .3));
		cup.addVertex(new Vertex(-.6, -.3));
		PolyLine handle = new PolyLine();
		handle.addVertex(new Vertex(.59, -.2));
		handle.addVertex(new Vertex(.7, -.2));
		handle.addVertex(new Vertex(.7, .2));
		handle.addVertex(new Vertex(.52, .2));
		addPolyLine(cup);
		addPolyLine(handle);
		getCanvas().redrawShapes();
	}

	public RelocatableCup() {
		super();
	}

	@Override
	public String getName() {
		return "Cup of coffee";
	}

	public void relocate(double x, double y) {
		for (Iterator<PolyLine> iter = getPolylines().iterator(); iter
				.hasNext();) {
			PolyLine line = iter.next();
			for (int i = 0; i < line.getLength(); i++) {
				Vertex v = line.getVertexAt(i);
				v.x += x;
				v.y += y;
			}
		}
	}

}