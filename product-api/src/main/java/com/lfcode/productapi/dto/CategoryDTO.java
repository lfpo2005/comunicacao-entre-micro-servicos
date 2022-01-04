package com.lfcode.productapi.dto;

import com.fasterxml.jackson.annotation.JsonView;


public class CategoryDTO {

    public interface CategoryView{
        public static interface RegistrationPost {}
        public static interface UserPut {}
    }

    @JsonView({CategoryView.RegistrationPost.class, CategoryView.UserPut.class})
    private String nameCategory;
    @JsonView({CategoryView.RegistrationPost.class, CategoryView.UserPut.class})
    private String description;
    @JsonView({CategoryView.RegistrationPost.class, CategoryView.UserPut.class})
    private String subCategoryOne;
    @JsonView({CategoryView.RegistrationPost.class, CategoryView.UserPut.class})
    private String subCategoryTwo;


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

    public String getSubCategoryOne() {
        return subCategoryOne;
    }

    public void setSubCategoryOne(String subCategoryOne) {
        this.subCategoryOne = subCategoryOne;
    }

    public String getSubCategoryTwo() {
        return subCategoryTwo;
    }

    public void setSubCategoryTwo(String subCategoryTwo) {
        this.subCategoryTwo = subCategoryTwo;
    }
}
