package com.futebol.times.times_e_jogadores.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.futebol.times.times_e_jogadores.DTO.SoccerTeamRequestPostDTO;
import com.futebol.times.times_e_jogadores.DTO.SoccerTeamRequestPutDTO;
import com.futebol.times.times_e_jogadores.domain.SoccerTeam;
import com.futebol.times.times_e_jogadores.exception.BadRequestException;
import com.futebol.times.times_e_jogadores.repository.SoccerTeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SoccerTeamService 
{
	
	private final SoccerTeamRepository soccerTeamRepository;
	private final ModelMapper mapper;
	
	public Page<SoccerTeam> listAll(Pageable pageable)
	{
		return soccerTeamRepository.findAll(pageable);		
	}
	
	public List<SoccerTeam> findByName(String name)
	{
		return soccerTeamRepository.findByName(name);
	}
	
	
	public SoccerTeam findByIdOrThrowBadRequestException(long id)
	{
		return soccerTeamRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Id de time não encontrado"));
	} 
	
	@Transactional
	public SoccerTeam save(SoccerTeamRequestPostDTO soccerTeamRequestPostDTO)
	{
		return soccerTeamRepository.save(mapper.map(soccerTeamRequestPostDTO, SoccerTeam.class));
	}
	
	@Transactional
	public void delete(long id)
	{
		soccerTeamRepository.delete(findByIdOrThrowBadRequestException(id));
	}
	
	// busca o time salvo na base de dados,  
	public void replace(SoccerTeamRequestPutDTO soccerTeamRequestPutDTO)
	{
		SoccerTeam soccerTeamSavedInDB = findByIdOrThrowBadRequestException(soccerTeamRequestPutDTO.getId()); 
		SoccerTeam soccerTeam = mapper.map(soccerTeamRequestPutDTO, SoccerTeam.class);
		soccerTeam.setId(soccerTeamSavedInDB.getId());
		soccerTeamRepository.save(soccerTeam);
	}
	
}
