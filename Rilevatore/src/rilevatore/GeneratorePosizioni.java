/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rilevatore;

/**
 *
 * @author simone.bolzonella
 */
public class GeneratorePosizioni {
	private double lat;
	private double longi;
	
	public GeneratorePosizioni(){
		this.lat=45.05+Math.random()*((45.65-45.05)+1);
		this.longi=11.88+Math.random()*((12.38-11.88)+1);
	}
	
	public double getLatitudine(){
		return lat;
	}
	
	public double getLongitudine(){
		return longi;
	}
}