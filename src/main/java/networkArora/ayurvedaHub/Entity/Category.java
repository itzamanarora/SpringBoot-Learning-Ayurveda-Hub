package networkArora.ayurvedaHub.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import networkArora.ayurvedaHub.Utility.Status;

@Entity
@Table(name="categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;
    private String categorySlug;
    private String categoryDescription;      
    private String coverImageURL;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="parent_category_id")
    private Category parentCategory;
}
