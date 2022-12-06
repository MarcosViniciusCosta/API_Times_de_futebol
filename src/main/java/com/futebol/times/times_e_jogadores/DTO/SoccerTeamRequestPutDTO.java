package com.futebol.times.times_e_jogadores.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

//DTO do request do tipo post que esconde o id
@Data
public class SoccerTeamRequestPutDTO 
{
	@Min(value = 1,message = "Id não pode ser menor ou igual a zero")
	private Long id;
	@NotEmpty (message = "Nome do time não pode ser vazio")
	private String name;
	@Min(value = 100000,message = "Valor de Time não pode ser tão baixo")
	private Double marketValue;
	@NotEmpty (message = "Nome de país não pode ser vazio")
	private String country;
}
