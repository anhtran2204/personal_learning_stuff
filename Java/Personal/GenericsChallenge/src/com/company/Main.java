package com.company;

public class Main {

    public static void main(String[] args) {
        League<Team<FootballPlayer>> NFL = new League<>("NFL");

        Team<FootballPlayer> adelaide = new Team<>("Melbourne");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        NFL.addTeam(adelaide);
        NFL.addTeam(melbourne);
        NFL.addTeam(hawthorn);
        NFL.addTeam(fremantle);

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaide, 3, 8);

        adelaide.matchResult(fremantle, 2, 1);

        NFL.leagueTable();
    }
}
