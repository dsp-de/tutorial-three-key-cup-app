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
package exercise.basic.test;

import exercise.basic.Vertex;
import junit.framework.TestCase;

public class VertexTest extends TestCase {

	private static final double TOLERANCE = 0.000001;

	public void testVertex() {
		Vertex vertex = new Vertex(2.0, 3.0);
		assertNotNull("Vertex created.", vertex);
	}

	public void testGetSize() {
		Vertex vertex = new Vertex(0, 0);
		assertEquals("(0, 0) has size 0.", 0.0, vertex.getSize(), TOLERANCE);
		vertex = new Vertex(3, 4);
		assertEquals("(3, 4) has size 5.", 5.0, vertex.getSize(), TOLERANCE);
		double x = Math.PI;
		double y = Math.E;
		vertex = new Vertex(x, y);
		double expectedSizeSqr = x * x + y * y;
		double actualSizeSqr = vertex.getSize() * vertex.getSize();
		assertEquals("The square of the size of (x, y) is x^2+y^2.",
				expectedSizeSqr, actualSizeSqr, TOLERANCE);
	}

	public void testScale() {
		Vertex vertex = new Vertex(0, 0);
		vertex.scale(10000.0);
		assertEquals("(0, 0) stays constant when scaled.", 0.0,
				vertex.getSize(), TOLERANCE);
		vertex = new Vertex(6, 8);
		vertex.scale(0.5);
		assertEquals("(6, *) scaled by 0.5 is (3, *).", 3, vertex.x, TOLERANCE);
		assertEquals("(*, 8) scaled by 0.5 is (*, 4).", 4, vertex.y, TOLERANCE);
		vertex.scale(0.0);
		assertEquals("(x, y) scaled by 0 is (0, 0).", 0, vertex.getSize(),
				TOLERANCE);
	}
}