package emsi.orangers.nada_sr.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private double price;

    private String url;


    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;



}

