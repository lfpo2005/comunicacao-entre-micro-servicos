package com.lfcode.productapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


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

       /* @ManyToOne
        @JoinColumn(name = "image_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "image_fx"))
        private Product imageProduct;*/

        public Image() {
        }

        public Image(Long id, String image, String imgURL) {
                this.id = id;
                Image = image;
                ImgURL = imgURL;
        }

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

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Image image = (Image) o;
                return id.equals(image.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }
}
