package com.azhya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.azhya.models.Player;

@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
