package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.BookData;
import com.example.demo.Model.UserData;

public interface AdminRepo extends JpaRepository<UserData, Integer> {

	List<UserData> findByDays();
	List<UserData> findByRollno(String username);

}
