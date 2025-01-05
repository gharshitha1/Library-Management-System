package com.example.demo.Controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.AdminRepo;
import com.example.demo.BookRepo;
import com.example.demo.Model.UserData;
import com.example.demo.Model.BookData;
import com.example.demo.Model.SignUpData;

@Controller
public class AdminController {
	@Autowired
	AdminRepo repo;
	@Autowired
	BookRepo repo1;
	@RequestMapping("/bookuserentry")
	public String insertUserData(Model model) {
		UserData ent=new UserData();
		model.addAttribute("userform",ent);
		return "bookuserentry";
	}
	@RequestMapping(path="/bookuserentry" ,method=RequestMethod.POST)
	public String insert(@ModelAttribute("userform") UserData userform){
		String date=userform.getDate();
		String sdate=userform.getSdate();
		LocalDate startDate = LocalDate.parse(date);  // Assuming date is in YYYY-MM-DD format
	    LocalDate endDate = LocalDate.parse(sdate);
	    long days = ChronoUnit.DAYS.between(startDate, endDate);
	    System.out.println("Days between: " + days);
	    String fine;
	    if(days>10) {
	    	long fines=(days-10)*5;
	    	fine=String.valueOf(fines);
	    }
	    else {
	    	fine="No Delay";
	    }
	    userform.setDays(days);
	    userform.setFine(fine);
		repo.save(userform);
		return "AdminDashBoard";
	}
	@RequestMapping("/addbooks")
	public String BookData(Model model) {
		BookData ent=new BookData();
		model.addAttribute("bookdata",ent);
		return "addbooks";
	}
	@RequestMapping(path="/addbooks" ,method=RequestMethod.POST)
	public String insert(@ModelAttribute("bookdata") BookData bookdata){
		repo1.save(bookdata);
		return "AdminDashBoard";
	}
	@RequestMapping("/display")
	public String getall(Model model) {
	    List<UserData> data = repo.findByDays();
	    model.addAttribute("csedata", data);
	    return "AdminDashBoard";
	}
	

}
