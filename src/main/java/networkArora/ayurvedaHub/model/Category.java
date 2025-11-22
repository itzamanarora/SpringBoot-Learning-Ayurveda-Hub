package networkArora.ayurvedaHub.model;

import java.time.Instant;
import java.util.Date;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import lombok.Data;
import networkArora.ayurvedaHub.model.enums.Status;

@Entity
@Table(name="categories")
@Data
public class Category {

    @Id
    @UuidGenerator
    @GeneratedValue
    private String categoryId;

    @Column(nullable=false, unique=true)
    private String categoryName;
    
    @Column(nullable=false, unique=true)
    private String categorySlug;

    @Column(nullable=false, length=500) 
    private String categoryDescription;
    
    @Column(nullable=true, length=1000)
    private String coverImageURL;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable=false, updatable=false)
    private Instant createdAt;

    @Column(nullable=true)
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name="parent_category_id")
    private Category parentCategory;
}
