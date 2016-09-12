package com.common.pojo;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.common.annotations.BirdVisibilityView;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Bird extends Resource {
	@Id
	private String id;
	private String name;
	private String family;
	private List<String> continents;
	private String added;

	@BirdVisibilityView
	private Boolean visible;

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public List<String> getContinents() {
		return continents;
	}

	public void setContinents(List<String> continents) {
		this.continents = continents;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bird [id=" + id + ", name=" + name + ", family=" + family + ", continents=" + continents + ", added="
				+ added + ", visible=" + visible + ", getFamily()=" + getFamily() + ", getContinents()="
				+ getContinents() + ", getAdded()=" + getAdded() + ", getVisible()=" + getVisible() + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
