package com.company;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    private ArrayList<T> members = new ArrayList<>();
    int played = 0;
    int won = 0;
    int draw = 0;
    int lost = 0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println("Player already picked for team.");
            return false;
        } else {
            System.out.println(player.getName() + " has been picked for team " + this.name);
            members.add(player);
            return true;
        }
    }

    public boolean firePlayer(String name) {
        for (T player: members) {
            if (player.getName().equals(name)) {
                System.out.println("Player " + name + "'s contract has been terminated.");
                return true;
            }
        }
        System.out.println("Player not found.");
        return false;
    }

    public int size() {
        return this.members.size();
    }

    public void matchResult(Team<?> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            System.out.println(this.name + " won against " + opponent.getName());
            won++;
        } else if (theirScore > ourScore) {
            System.out.println(this.name + " lost against " + opponent.getName());
            lost++;
        } else {
            System.out.println(this.name + " drew against " + opponent.getName());
            draw++;
        }
        played++;
    }

    public int ranking() {
        return won*3 + draw;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
