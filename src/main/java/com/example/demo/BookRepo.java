package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.BookData;

public interface BookRepo extends JpaRepository<BookData, Integer> {

	List<BookData> findByName(String bookname);

	

}
