package com.rahul.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "book")
@Builder
public class Book {
	@Id
    private String bookId;
    private String bookName;
    private String writer;
    private String publication;
    private String blockNumber;
    private String subject;
}
