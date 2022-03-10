package com.lfcode.productapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
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

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name ="product_id")
        private Product product;

}
