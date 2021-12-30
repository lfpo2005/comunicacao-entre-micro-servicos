package com.lfcode.productapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_IMAGE")
public class Image implements Serializable {


		private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(columnDefinition = "Text")
        private String Image;

        @Column
        private String ImgURL;

        @ManyToOne
        @JoinColumn(name = "image_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "image_fx"))
        private Product imageProduct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getImgURL() {
		return ImgURL;
	}

	public void setImgURL(String imgURL) {
		ImgURL = imgURL;
	}

	public Product getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(Product imageProduct) {
		this.imageProduct = imageProduct;
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
		Image other = (Image) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    }
