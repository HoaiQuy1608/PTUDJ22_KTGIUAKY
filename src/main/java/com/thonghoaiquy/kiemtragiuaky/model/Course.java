package com.thonghoaiquy.kiemtragiuaky.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String image;

    private Integer credits;

    private String lecturer;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
