package com.anhtran;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
	private final Key key;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites;
	
	public enum BodyType {
		STAR,
		PLANET,
		DWARF_PLANET,
		MOON,
		COMET,
		ASTEROID
	}
	
	public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
		this.key = new Key(name, bodyType);
		this.orbitalPeriod = orbitalPeriod;
		this.satellites = new HashSet<>();
	}

	public Key getKey() {
		return key;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public boolean addSatellite(HeavenlyBody satellite) {
		return this.satellites.add(satellite);
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}
	
	@Override
	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof HeavenlyBody) {
			HeavenlyBody theObj = (HeavenlyBody) obj;
			return this.key.equals(theObj.getKey());
		}
		return false;
	}

	@Override
	public final int hashCode() {
		return this.key.hashCode();
	}

	@Override
	public String toString() {
		return this.key.name + ": " + this.key.bodyType + ", "+ this.orbitalPeriod;
	}
	
	public static Key makeKey(String name, BodyType bodyType) {
		return new Key(name, bodyType);
	}
	
	public static final class Key {
		private String name;
		private BodyType bodyType;
		
		private Key(String name, BodyType bodyType) {
			this.name = name;
			this.bodyType = bodyType;
		}

		public String getName() {
			return name;
		}

		public BodyType getBodyType() {
			return bodyType;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.name.hashCode() + 57 + this.bodyType.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			Key key = (Key) obj;
			if (this.name.equals(key.getName())) {
				return (this.bodyType == key.getBodyType());
			}
			return false;
		}

		@Override
		public String toString() {
			return this.name + ": " + this.bodyType;
		}
	}
}
