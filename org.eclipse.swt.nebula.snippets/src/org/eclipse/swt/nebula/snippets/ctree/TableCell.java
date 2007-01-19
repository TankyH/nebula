/****************************************************************************
 * Copyright (c) 2006 Jeremy Dowdall
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jeremy Dowdall <jeremyd@aspencloud.com> - initial API and implementation
 *****************************************************************************/
package org.eclipse.swt.nebula.snippets.ctree;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.nebula.widgets.ctree.AbstractItem;
import org.eclipse.swt.nebula.widgets.ctree.CTreeCell;
import org.eclipse.swt.nebula.widgets.ctree.SComposite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * A Sample custom cell of style DROP_DOWN.  Uses the CContainerCell's toggle
 * via style TOGGLE, and contains a native SWT Table in its Child Area.
 */
public class TableCell extends CTreeCell {

	private Table table;
	
	public TableCell(AbstractItem item, int style) {
		super(item, style | SWT.DROP_DOWN | SWT.TOGGLE);
	}

	protected void createChildContents(SComposite contents, int style) {
		contents.setBorder(SComposite.BORDER, 1);

		table = new Table(contents, SWT.VERTICAL);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		TableColumn col = new TableColumn(table, SWT.CENTER);
		col.setText("Column 1");
		col.pack();
		col = new TableColumn(table, SWT.CENTER);
		col.setText("Column 2");
		col.pack();
		col = new TableColumn(table, SWT.CENTER);
		col.setText("Column 3");
		col.pack();

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "i1, c1", "i1, c2", "i1, c3" } );
		item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "i2, c1", "i2, c2", "i2, c3" } );
		item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "i3, c1", "i3, c2", "i3, c3" } );
		
		setExclusions(table);
	}
	
}