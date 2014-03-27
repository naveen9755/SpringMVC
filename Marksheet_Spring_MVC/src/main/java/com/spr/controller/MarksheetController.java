package com.spr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spr.exception.MarksheetNotFound;
import com.spr.model.Marksheet;
import com.spr.service.MarksheetService;
import com.spr.validation.MarksheetValidator;

@Controller
@RequestMapping(value="/marksheet")
public class MarksheetController {
	
	@Autowired
	private MarksheetService marksheetService;
	
	@Autowired
	private MarksheetValidator marksheetValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(marksheetValidator);
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newMarksheetPage() {
		ModelAndView mav = new ModelAndView("marksheet-new", "marksheet", new Marksheet());
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewMarksheet(@ModelAttribute @Valid Marksheet marksheet,
			BindingResult result,
			final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors())
			return new ModelAndView("marksheet-new");
		
		ModelAndView mav = new ModelAndView();
		String message = "New marksheet "+marksheet.getName()+" was successfully created.";
		
		marksheetService.create(marksheet);
		mav.setViewName("redirect:/index.html");
				
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView marksheetListPage() {
		ModelAndView mav = new ModelAndView("marksheet-list");
		List<Marksheet> marksheetList = marksheetService.findAll();
		mav.addObject("marksheetList", marksheetList);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editMarksheetPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("marksheet-edit");
		Marksheet marksheet = marksheetService.findById(id);
		mav.addObject("marksheet", marksheet);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editMarksheet(@ModelAttribute @Valid Marksheet marksheet,
			BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws MarksheetNotFound {
		
		if (result.hasErrors())
			return new ModelAndView("marksheet-edit");
		
		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Marksheet was successfully updated.";

		marksheetService.update(marksheet);
		
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteMarksheet(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws MarksheetNotFound {
		
		ModelAndView mav = new ModelAndView("redirect:/index.html");		
		
		Marksheet marksheet = marksheetService.delete(id);
		String message = "The marksheet "+marksheet.getName()+" was successfully deleted.";
		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}
