package alkemy.challenge.Challenge.Alkemy.dto;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "post")
public class PostDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "image")
    private String image;
    @ManyToOne///TODO Search for "No serializer found for class" when putting lazy fetch
    @JoinColumn(name = "post_category_id", nullable = false)
    private CategoryDto category;
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "create_date")
    private LocalDate createdAt;
    @Column(name = "enabled", columnDefinition = "boolean default true")
    private boolean enabled = true;

    public PostDto() {
    }

    public PostDto(String title, String content, String image, CategoryDto category, int idUser, LocalDate createdAt) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.category = category;
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

    public CategoryDto getCategoryModel() {
        return category;
    }

    public void setCategoryModel(CategoryDto category) {
        this.category = category;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
