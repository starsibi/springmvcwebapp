package com.example;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;
	 
	@Controller
	public class homeController
	{	
		@Autowired
		LoginDAO loginDAO;
		@RequestMapping("/")
		public String display()
		{
			return "index";
		}
		@RequestMapping("/isValidUser")
		public ModelAndView showMessage(@RequestParam (value = "userName")String name,@RequestParam(value = "password")String password)
		{	
			System.out.println("inshowmessage");
			String message;
			boolean check=loginDAO.isValidUser(name,password);
			if(check==true)
			{
				System.out.println("true ");
				message="valid credentials";
				//return "Success";
				
				ModelAndView mv=new ModelAndView("Success");
				mv.addObject("message",message);
				//mv.addObject("name",name);
				return mv;
					
			}
			
			else
				{
				System.out.println("False");
				message="invalid credentials";
				//return "index";
				ModelAndView mv=new ModelAndView("Failure");
				mv.addObject("message",message);
				//mv.addObject("name",name);
				return mv;
				}	
			
		}
		
		
	
}
