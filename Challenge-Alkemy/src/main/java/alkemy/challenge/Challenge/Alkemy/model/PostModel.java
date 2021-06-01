package alkemy.challenge.Challenge.Alkemy.model;

import java.time.LocalDate;

public class PostModel {

    private int id;
    private String title;
    private String content;
    private String image;
    private CategoryModel categoryModel;
    private int idUser;
    private LocalDate createdAt;

    public PostModel() {
    }

    public PostModel(int id, String title, String image, CategoryModel categoryModel, int idUser, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.categoryModel = categoryModel;
        this.idUser = idUser;
        this.createdAt = createdAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
