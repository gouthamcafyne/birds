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
	private String name;
	private String family;
	private List<String> continent;

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
}
