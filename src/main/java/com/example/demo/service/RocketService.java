package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.example.demo.entities.Rocket;

public interface RocketService {
	Page<Rocket> getAllRocketsParPage(int page, int size);

	Rocket saveRocket(Rocket r);
	Rocket updateRocket(Rocket p);
	void deleteRocket(Rocket p);
	 void deleteRocketById(Long id);
	 Rocket getRocket(Long id);
	List<Rocket> getAllRocket();
}
