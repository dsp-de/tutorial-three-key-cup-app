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
package exercise.basic;

import java.util.Vector;

public class PolyLine {

	private Vector<Vertex> vertices = new Vector<Vertex>();

	public Vertex getVertexAt(int i) {
		return vertices.get(i);
	}

	public void addVertex(Vertex v) {
		vertices.add(v);
	}

	public int getLength() {
		return vertices.size();
	}

	public void appendLine(PolyLine line) {
		vertices = line.vertices;
	}

}
