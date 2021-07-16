package com.springbootpractice.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class MatchOdd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id",nullable = false)
    private Match match;


    //TODO: should be enumerated value
    @Column(name = "specifier")
    private String specifier;


    @Column(name = "odd")
    private BigDecimal odd;

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public BigDecimal getOdd() {
        return odd;
    }

    public void setOdd(BigDecimal odd) {
        this.odd = odd;
    }

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
    
    
}
