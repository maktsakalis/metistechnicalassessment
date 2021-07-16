package com.springbootpractice.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "match_date")
	private LocalDate matchDate;

	@Column(name = "match_time")
	private LocalTime matchTime;

	@Column(name = "team_a")
	private String teamA;

	@Column(name = "team_b")
	private String teamB;

	@Enumerated(EnumType.STRING)
	private Sport sport;

	@OneToMany(mappedBy = "match", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	private Set<MatchOdd> matchOdds;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}

	public LocalTime getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(LocalTime matchTime) {
		this.matchTime = matchTime;
	}

	public String getTeamA() {
		return teamA;
	}

	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}

	public String getTeamB() {
		return teamB;
	}

	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public Set<MatchOdd> getMatchOdds() {
		return matchOdds;
	}

	public void addMatchOdd(MatchOdd matchOdd) {
		matchOdd.setMatch(this);
		matchOdds.add(matchOdd);
	}
	
	public void removeMatchOdd(MatchOdd matchOdd) {
		matchOdd.setMatch(null);
		matchOdds.remove(matchOdd);
	}
	
	

}
