package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        if (league.contains(team)) {
            System.out.println("Team already in league.");
            return false;
        } else  {
            System.out.println("Team " + team.getName() + " has been added to league.");
            league.add(team);
            return true;
        }
    }

    public boolean removeTeam(String name) {
        for (T team: league) {
            if (team.getName().equals(name)) {
                System.out.println("Team " + name + " has been removed from " + this.name);
                return true;
            }
        }
        System.out.println("Team not found.");
        return false;
    }

    public void leagueTable() {
        Collections.sort(league);
        for(T t: league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
