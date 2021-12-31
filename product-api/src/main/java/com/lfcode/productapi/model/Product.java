package com.lfcode.productapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name= "TB_PRODUCT")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nameProduct;

    private String SKU;

    @Column(nullable = false, columnDefinition = "Text")
    private String description;

    @Column(nullable = false)
    private Integer quantityAvailable;

    @Column(nullable = false, length = 10)
    private String Weight;

    @Column(nullable = false, length = 10)
    private String height;

    @Column(nullable = false, length = 10)
    private String width;

    @Column(nullable = false, length = 10)
    private String depth;

    @Column(nullable = false)
    private BigDecimal price;

    private String linkYoutube;

    private Integer quantitySales;

    private Boolean active = Boolean.FALSE;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime lastUpdateDate;


    @ManyToOne
    @JoinColumn(name = "FK_SUPPLIER", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY", nullable = false)
    private Category category;

	@ManyToOne
	@JoinColumn(name = "FK_IMAGE", nullable = false)
	private Image image;

    /*@OneToMany(mappedBy = "imageProduct", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<Image>();*/

    public Product() {
    }

    public Product(Long id, String nameProduct, String SKU, String description, Integer quantityAvailable, String weight, String height, String width, String depth, BigDecimal price, String linkYoutube, Integer quantitySales, Boolean active, LocalDateTime creationDate, LocalDateTime lastUpdateDate, Supplier supplier, Category category, Image image) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.SKU = SKU;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
        Weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.price = price;
        this.linkYoutube = linkYoutube;
        this.quantitySales = quantitySales;
        this.active = active;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.supplier = supplier;
        this.category = category;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    public void setLinkYoutube(String linkYoutube) {
        this.linkYoutube = linkYoutube;
    }

    public Integer getQuantitySales() {
        return quantitySales;
    }

    public void setQuantitySales(Integer quantitySales) {
        this.quantitySales = quantitySales;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
