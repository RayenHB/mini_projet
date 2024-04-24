package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Rocket;
import com.example.demo.repos.RocketRepository;

@Service
public class RocketServiceImpl implements RocketService{


	@Autowired
	RocketRepository rocketRepository;

	@Override
	public Rocket saveRocket(Rocket r) {
		return rocketRepository.save(r);
	}

	@Override
	public Rocket updateRocket(Rocket r) {
		return rocketRepository.save(r);

	}

	@Override
	public void deleteRocket(Rocket r) {
		rocketRepository.delete(r);
		
	}

	@Override
	public void deleteRocketById(Long id) {
		rocketRepository.deleteById(id);
		
	}

	@Override
	public Rocket getRocket(Long id) {
		return rocketRepository.findById(id).get();

	}

	@Override
	public List<Rocket> getAllRocket() {
		return rocketRepository.findAll();

	}

	@Override
	public Page<Rocket> getAllRocketsParPage(int page, int size) {
		return rocketRepository.findAll(PageRequest.of(page, size));
	}

}
