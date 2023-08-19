package com.azhya.controllers;

import static com.azhya.utilities.ClientMessageUtil.REGISTATION_FAILED;
import static com.azhya.utilities.ClientMessageUtil.REGISTATION_SUCCESSFUL;
import static com.azhya.utilities.ClientMessageUtil.VERIFICATION_FAILED;
import static com.azhya.utilities.ClientMessageUtil.VERIFICATION_SUCCESSFUL;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azhya.models.ClientMessage;
import com.azhya.models.Player;
import com.azhya.models.VerificationDTO;
import com.azhya.services.PlayerService;

@RestController
@RequestMapping("/api/players")
//@CrossOrigin(origins= {"http://localhost:4200"})
public class PlayerController {
	private Logger log = Logger.getLogger(PlayerController.class);

	@Autowired
	private PlayerService playerServ;
	
	@PostMapping("/register")
	public ClientMessage registerNewProfile(@RequestBody Player player) {
		log.info("Player Info: \n" + player);
		return playerServ.registerPlayer(player) ? REGISTATION_SUCCESSFUL : REGISTATION_FAILED;
	}
	
	@GetMapping
	public List<Player> getAllPlayers(){
		return playerServ.getAllPlayers();
	}
	
	@GetMapping("/verify/{email}")
	public ClientMessage verifyPlayerByEmail(@PathVariable(value="email") String email) {
		log.info("Email being verified is: " + email);
		return playerServ.isVerified(email) ? VERIFICATION_SUCCESSFUL : VERIFICATION_FAILED;
	}
}
