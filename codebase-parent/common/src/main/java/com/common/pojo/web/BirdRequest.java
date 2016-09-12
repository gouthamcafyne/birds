/**
 * 
 */
package com.common.pojo.web;

import java.util.List;

/**
 * @author Goutham P N
 *
 */
public class BirdRequest extends BaseRequest {
	private String id;
	private String name;
	private String family;
	private List<String> continent;
	private Boolean visible;

	public List<String> getContinent() {
		return continent;
	}

	public void setContinent(List<String> continent) {
		this.continent = continent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
}
