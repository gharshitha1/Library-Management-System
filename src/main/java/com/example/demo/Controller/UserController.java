package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AdminRepo;
import com.example.demo.BookRepo;
import com.example.demo.Model.BookData;
import com.example.demo.Model.LoginData;
import com.example.demo.Model.SignUpData;
import com.example.demo.Model.UserData;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	BookRepo brepo;
	@Autowired
	AdminRepo urepo;
	@RequestMapping("/getdata")
	public String getall(Model model,HttpSession session) {
		String username = (String) session.getAttribute("username");
	    List<BookData> data = brepo.findAll();
	    model.addAttribute("bookdata", data);
	    List<UserData> data2 = urepo.findByRollno(username);
	    model.addAttribute("userdata", data2);
	    model.addAttribute("finedata",data2);
	    model.addAttribute("username", username);
	    return "UserDashBoard";
	}
	@RequestMapping("/search")
	public String booksearch(@RequestParam("search") String bookname) {
		List<BookData> data=brepo.findByName(bookname);
		System.out.println(data);
		if(data.equals(bookname)) {
			System.out.println("Book Found");
		}
		else {
			System.out.println("Book Not Found");
		}
		return "UserDashBoard";
	}
}
