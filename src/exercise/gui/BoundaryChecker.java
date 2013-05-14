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

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

import exercise.model.Shape;
import exercise.model.ShapeList;

public class BoundaryChecker extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private HashMap<Shape, String> problems = new HashMap<Shape, String>();

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return ShapeList.getInstance().getSize();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Shape shape = ShapeList.getInstance().getShape(rowIndex);
		String problem = problems.get(shape);
		switch (columnIndex) {
		case 0:
			return shape;
		case 1:
			return problem == null ? "OK" : problem;
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Shape";
		case 1:
			return "Status";
		}
		return null;
	}

	public void checkShapes() {
		for (int i = 0; i < ShapeList.getInstance().getSize(); i++) {
			Shape shape = ShapeList.getInstance().getShape(i);
			double[] bounds = shape.getBounds();
			if (bounds[0] < -1 || bounds[1] < -1 || bounds[2] > 1
					|| bounds[3] > 1) {
				problems.put(shape, "Figure is leaving the view!");
				fireTableRowsUpdated(i, i);
			} else if (problems.remove(shape) != null) {
				fireTableRowsUpdated(i, i);
			}
		}
	}
}