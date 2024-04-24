package com.example.demo.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Rocket;
import com.example.demo.service.RocketService;


@Controller
public class RocketController {
	
	@Autowired
	RocketService rocketService;
	@RequestMapping("/ListeRockets")
	public String listeRockets(ModelMap modelMap)
	{
	List<Rocket> rocks = rocketService.getAllRocket();
	modelMap.addAttribute("rockets", rocks);
	return "listeProduits";
	}
	 @RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createRocket";
	}
	@RequestMapping("/saveRocket")
	public String saveRocket(@ModelAttribute("rocket") Rocket rocket,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date LDate = (Date) dateformat.parse(String.valueOf(date));
	 rocket.setLDate(LDate);

	Rocket saveRocket = rocketService.saveRocket(rocket);
	String msg ="produit enregistré avec Id "+saveRocket.getIdRocket();
	modelMap.addAttribute("msg", msg);
	return "createRocket";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/supprimerRocket")
	public String supprimerRocket(@RequestParam("id") Long id,
	 ModelMap modelMap, @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{
	rocketService.deleteRocketById(id);
	List<Rocket> rocks = (List<Rocket>) rocketService.getAllRocketsParPage(page, size);
	modelMap.addAttribute("rockets", rocks);
	modelMap.addAttribute("pages", new int[((Page<Rocket>) rocks).getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);

	return "listeRockets";
	}

	 @RequestMapping("/modifierRocket")
	public String editerRocket(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{
	Rocket r= rocketService.getRocket(id);
	modelMap.addAttribute("rocket", r);
	return "editerRocket";
	}
	@RequestMapping("/updateRocket")
	public String updateRocket(@ModelAttribute("rocket") Rocket
	rocket, @RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date Ldate = (Date) dateformat.parse(String.valueOf(date));
	 rocket.setLDate(Ldate);

	 rocketService.updateRocket(rocket);
	 List<Rocket> rocks = rocketService.getAllRocket();
	 modelMap.addAttribute("rockets", rocks);
	return "listeRockets";
	}
	@RequestMapping("/ListeProduits")
	public String listeRockets(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Rocket> rocks = rocketService.getAllRocketsParPage(page, size);
	modelMap.addAttribute("rockets", rocks);
	 modelMap.addAttribute("pages", new int[rocks.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeRockets ";
	}


}
