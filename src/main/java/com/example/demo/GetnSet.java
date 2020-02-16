package com.example.demo;

import javax.servlet.RequestDispatcher;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller  
@RestController
public class GetnSet {
	
//using get method and hello-world as URI  
	@GetMapping(value = "/score", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getScoreBean() {
		String pattern = "{ \"playerOneWins\": \"%s\", \"playerTwoWins\": \"%s\", \"draws\": \"%s\", \"rounds\": \"%s\"}";
				return String.format(pattern,ScoreBean.winInt,ScoreBean.lossInt,ScoreBean.drawInt,ScoreBean.roundsNo);
	}
		
	@RequestMapping(path = "/score/wins", method = RequestMethod.GET)
	public int getWins() {
		return ScoreBean.winInt;
	}
	@RequestMapping(value = "/score/loss", method = RequestMethod.GET)
	public int getLosses() {
		return ScoreBean.lossInt;
	}
	@RequestMapping(value = "/score/draw", method = RequestMethod.GET)
	public int getDraw() {
		return ScoreBean.drawInt;
	}
	
	@RequestMapping(value = "/RPS", method = RequestMethod.GET)
	public int RoPaSi() {
		switch (ScoreBean.p1Choice) {
		case 1:
			if (ScoreBean.p2Choice == 1) {
				ScoreBean.drawInt++;
				return ScoreBean.drawInt;	
			}
			if (ScoreBean.p2Choice == 2) {
				ScoreBean.lossInt++;
				return ScoreBean.lossInt;
			}
			if (ScoreBean.p2Choice == 3) {
				ScoreBean.winInt++;
				return ScoreBean.winInt;
			}
			ScoreBean.roundsNo++;
			break;
		case 2:
			if (ScoreBean.p2Choice == 1) {
				ScoreBean.winInt++;
				return ScoreBean.winInt;
			}
			if (ScoreBean.p2Choice == 2) {
				ScoreBean.drawInt++;
				return ScoreBean.drawInt;
			}
			if (ScoreBean.p2Choice == 3) {
				ScoreBean.lossInt++;
				return ScoreBean.lossInt;
			}
			ScoreBean.roundsNo++;
			break;
		case 3:
			if (ScoreBean.p2Choice == 1) {
				ScoreBean.lossInt++;
				return ScoreBean.lossInt;
			}
			if (ScoreBean.p2Choice == 2) {
				ScoreBean.winInt++;
				return ScoreBean.winInt;
			}
			if (ScoreBean.p2Choice == 3) {
				ScoreBean.drawInt++;
				return ScoreBean.drawInt;	
			}
			ScoreBean.roundsNo++;
			break;
		}
		
		return ScoreBean.roundsNo;
	}
	
	@RequestMapping(value = "/p1rock", method = RequestMethod.POST)
	public int p1Rock() {
		ScoreBean.p1Choice = 1;
		return ScoreBean.p1Choice;
	}
	@RequestMapping(value = "/p1paper", method = RequestMethod.POST)
	public int p1Paper() {
		ScoreBean.p1Choice = 2;
		return ScoreBean.p1Choice;
	}
	@RequestMapping(value = "/p1scissor", method = RequestMethod.POST)
	public int p1Scissors() {
		ScoreBean.p1Choice = 3;
		return ScoreBean.p1Choice;
	}
	@RequestMapping(value = "/p2rock", method = RequestMethod.POST)
	public int p2Rock() {
		ScoreBean.p2Choice = 1;
		return ScoreBean.p1Choice;
	}
	@RequestMapping(value = "/p2paper", method = RequestMethod.POST)
	public int p2Paper() {
		ScoreBean.p2Choice = 2;
		return ScoreBean.p2Choice;
	}
	@RequestMapping(value = "/p2scissor", method = RequestMethod.POST)
	public int p2Scissors() {
		ScoreBean.p2Choice = 3;
		return ScoreBean.p2Choice;
	}
//	@RequestMapping(value = "/score/wins", method = RequestMethod.POST)
//	public int winInc() {
//		ScoreBean.winInt++;
//		return ScoreBean.winInt;
//	}
//	
//	@RequestMapping(value = "/score/loss", method = RequestMethod.POST)
//	public int lossInc() {
//		ScoreBean.lossInt++;
//		return ScoreBean.lossInt;
//	}
//	@RequestMapping(value = "/score/draw", method = RequestMethod.POST)
//	public int drawInc() {
//		ScoreBean.drawInt++;
//		return ScoreBean.drawInt;
//	}

	@RequestMapping(value = "/score", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(int winInt, int lossInt, int drawInt, int roundsNo) {
		ScoreBean.winInt = winInt;
		ScoreBean.lossInt = lossInt;
		ScoreBean.drawInt = drawInt;
		ScoreBean.roundsNo = roundsNo;
		String pattern = "{ \"playerOneWins\": \"%s\", \"playerTwoWins\": \"%s\", \"draws\": \"%s\" \"rounds\": \"%s\"}";
		return String.format(pattern,ScoreBean.winInt,ScoreBean.lossInt,ScoreBean.drawInt);
	}
	@RequestMapping(value = "/reset", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String reset(int winInt, int lossInt, int drawInt, int roundsNo) {
		ScoreBean.winInt = 0;
		ScoreBean.lossInt = 0;
		ScoreBean.drawInt = 0;
		ScoreBean.roundsNo = 0;
		String pattern = "{ \"playerOneWins\": \"%s\", \"playerTwoWins\": \"%s\", \"draws\": \"%s\" \"rounds\": \"%s\"}";
		return String.format(pattern,ScoreBean.winInt,ScoreBean.lossInt,ScoreBean.drawInt);
	}
}