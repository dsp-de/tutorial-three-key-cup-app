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

import junit.framework.TestCase;
import exercise.basic.PolyLine;
import exercise.basic.Vertex;

public class PolyLineTest extends TestCase {

	private PolyLine emptyLine;

	private PolyLine onePointLine;

	private PolyLine firstLine;

	private PolyLine secondLine;

	private PolyLine firstAndSecondLine;

	private int firstLineLength;

	private int secondLineLength;

	@Override
	public void setUp() {
		Vertex[] vertices = new Vertex[] { new Vertex(3, 6), new Vertex(3, 5),
				new Vertex(7, 4), new Vertex(6, 8), new Vertex(4, 2) };
		emptyLine = new PolyLine();
		onePointLine = new PolyLine();
		onePointLine.addVertex(vertices[0]);
		firstLine = new PolyLine();
		firstLine.addVertex(vertices[0]);
		firstLine.addVertex(vertices[1]);
		firstLine.addVertex(vertices[2]);
		firstLineLength = 3;
		secondLine = new PolyLine();
		secondLine.addVertex(vertices[3]);
		secondLine.addVertex(vertices[4]);
		secondLineLength = 2;
		firstAndSecondLine = new PolyLine();
		firstAndSecondLine.addVertex(vertices[0]);
		firstAndSecondLine.addVertex(vertices[1]);
		firstAndSecondLine.addVertex(vertices[2]);
		firstAndSecondLine.addVertex(vertices[3]);
		firstAndSecondLine.addVertex(vertices[4]);
	}

	public void testPolyLine() {
		assertNotNull("PolyLine created.", emptyLine);
		assertNotNull("PolyLine created.", onePointLine);
		assertNotNull("PolyLine created.", firstLine);
		assertNotNull("PolyLine created.", secondLine);
		assertNotNull("PolyLine created.", firstAndSecondLine);
	}

	// The next test fails.
	// Correct the error and add a few more assertions.
	public void testGetVertexAt() {
		assertNotNull("The one vertex is there.", onePointLine.getVertexAt(1));
	}

	public void testAddVertex() {
		Vertex additionalVertex = new Vertex(3, 4);
		Vertex anotherVertex = new Vertex(0, 0);
		emptyLine.addVertex(additionalVertex);
		assertEquals(
				"After adding one vertex to an empty line it has length 1.", 1,
				emptyLine.getLength());
		assertEquals("The only vertex is the the added one.", additionalVertex,
				emptyLine.getVertexAt(0));
		emptyLine.addVertex(additionalVertex);
		assertEquals("After adding the vertex a second time the length is 2.",
				2, emptyLine.getLength());
		emptyLine.addVertex(anotherVertex);
		assertEquals("After adding another vertex the length is 3.", 3,
				emptyLine.getLength());
		assertEquals("The first vertex is the additional one.",
				additionalVertex, emptyLine.getVertexAt(0));
		assertEquals("The second vertex is the additional one.",
				additionalVertex, emptyLine.getVertexAt(1));
		assertEquals("The third vertex is another vertex.", anotherVertex,
				emptyLine.getVertexAt(2));
	}

	public void testGetLength() {
		assertEquals("Empty line has length 0.", 0, emptyLine.getLength());
		assertEquals("One point line has length 1.", 1,
				onePointLine.getLength());
		assertEquals("Length of first line as expected.", firstLineLength,
				firstLine.getLength());
		assertEquals("Length of second line as expected.", secondLineLength,
				secondLine.getLength());
		assertEquals("Length of 'first and second line' as expected.",
				firstLineLength + secondLineLength, //
				firstAndSecondLine.getLength());
	}

	// Here the test is correct, but the implementation is wrong.
	// Guess from the test, what PolyLine.appendLine(PolyLine) should do
	// and correct the implementation.
	public void testAppendLine() {
		firstLine.appendLine(secondLine);
		assertEquals(
				"After appending a line the length is the sum of both lengths.",
				firstLineLength + secondLineLength, firstLine.getLength());
		for (int i = 0; i < firstLineLength + secondLineLength; i++) {
			assertEquals("Element " + i + " as expected.",
					firstAndSecondLine.getVertexAt(i), firstLine.getVertexAt(i));
		}
	}

}