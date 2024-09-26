package laba1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Team {
    String name;
    String coach;
    String country;
    int foundationYear;

    public Team(String name, String coach, String country, int foundationYear) {
        this.name = name;
        this.coach = coach;
        this.country = country;
        this.foundationYear = foundationYear;
    }

    @Override
    public String toString() {
        return "Team: " + name + ", Coach: " + coach + ", Country: " + country + ", Foundation Year: " + foundationYear;
    }
}

class Player {
    String fullName;
    String position;
    LocalDate birthDate;
    int height;
    int weight;

    public Player(String fullName, String position, LocalDate birthDate, int height, int weight) {
        this.fullName = fullName;
        this.position = position;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return fullName + " - Position: " + position + ", Born: " + birthDate + ", Height: " + height + " cm, Weight: " + weight + " kg";
    }
}

public class labarotornay1 {

    public static void main(String[] args) {
       
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", "Xavi Hernandez", "Spain", 1899));
        teams.add(new Team("Manchester United", "Erik ten Hag", "England", 1878));
        teams.add(new Team("Bayern Munich", "Julian Nagelsmann", "Germany", 1900));

        
        List<Player> players = new ArrayList<>();
        players.add(new Player("Lionel Messi", "Forward", LocalDate.of(1987, 6, 24), 170, 72));
        players.add(new Player("Cristiano Ronaldo", "Forward", LocalDate.of(1985, 2, 5), 187, 83));
        players.add(new Player("Manuel Neuer", "Goalkeeper", LocalDate.of(1986, 3, 27), 193, 92));

        // Лямбда-выражение для фильтрации команд по стране
        Predicate<Team> isFromSpain = team -> team.country.equals("Spain");

        // Лямбда-выражение для фильтрации игроков по позиции
        Predicate<Player> isForward = player -> player.position.equals("Forward");

        // Выводим команды из Испании
        System.out.println("Teams from Spain:");
        teams.stream().filter(isFromSpain).forEach(System.out::println);

        // Выводим игроков на позиции форварда
        System.out.println("\nForwards:");
        players.stream().filter(isForward).forEach(System.out::println);
    }
}
