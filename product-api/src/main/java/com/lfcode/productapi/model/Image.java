package com.lfcode.productapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_IMAGE")
public class Image implements Serializable {


		private static final long serialVersionUID = 1L;

        @Id
        @EqualsAndHashCode.Include
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(columnDefinition = "Text")
        private String Image;

        @Column
        private String ImgURL;

        @ManyToOne
        @JoinColumn(name = "img_id")
        private Product product;

       /** @ManyToOne
        @JoinColumn(name = "img_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "image_fx"))
        private Product img;*/


}
