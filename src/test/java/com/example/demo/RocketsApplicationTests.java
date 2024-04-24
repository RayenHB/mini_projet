package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Rocket;
import com.example.demo.repos.RocketRepository;

@SpringBootTest
class RocketsApplicationTests {
	@Autowired
	private RocketRepository rocketRepository;
	@Test
	public void testCreateRocket() {
	Rocket rock = new Rocket("Falcon 9",2200.500,new Date());
	rocketRepository.save(rock);
	}
	@Test
	public void testFindRocket()
	{
	Rocket r = rocketRepository.findById(1L).get();
	System.out.println(r);
	}
	
	@Test
	public void testUpdateRocket()
	{
	Rocket r = rocketRepository.findById(1L).get();
	r.setBudget(1000.0);
	rocketRepository.save(r);
	}
	
	public void testDeleteRocket()
	{
	rocketRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousRockets()
	{
	List<Rocket> rocks = rocketRepository.findAll();
	for (Rocket r : rocks)
	{
	System.out.println(r);
	}
	}
}
