package com.example.ddw_cjl.entity;

import java.util.List;

public class Category {//分类表
	private String id;//分类id
	private String name;//名称
	private String parentid;//所属类别id
	private String levels;//级别
	private Category first;
	private List<Category> sons;
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
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public Category getFirst() {
		return first;
	}
	public void setFirst(Category first) {
		this.first = first;
	}
	public List<Category> getSons() {
		return sons;
	}
	public void setSons(List<Category> sons) {
		this.sons = sons;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((levels == null) ? 0 : levels.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parentid == null) ? 0 : parentid.hashCode());
		result = prime * result + ((sons == null) ? 0 : sons.hashCode());
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
		Category other = (Category) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (levels == null) {
			if (other.levels != null)
				return false;
		} else if (!levels.equals(other.levels))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentid == null) {
			if (other.parentid != null)
				return false;
		} else if (!parentid.equals(other.parentid))
			return false;
		if (sons == null) {
			if (other.sons != null)
				return false;
		} else if (!sons.equals(other.sons))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentid="
				+ parentid + ", levels=" + levels + ", first=" + first
				+ ", sons=" + sons + "]";
	}
	public Category(String id, String name, String parentid, String levels,
					Category first, List<Category> sons) {
		super();
		this.id = id;
		this.name = name;
		this.parentid = parentid;
		this.levels = levels;
		this.first = first;
		this.sons = sons;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
