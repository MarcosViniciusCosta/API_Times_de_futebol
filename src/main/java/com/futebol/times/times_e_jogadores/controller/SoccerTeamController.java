package com.futebol.times.times_e_jogadores.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futebol.times.times_e_jogadores.DTO.SoccerTeamRequestPostDTO;
import com.futebol.times.times_e_jogadores.DTO.SoccerTeamRequestPutDTO;
import com.futebol.times.times_e_jogadores.domain.SoccerTeam;
import com.futebol.times.times_e_jogadores.service.SoccerTeamService;

import lombok.RequiredArgsConstructor;


import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("times")
@RequiredArgsConstructor
public class SoccerTeamController 
{
	private final SoccerTeamService soccerTeamService;


	@GetMapping
	public ResponseEntity<Page<SoccerTeam>> list(Pageable pageable)
	{
		return new ResponseEntity<>(soccerTeamService.listAll(pageable),HttpStatus.OK);

	}

	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<SoccerTeam> findById(@PathVariable long id)
	{
		return ResponseEntity.ok(soccerTeamService.findByIdOrThrowBadRequestException(id));
	}
	
	@GetMapping(path = "/find")
	public ResponseEntity<List<SoccerTeam>> findByName(@RequestParam String name)
	{
		return ResponseEntity.ok(soccerTeamService.findByName(name));
	}

	
	@PostMapping()
	public ResponseEntity<SoccerTeam> save(@RequestBody @Valid SoccerTeamRequestPostDTO soccerTeamRequestPost)
	{
		return new ResponseEntity<SoccerTeam>(soccerTeamService.save(soccerTeamRequestPost),HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id)
	{
		soccerTeamService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// replace indica que você está substituindo totalmente o objeto, e não apenas um atributo
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody @Valid SoccerTeamRequestPutDTO soccerTeamRequestPut)
	{
		soccerTeamService.replace(soccerTeamRequestPut);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		
}

