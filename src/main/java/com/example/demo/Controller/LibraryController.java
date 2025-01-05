package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LibraryRepo;
import com.example.demo.Model.LoginData;
import com.example.demo.Model.SignUpData;

import jakarta.servlet.http.HttpSession;



@Controller
public class LibraryController {
	@Autowired
	LibraryRepo repo;
	@RequestMapping("/home")
	public String gethome() {
		return "home";
	}
	@RequestMapping("/signup")
	public String insertuserdata(Model model ) {
		SignUpData ent=new SignUpData();
		model.addAttribute("cseform",ent);
		return "signup";
	}
	@RequestMapping(path="/register" ,method=RequestMethod.POST)
	public String insert(@ModelAttribute("cseform") SignUpData cseform){
		System.out.println("Role:"+" "+cseform.getRole());
		repo.save(cseform);
		return "login";
	}
	@RequestMapping("/login")
	public String insertuserdat(Model model ) {
		LoginData ent=new LoginData();
		model.addAttribute("loginform",ent);
		return "login";
	}
	@RequestMapping(path="/login" ,method=RequestMethod.POST)
	public String logincheck(@ModelAttribute("loginform") LoginData loginform,HttpSession session){
		session.setAttribute("username", loginform.getUsername());
		String User=loginform.getUsername();
		String Pass=loginform.getPassword();
		List<SignUpData>user=(List<SignUpData>) repo.findByRoll(User);
		SignUpData data = user.get(0);
		String username=data.getRoll();
		String password =data.getPassword(); 
		String role=data.getRole();
		if(User.equals(username) && Pass.equals(password)) {
			if("Student".equals(role)) {
				return "UserDashBoard";
			}
			else if(role.equals("Admin")){
				return "AdminDashBoard";
			}
		}
		return "login";
	}
	
}
