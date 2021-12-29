package com.lfcode.productapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    }
