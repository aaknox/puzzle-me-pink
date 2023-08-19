package com.azhya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.azhya.models.Player;

@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	public Player findByEmail(String email);
	
//	@Modifying
//	@Query(value="update player set player.verified = true where player.email = :email", nativeQuery = true)
//	public void updatePlayerSetVerifiedForEmail(@Param("email") String email);
}
