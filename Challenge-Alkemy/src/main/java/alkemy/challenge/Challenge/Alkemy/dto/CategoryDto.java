package alkemy.challenge.Challenge.Alkemy.dto;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "category")
    private String category;

    public CategoryDto() {
    }

    public CategoryDto(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
