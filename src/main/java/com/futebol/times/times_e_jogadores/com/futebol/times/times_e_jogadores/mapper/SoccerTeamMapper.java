package com.futebol.times.times_e_jogadores.com.futebol.times.times_e_jogadores.mapper;

import org.mapstruct.Mapper;
import com.futebol.times.times_e_jogadores.com.futebol.times.times_e_jogadores.domain.SoccerTeam;
import com.futebol.times.times_e_jogadores.com.futebol.times.times_e_jogadores.com.futebol.times.times_e_jogadores.DTO.SoccerTeamRequestPostDTO;
import com.futebol.times.times_e_jogadores.com.futebol.times.times_e_jogadores.com.futebol.times.times_e_jogadores.DTO.SoccerTeamRequestPutDTO;

@Mapper(componentModel="spring")
public interface SoccerTeamMapper 
{
	//public static final SoccerTeamMapper INSTANCE = Mappers.getMapper(SoccerTeamMapper.class);
	public abstract SoccerTeam toSoccerTeam(SoccerTeamRequestPostDTO soccerTeamRequestPostDTO);
	public abstract SoccerTeam toSoccerTeam(SoccerTeamRequestPutDTO soccerTeamRequestPutDTO);
}

