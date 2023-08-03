package com.azhya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhya.models.Player;
import com.azhya.repositories.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository playerRepo;

	@Override
	public boolean registerPlayer(Player player) {
		int pk = playerRepo.save(player).getId();
		return (pk > 0) ? true : false;
	}

}
