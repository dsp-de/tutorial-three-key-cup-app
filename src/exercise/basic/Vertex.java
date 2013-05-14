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

public class Vertex {

	public double x, y;

	public Vertex(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getSize() {
		return Math.sqrt(x * x + y * y);
	}

	public void scale(double factor) {
		x = factor * x;
		y = factor * y;
	}
}