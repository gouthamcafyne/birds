/**
 * 
 */
package com.common.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Goutham P N
 *
 */
public class SSBatch<T> {
	private List<T> items;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public void addItem(T item) {
		if (null == this.items) {
			this.items = new ArrayList<T>();
		}
		this.items.add(item);
	}
}
