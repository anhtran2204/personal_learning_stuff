package academy.learnprogramming;

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie {

    public Jaws() {
        super("Jaws");
    }

    public String plot() {
        return "A shark that hunts lots of people";
    }
}

class IndependenceDay extends Movie {

    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Alien attempts to take over Earth";
    }
}

class MazeRunner extends Movie {

    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Group of teenagers trying to uncover mysteries about society";
    }
}

class StarWars extends Movie {

    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial Forces trying to take over universe";
    }
}

class Forgettable extends Movie {

    public Forgettable() {
        super("Forgettable");
    }
}

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie # " + i + ": " + movie.getName()+ "\n" +
                    "Plot: " + movie.plot() + "\n");
        }
    }

    public static Movie randomMovie() {
       int randNum = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated was: " + randNum);

        switch (randNum) {
            case 1:
                return new Jaws();

            case 2:
                return new IndependenceDay();

            case 3:
                return new MazeRunner();

            case 4:
                return new StarWars();

            case 5:
                return new Forgettable();
        }
        return null;
    }
}
