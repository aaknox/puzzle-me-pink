package com.azhya.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.azhya.aspects.LoggingAspect;
import com.azhya.models.Player;
import com.azhya.repositories.PlayerRepository;

import dev.ditsche.mailo.Mail;
import dev.ditsche.mailo.MailAddress;
import dev.ditsche.mailo.factory.MailBuilder;
import dev.ditsche.mailo.provider.MailProvider;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private final PasswordEncoder passwordEncoder;
	
	private final MailProvider mailProvider;
	
	@Autowired
	private PlayerRepository playerRepo;
	
	@Autowired
	private final JavaMailSender javaMailSender;
	
	@Autowired
    public PlayerServiceImpl(PasswordEncoder passwordEncoder, JavaMailSender sender, MailProvider mailProvider) {
        this.passwordEncoder = passwordEncoder;
        this.javaMailSender = sender;
        this.mailProvider = mailProvider;
    }

	@Override
	public boolean registerPlayer(Player player) {
		//hash passwords being entered for new player
		//that will later be verify during login
		String hashedPassword = passwordEncoder.encode(player.getPassword());
		player.setPassword(hashedPassword);
		int pk = playerRepo.save(player).getId();
		
		//TODO: once the new player profile is made, send email with verification link attached in body
		sendVerification(player.getEmail(), "Player Profile Complete | Verify your email address with Puzzle Me Pink!", player.getUsername());
		return (pk > 0) ? true : false;
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepo.findAll();
	}
	
	@Async
	public void sendVerification(String toEmail, String subject, String username) {
		String url = String.format("http://localhost:8080/api/players/verify/%s", toEmail);
		MailBuilder mailBuilder = MailBuilder.mjml()
                .subject(subject)
                .to(new MailAddress(toEmail))
                .from(new MailAddress("azhya.knox@gmail.com"))
                .param("email", toEmail)
                .param("url", url)
                .param("username", username)
                .loadTemplate("profileCreation");
        mailProvider.send(mailBuilder);
	}
	
	@Async
	public void sendEmail(String toEmail, String subject, String username) {
		MailBuilder mailBuilder = MailBuilder.mjml()
                .subject(subject)
                .to(new MailAddress(toEmail))
                .from(new MailAddress("azhya.knox@gmail.com"))
                .param("username", username)
                .loadTemplate("verifyCompletion");
        mailProvider.send(mailBuilder);
	}

	@Override
	public boolean isVerified(String email) {
		Player target = playerRepo.findByEmail(email);
		if(target.getVerified() == false) {
			//if email found, send verification confirmation
			//send verification confirmation email to player
			sendEmail(email, "Puzzle Me Pink Profile Verified!", target.getUsername());
			System.out.println("email sent. now updating status in system. ");
			target.setVerified(true);
		}
		
		playerRepo.saveAndFlush(target);
		
		//return new status
		return target.getVerified().booleanValue();
	}
}
