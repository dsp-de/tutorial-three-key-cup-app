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

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProblemReporter extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable table;

	private JScrollPane scrollPane;

	private BoundaryChecker checker = new BoundaryChecker();

	public ProblemReporter() {
		table = new JTable();
		table.setModel(checker);
		setLayout(new BorderLayout());
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void checkShapes() {
		checker.checkShapes();
	}

	@Override
	public Dimension getMinimumSize() {
		return table.getMinimumSize();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(0, table.getRowHeight() * 4);
	}
}