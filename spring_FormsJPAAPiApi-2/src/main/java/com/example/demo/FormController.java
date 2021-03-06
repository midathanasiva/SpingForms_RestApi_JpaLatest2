package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class FormController {
	@Autowired
	CustomersRepo repo;

	@RequestMapping("/")
	public String details() {
		return ("edureka");
	}

	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		return ("edureka");
	}

	@RequestMapping("/getdetails")
	public String getdetails() {

		return ("ViewCustomer");
	}

	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int cid) {
		ModelAndView mv = new ModelAndView("Retrive");
		Customers customers = repo.findById(cid).orElse(null);
		mv.addObject(customers);
		return mv;
	}

	/*
	 *  ---------------- here we get the output in the form of String
	 * 
	 * @RequestMapping("/customers")
	 * 
	 * @ResponseBody public String getCustomers() { return
	 * repo.findAll().toString(); }
	 * 
	 * 
	 * @RequestMapping("/customers/2")
	 * 
	 * @ResponseBody public String getCustomers2() { return
	 * repo.findById(2).toString(); }
	 * 
	 * 
	 * @RequestMapping("/customers/{cid}")
	 * 
	 * @ResponseBody public String getCustomers2(@PathVariable("cid")int cid) {
	 * return repo.findById(cid).toString(); }
	 */
	
	//--------------------->output in the form of list.
	
	
	
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers()
	{
		return repo.findAll();
	}
	
	@PostMapping("/customers")
	
	public Customers getCustomers3(@RequestBody Customers customers)
	
		{repo.save(customers);
		return customers;
	}
@DeleteMapping("/customers/{cid}")
	
	public Customers getCustomers4(@PathVariable ("cid") int cid)
	
		{
	Customers cust=repo.getOne(cid);
	repo.delete(cust);
		return cust;
	}
@PutMapping(path="/customers", consumes= {"application/json"})

public Customers getCustomers5(@RequestBody Customers customers)

	{
repo.save(customers);

	return customers;
}
		
		
		/* 
		 * @RequestMapping("/customers/2")
		 *  
		 * @ResponseBody public String getCustomers2() { return
		 * repo.findById(2).toString(); }
		 */

	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customers> getCustomers2(@PathVariable("cid")int cid) 
	{
		return repo.findById(cid);

}
}
