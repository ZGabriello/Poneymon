package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.Random;

public class PoneyModel {
	String poneyColor;
	final double row; 
	double progression; 
	int lap;
	double speed;
	static final int NB_TOURS = 2;
	boolean isWinner;
			
	public PoneyModel(String color, double row) {
		Random randomGenerator = new Random();
		this.poneyColor = color;
		this.row = row;
		this.progression = 0;
		this.lap = 0;		        
        this.speed = randomGenerator.nextFloat() * 0.01;                			
	}
	
	public void step() {
		progression += speed;
		if (progression > 1) {
            progression = 0;
            lap++;
            Random randomGenerator = new Random();
            this.speed = randomGenerator.nextFloat() * 0.01;
            if (lap == NB_TOURS) {
            	this.isWinner = true;
            }
        }				
	}
	
	public double getRow() {
		return this.row;
	}
	
	public double getProgression() {
		return this.progression;
	}
	
	public String getColor() {
		return this.poneyColor;
	}
	
	public boolean getIsWinner() {
		return this.isWinner;
	}
	
	boolean win() {
    	return (lap == NB_TOURS);
    }
	
	public void check() {
		System.out.println(
				"Poney color : " + this.poneyColor +
				" row : " + this.row +
				" progression : " + this.progression +
				" lap : " + this.lap +
				" speed : " + this.speed);
	}
}
