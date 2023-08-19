package com.azhya.services;

import java.util.List;

import com.azhya.models.Player;

public interface PlayerService {
	//register for new player account
	public boolean registerPlayer(Player player);
	
	//view all players
	public List<Player> getAllPlayers();
	
	//update player email verification status
	public boolean isVerified(String email);
}
