package com.lfcode.productapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "TB_CATEGORY")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true, length = 30)
	private String nameCategory;

	@Column(columnDefinition = "Text")
	private String description;


	@OneToMany(mappedBy = "category", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SubCategoryOne> subCategoryOnes = new ArrayList<SubCategoryOne>();

	public Category() {
	}

	public Category(Long id, String nameCategory, String description, List<SubCategoryOne> subCategoryOnes) {
		this.id = id;
		this.nameCategory = nameCategory;
		this.description = description;
		this.subCategoryOnes = subCategoryOnes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Category)) return false;
		Category category = (Category) o;
		return getId().equals(category.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SubCategoryOne> getSubCategoryOnes() {
		return subCategoryOnes;
	}

	public void setSubCategoryOnes(List<SubCategoryOne> subCategoryOnes) {
		this.subCategoryOnes = subCategoryOnes;
	}
}
