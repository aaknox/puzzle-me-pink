package com.azhya.controllers;

import static com.azhya.utilities.ClientMessageUtil.REGISTATION_FAILED;
import static com.azhya.utilities.ClientMessageUtil.REGISTATION_SUCCESSFUL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azhya.models.ClientMessage;
import com.azhya.models.Player;
import com.azhya.services.PlayerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/players")
//@CrossOrigin(origins= {"http://localhost:4200"})
public class PlayerController {

	@Autowired
	private PlayerService playerServ;
	
	@PostMapping("/register")
	public ClientMessage registerNewProfile(@RequestBody Player player) {
		return playerServ.registerPlayer(player) ? REGISTATION_SUCCESSFUL : REGISTATION_FAILED;
	}
}
