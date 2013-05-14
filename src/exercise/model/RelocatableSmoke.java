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

public abstract class RelocatableSmoke extends Shape {

	public RelocatableSmoke(Canvas c, ProblemReporter reporter) {
		super(c, reporter);
		PolyLine someSmoke = new PolyLine();
		someSmoke.addVertex(new Vertex(0, -.5));
		someSmoke.addVertex(new Vertex(-.05, -.25));
		someSmoke.addVertex(new Vertex(.05, .25));
		someSmoke.addVertex(new Vertex(0, .5));
		addPolyLine(someSmoke);
		relocate(-.1, 0);
		someSmoke = new PolyLine();
		someSmoke.addVertex(new Vertex(0, -.5));
		someSmoke.addVertex(new Vertex(-.05, -.25));
		someSmoke.addVertex(new Vertex(.05, .25));
		someSmoke.addVertex(new Vertex(0, .5));
		addPolyLine(someSmoke);
		relocate(.2, 0);
		someSmoke = new PolyLine();
		someSmoke.addVertex(new Vertex(0, -.5));
		someSmoke.addVertex(new Vertex(-.05, -.25));
		someSmoke.addVertex(new Vertex(.05, .25));
		someSmoke.addVertex(new Vertex(0, .5));
		addPolyLine(someSmoke);
		getCanvas().redrawShapes();
	}

	public RelocatableSmoke() {
		super();
	}

	@Override
	public String getName() {
		return "Smokie";
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