package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Marks;
import com.example.demo.model.Progress;
import com.example.demo.service.MarksService;
import com.example.demo.service.ProgressService;

@Controller
public class MarksController {

	private final MarksService marksService;
	private final ProgressService progressService;
		
	@Autowired
    public MarksController(MarksService marksService, ProgressService progressService) {
		this.marksService = marksService;
		this.progressService = progressService;
	}
	
	@RequestMapping(value = "/insertMarksAndProgress", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView insertMarksAndProgress(@RequestParam("sid") String sid, @RequestParam("subid1") String subid1, @RequestParam("subid2") String subid2, @RequestParam("subid3") String subid3, @RequestParam("subid4") String subid4, @RequestParam("subid5") String subid5, @RequestParam("marks1") int marks1, @RequestParam("marks2") int marks2, @RequestParam("marks3") int marks3, @RequestParam("marks4") int marks4, @RequestParam("marks5") int marks5, @RequestParam("total") double total, @RequestParam("avg") double avg) {		
		
		ModelAndView modelAndView = new ModelAndView("AddMarkForThisTermDone.jsp");
		Marks m = new Marks();
		m.setMid(1);
		
		try {
		
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String cdate = df.format(date);
			
			int year = Integer.parseInt(cdate.substring(0, 4));
			int month = Integer.parseInt(cdate.substring(5,7));
			int term = 0;
			
			if((month >= 0) && (month < 7)) {
				term = 1;
			}
			else {
				term = 2;
			}
			
			Progress progress = new Progress();
			progress.setSid(sid);
			progress.setYear(year);
			progress.setAvg(avg);
			progress.setTot(total);
			progress.setSemester(term);
			
			List<Marks> markList = new ArrayList<>();
			
			Marks mark1 = new Marks();
			Marks mark2 = new Marks();
			Marks mark3 = new Marks();
			Marks mark4 = new Marks();
			Marks mark5 = new Marks();
			
			mark1.setSid(sid);
			mark1.setSubId(subid1);
			mark1.setMarks(marks1);
			mark1.setYear(year);
			mark1.setTerm(term);
			
			mark2.setSid(sid);
			mark2.setSubId(subid2);
			mark2.setMarks(marks2);
			mark2.setYear(year);
			mark2.setTerm(term);
			
			mark3.setSid(sid);
			mark3.setSubId(subid3);
			mark3.setMarks(marks3);
			mark3.setYear(year);
			mark3.setTerm(term);
			
			mark4.setSid(sid);
			mark4.setSubId(subid4);
			mark4.setMarks(marks4);
			mark4.setYear(year);
			mark4.setTerm(term);
			
			mark5.setSid(sid);
			mark5.setSubId(subid5);
			mark5.setMarks(marks5);
			mark5.setYear(year);
			mark5.setTerm(term);
			
			markList.add(mark1);
			markList.add(mark2);
			markList.add(mark3);
			markList.add(mark4);
			markList.add(mark5);
			
	        progressService.insert(progress);
	        for(Marks mark: markList) {
	        	marksService.insert(mark);
	        }
		}
		catch(Exception e) {
			System.out.println("Error line 115: " + e);
			m.setMid(0);
		}
		modelAndView.addObject("mark", m);
        return modelAndView;
	}
	
	@RequestMapping(value = "/EditMarks", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView editMarks(@RequestParam("id") String id) {	
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String cdate = df.format(date);
		
		int year = Integer.parseInt(cdate.substring(0, 4));
		int month = Integer.parseInt(cdate.substring(5,7));
		int term = 0;
		
		if((month >= 0) && (month < 7)) {
			term = 1;
		}
		else {
			term = 2;
		}
		
		//Implement stuffs
		List<Marks> mlist = marksService.findMark(id, year, term);
		System.out.println("#####################################");
		System.out.println(mlist);
		Progress prog = progressService.findProgress(id, year, term);
		System.out.println("#####################################");
		System.out.println(prog);
		
		ModelAndView modelAndView = new ModelAndView("EditMark.jsp");
        modelAndView.addObject("markList", mlist);
        modelAndView.addObject("progress", prog);
        System.out.println("this is Marks controller line 149");
        return modelAndView;
	}
	
	@RequestMapping(value = "/editMarksAndProgress", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView editMarksAndProgress(@RequestParam("sid") String sid, @RequestParam("subid1") String subid1, @RequestParam("subid2") String subid2, @RequestParam("subid3") String subid3, @RequestParam("subid4") String subid4, @RequestParam("subid5") String subid5, @RequestParam("marks1") String xmarks1, @RequestParam("marks2") String xmarks2, @RequestParam("marks3") String xmarks3, @RequestParam("marks4") String xmarks4, @RequestParam("marks5") String xmarks5, @RequestParam("total") double total, @RequestParam("avg") double avg, @RequestParam("pid") String xpid, @RequestParam("mid1") int mid1, @RequestParam("mid2") int mid2, @RequestParam("mid3") int mid3, @RequestParam("mid4") int mid4, @RequestParam("mid5") int mid5) {		
		
		ModelAndView modelAndView = new ModelAndView("EditMarkForThisTermDone.jsp");
		Marks temp = new Marks();
		temp.setMid(1);
		try {
			
			int pid = Integer.parseInt(xpid);
			double marks1 = Double.parseDouble(xmarks1);
			double marks2 = Double.parseDouble(xmarks2);
			double marks3 = Double.parseDouble(xmarks3);
			double marks4 = Double.parseDouble(xmarks4);
			double marks5 = Double.parseDouble(xmarks5);
		
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String cdate = df.format(date);
			
			int year = Integer.parseInt(cdate.substring(0, 4));
			int month = Integer.parseInt(cdate.substring(5,7));
			int term = 0;
			
			if((month >= 0) && (month < 7)) {
				term = 1;
			}
			else {
				term = 2;
			}
			
			Progress progress = new Progress();
			progress.setSid(sid);
			progress.setYear(year);
			progress.setAvg(avg);
			progress.setTot(total);
			progress.setSemester(term);
			progress.setPid(pid);
			
			List<Marks> markList = new ArrayList<>();
			
			Marks mark1 = new Marks();
			Marks mark2 = new Marks();
			Marks mark3 = new Marks();
			Marks mark4 = new Marks();
			Marks mark5 = new Marks();
			
			mark1.setSid(sid);
			mark1.setSubId(subid1);
			mark1.setMarks(marks1);
			mark1.setYear(year);
			mark1.setTerm(term);
			mark1.setMid(mid1);
			
			mark2.setSid(sid);
			mark2.setSubId(subid2);
			mark2.setMarks(marks2);
			mark2.setYear(year);
			mark2.setTerm(term);
			mark2.setMid(mid2);
			
			mark3.setSid(sid);
			mark3.setSubId(subid3);
			mark3.setMarks(marks3);
			mark3.setYear(year);
			mark3.setTerm(term);
			mark3.setMid(mid3);
			
			mark4.setSid(sid);
			mark4.setSubId(subid4);
			mark4.setMarks(marks4);
			mark4.setYear(year);
			mark4.setTerm(term);
			mark4.setMid(mid4);
			
			mark5.setSid(sid);
			mark5.setSubId(subid5);
			mark5.setMarks(marks5);
			mark5.setYear(year);
			mark5.setTerm(term);
			mark5.setMid(mid5);
			
			markList.add(mark1);
			markList.add(mark2);
			markList.add(mark3);
			markList.add(mark4);
			markList.add(mark5);
			
			
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println(markList);
			
			
	        progressService.edit(progress);
	        for(Marks mark: markList) {
	        	marksService.edit(mark);
	        }
		}
		catch(Exception e) {
			System.out.println("Error line 244: " + e);
			temp.setMid(0);
		}
		modelAndView.addObject("mark", temp);
        return modelAndView;
	}
	
	@RequestMapping(value = "/DeleteMarks", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView deleteMarks(@RequestParam("id") String id) {	
		
		ModelAndView modelAndView = new ModelAndView("DeleteMarkForThisTermDone.jsp");
		
		try {
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String cdate = df.format(date);
			
			int year = Integer.parseInt(cdate.substring(0, 4));
			int month = Integer.parseInt(cdate.substring(5,7));
			int term = 0;
			
			if((month >= 0) && (month < 7)) {
				term = 1;
			}
			else {
				term = 2;
			}
			
			List<Marks> markList = marksService.findMark(id, year, term);
			Progress progress = progressService.findProgress(id, year, term);
			
			for(Marks m : markList) {
				marksService.deleteMarks(m);
			}
			
			progressService.deleteProgress(progress);
		}
		catch(Exception e) {
			System.out.println("Error");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/viewMarksAndProgress", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView viewMarksAndProgress(@RequestParam("sid") String sid, @RequestParam("year") int year, @RequestParam("semester") int semester) {		
		
		ModelAndView modelAndView = new ModelAndView("ViewMarksAndProgressPage.jsp");
		Progress progress = new Progress();
		List<Marks> markList = new ArrayList<>();
		try {
			progress = progressService.findProgress(sid, year, semester);
			markList = marksService.findMark(sid, year, semester);
			modelAndView.addObject("markList", markList);
			modelAndView.addObject("progress", progress);
			System.out.println("######################################");
			System.out.println(progress.toString());
			System.out.println(markList.toString());
		}
		catch(Exception e) {
			System.out.println("Error: " + e);
			progress = null;
			markList = null;
			modelAndView.addObject("progress", progress);
			modelAndView.addObject("markList", markList);
		}
        return modelAndView;
	}
	
}
