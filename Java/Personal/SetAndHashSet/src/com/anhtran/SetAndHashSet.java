package com.anhtran;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.anhtran.HeavenlyBody.BodyType;

public class SetAndHashSet {
	private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
	private static Set<HeavenlyBody> planets = new HashSet<>();

	public static void main(String[] args) {
		 HeavenlyBody temp = new Planet("Mercury", 88);
		 solarSystem.put(temp.getKey(), temp);
		 planets.add(temp);
	
		 temp = new Planet("Venus", 225);
		 solarSystem.put(temp.getKey(), temp);
		 planets.add(temp);
	
		 temp = new Planet("Earth", 365);
		 solarSystem.put(temp.getKey(), temp);
		 planets.add(temp);
		 
		 HeavenlyBody tempMoon = new Moon("Moon", 27);
		 solarSystem.put(tempMoon.getKey(), tempMoon);
		 temp.addSatellite(tempMoon);
		 
		 temp = new Planet("Mars", 687);
		 solarSystem.put(temp.getKey(), temp);
		 planets.add(temp);
		 
		 tempMoon = new Moon("Deimos", 1.3);
		 solarSystem.put(tempMoon.getKey(), tempMoon);
		 temp.addSatellite(tempMoon);
		 
		 tempMoon = new Moon("Phobos", 0.3);
		 solarSystem.put(tempMoon.getKey(), tempMoon);
		 temp.addSatellite(tempMoon);
		 
		 temp = new Planet("Jupiter", 4332);
		 solarSystem.put(temp.getKey(), temp);
		 planets.add(temp);
		 
		 tempMoon = new Moon("Io", 1.8);
		 solarSystem.put(tempMoon.getKey(), tempMoon);
		 temp.addSatellite(tempMoon);
		 
		 tempMoon = new Moon("Europa", 3.5);
		 solarSystem.put(tempMoon.getKey(), tempMoon);
		 temp.addSatellite(tempMoon);
		 
		 tempMoon = new Moon("Ganymede", 7.1);
		 solarSystem.put(tempMoon.getKey(), tempMoon);
		 temp.addSatellite(tempMoon);
		 
		 tempMoon = new Moon("Callisto", 16.7);
		 solarSystem.put(tempMoon.getKey(), tempMoon);
		 temp.addSatellite(tempMoon);
		 
		 temp = new Planet("Saturn", 10759);
		 solarSystem.put(temp.getKey(), temp);
		 planets.add(temp);
		 
		 temp = new Planet("Uranus", 30660);
		 solarSystem.put(temp.getKey(), temp);
		 planets.add(temp);
		 
		 temp = new Planet("Neptune", 165);
		 solarSystem.put(temp.getKey(), temp);
		 planets.add(temp);
		 
		 temp = new Planet("Pluto", 248);
		 solarSystem.put(temp.getKey(), temp);
		 planets.add(temp);
		 
		 System.out.println("Planets:");
		 for (HeavenlyBody planet : planets) {
			System.out.println("\t" + planet.getKey());
		}
		 
		 HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", BodyType.PLANET));
		 System.out.println("\nMoons of " + body.getKey());
		 for (HeavenlyBody jupiterMoon : body.getSatellites()) {
			System.out.println("\t" + jupiterMoon.getKey());
		} 
		 
		Set<HeavenlyBody> moons = new HashSet<>();
		for (HeavenlyBody planet : planets) {
			moons.addAll(planet.getSatellites());
		}
		
		System.out.println("\nAll Moons");
		for (HeavenlyBody moon : moons) {
			System.out.println("\t" + moon.getKey());
		}
		
		HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
		planets.add(pluto);
		
		for (HeavenlyBody planet : planets) {
	//			System.out.println(planet.getKey() + ": "  + planet.getOrbitalPeriod());
			System.out.println(planet);
		}
		
		HeavenlyBody earth1 = new Planet("Earth", 365);
		HeavenlyBody earth2 = new Planet("Earth", 365);
		System.out.println(earth1.equals(earth2));
		System.out.println(earth2.equals(earth1));
		System.out.println(earth1.equals(pluto));
		System.out.println(pluto.equals(earth1));
		
		solarSystem.put(pluto.getKey(), pluto);
		System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", BodyType.PLANET)));
		System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", BodyType.DWARF_PLANET)));
	
		System.out.println();
		System.out.println("The solar system contains:");
		for(HeavenlyBody heavenlyBody : solarSystem.values()) {
			System.out.println(heavenlyBody);
		}
	}

}
