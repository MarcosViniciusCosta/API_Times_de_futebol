package com.futebol.times.times_e_jogadores;


import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.futebol.times.times_e_jogadores.domain.SoccerTeam;
import com.futebol.times.times_e_jogadores.repository.SoccerTeamRepository;

@DataJpaTest
@DisplayName("Testes do repositorio de times")
public class SoccerTeamRepositoryTest 
{
	
	@Autowired
	SoccerTeamRepository soccerTeamRepository;
	
	@Test
	@DisplayName("Teste da criacao de um time no repositorio")
	void saveSoccerTeamInDBWhenSucessful()
	{
		SoccerTeam soccerTeamToBeSaved = createSoccerTeam();
		SoccerTeam soccerTeamSaved = soccerTeamRepository.save(soccerTeamToBeSaved);
		
		Assertions.assertThat(soccerTeamSaved.getName()).isEqualTo(soccerTeamToBeSaved.getName());
		
		Assertions.assertThat(soccerTeamSaved.getCountry()).isEqualTo(soccerTeamToBeSaved.getCountry());
		
		Assertions.assertThat(soccerTeamSaved.getMarketValue()).isEqualTo(soccerTeamToBeSaved.getMarketValue());
		
		Assertions.assertThat(soccerTeamSaved.getId()).isNotNull();
	}

	
	
	@Test
	@DisplayName("Teste da atualizacao de um time no repositorio")
	void updateSoccerTeamInDBWhenSucessful()
	{
		SoccerTeam soccerTeamToBeSaved = createSoccerTeam();
		SoccerTeam soccerTeamSaved = soccerTeamRepository.save(soccerTeamToBeSaved);
		
		soccerTeamSaved.setName("Southampton");
		
		SoccerTeam soccerTeamUpdated = soccerTeamRepository.save(soccerTeamSaved);
		
		Assertions.assertThat(soccerTeamUpdated).isNotNull();
	
		Assertions.assertThat(soccerTeamUpdated.getId()).isNotNull();
		
		Assertions.assertThat(soccerTeamUpdated.getName()).isEqualTo(soccerTeamSaved.getName());
	}
	
	
	@Test
	@DisplayName("Teste da delecao de um time no repositorio")
	void deleteSoccerTeamInDBWhenSucessful()
	{
		SoccerTeam soccerTeamToBeSaved = createSoccerTeam();
		SoccerTeam soccerTeamSaved = soccerTeamRepository.save(soccerTeamToBeSaved);
		
		Long idToBeDeleted = soccerTeamSaved.getId();
		
		soccerTeamRepository.delete(soccerTeamSaved);
		
		
		Optional<SoccerTeam> soccerTeamOptional = soccerTeamRepository.findById(idToBeDeleted);
		
		Assertions.assertThat(soccerTeamOptional.isEmpty());
		
	}
	
	@Test
	@DisplayName("Teste da Busca por nome de um time no repositorio")
	void searchByNameSoccerTeamInDBWhenSucessful()
	{
		SoccerTeam soccerTeamToBeSaved = createSoccerTeam();
		SoccerTeam soccerTeamSaved = soccerTeamRepository.save(soccerTeamToBeSaved);
		
		List<SoccerTeam> listSoccerTeamSearcheds = soccerTeamRepository.findByName(soccerTeamSaved.getName());
		
		
		Assertions.assertThat(listSoccerTeamSearcheds).isNotNull();
		Assertions.assertThat(listSoccerTeamSearcheds.contains(soccerTeamSaved));
		
	}
	
	@Test
	@DisplayName("Teste da Busca por nome de um time não existente no repositorio")
	void searchByNameSoccerTeamInDBWhenUnsucessful()
	{
	
		List<SoccerTeam> listSoccerTeamSearcheds = soccerTeamRepository.findByName("Valor não existente");
		
		
		Assertions.assertThat(listSoccerTeamSearcheds).isNotNull();
		Assertions.assertThat(listSoccerTeamSearcheds.size()).isEqualTo(0);
		
	}
	
	/*
	@Test
	@DisplayName("Teste da cadastro de um time com nome nulo")
	void SaveSoccerTeamInBDWhenUnsucessfulByNameIsEmpty()
	{
		
		SoccerTeam soccerTeamEmpty = new SoccerTeam();
	
		Assertions.assertThatThrownBy(()-> this.soccerTeamRepository.save(soccerTeamEmpty))
		.isInstanceOf(ConstraintViolationException.class);
		
		
	}
	 */
	private SoccerTeam createSoccerTeam()
	{
		SoccerTeam fulham = new SoccerTeam();
		fulham.setCountry("Inglaterra");
		fulham.setMarketValue(2600000.0);
		fulham.setName("Fulham");
		return fulham;
	}
	
}
