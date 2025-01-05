package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.LoginData;
import com.example.demo.Model.SignUpData;

public interface LibraryRepo extends JpaRepository<SignUpData, Integer> {

	List<SignUpData> findByRoll(String user);

}
