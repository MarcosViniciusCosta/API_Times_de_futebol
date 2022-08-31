package com.futebol.times.times_e_jogadores.com.futebol.times.times_e_jogadores.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futebol.times.times_e_jogadores.com.futebol.times.times_e_jogadores.domain.SoccerTeam;

public interface SoccerTeamRepository extends JpaRepository<SoccerTeam,Long> {
		
	List<SoccerTeam> findByName(String name);
}
