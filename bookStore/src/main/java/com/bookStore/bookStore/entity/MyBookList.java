package com.bookStore.bookStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MyBooks")
public class MyBookList {
    @Id
    @Column(name="book_id")
    private int id;
    private String title;
    private String  author;
    private String category;
    private String price;
}
