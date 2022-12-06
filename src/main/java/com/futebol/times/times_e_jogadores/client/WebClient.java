package com.futebol.times.times_e_jogadores.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.futebol.times.times_e_jogadores.DTO.SoccerTeamRequestPutDTO;
import com.futebol.times.times_e_jogadores.domain.SoccerTeam;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class WebClient {

	public static void main(String[] args) 
	{
		ResponseEntity<SoccerTeam> entity = new RestTemplate().getForEntity("http://localhost:8080/times/2", SoccerTeam.class);
		SoccerTeam team = new RestTemplate().getForObject("http://localhost:8080/times/{id}", SoccerTeam.class,5);
		log.info(entity.getBody());
		log.info(team);
	
	
		/* descomentar as linhas abaixo cadastrará o Leicester city de forma duplicada no banco
		 *
		SoccerTeamRequestPostDTO leicester = new SoccerTeamRequestPostDTO();
		leicester.setCountry("Inglaterra");
		leicester.setMarketValue(3300000.0);
		leicester.setName("Leicester City");
		
		SoccerTeam leicesterSaved = new RestTemplate().postForObject("http://localhost:8080/times", leicester, SoccerTeam.class);
		log.info(leicesterSaved);
		*/
		
	
		SoccerTeamRequestPutDTO leicester = new SoccerTeamRequestPutDTO();
		leicester.setId(12L);
		leicester.setCountry("Inglaterra");
		leicester.setMarketValue(3500000.0);
		leicester.setName("Leicester City");
		
		new RestTemplate().put("http://localhost:8080/times", leicester);
		
		
	}

}
