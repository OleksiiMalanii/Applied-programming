// src/main/Main.java
package main;

import robots.*;
import combat.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Robot> robots = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create a robot");
            System.out.println("2. Show list of robots");
            System.out.println("3. Launch 1-on-1 battle");
            System.out.println("4. Launch team-on-team battle");
            System.out.println("5. Record battle in a file");
            System.out.println("6. Play battle from a saved file");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createRobot(scanner);
                    break;
                case 2:
                    showRobots();
                    break;
                case 3:
                    launchOneOnOneBattle(scanner);
                    break;
                case 4:
                    launchTeamOnTeamBattle(scanner);
                    break;
                case 5:
                    recordBattle(scanner);
                    break;
                case 6:
                    playBattle(scanner);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createRobot(Scanner scanner) {
        System.out.println("Enter robot type (1: Warrior, 2: Healer): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter robot name: ");
        String name = scanner.nextLine();

        Robot robot;
        if (type == 1) {
            robot = new WarriorRobot(name);
        } else {
            robot = new HealerRobot(name);
        }
        robots.add(robot);
        System.out.println("Robot created: " + robot.getName());
    }

    private static void showRobots() {
        for (int i = 0; i < robots.size(); i++) {
            Robot robot = robots.get(i);
            System.out.println(i + ": " + robot.getName() + " (Health: " + robot.getHealth() + ", Damage: " + robot.getDamage() + ")");
        }
    }

    private static void launchOneOnOneBattle(Scanner scanner) {
        System.out.println("Select first robot index: ");
        int index1 = scanner.nextInt();
        System.out.println("Select second robot index: ");
        int index2 = scanner.nextInt();

        if (index1 < robots.size() && index2 < robots.size()) {
            BattleRecord record = Combat.oneOnOne(robots.get(index1), robots.get(index2));
            System.out.println("Battle finished. " + record.getResult());
        } else {
            System.out.println("Invalid robot indices.");
        }
    }

    private static void launchTeamOnTeamBattle(Scanner scanner) {
        System.out.println("Enter number of robots in each team: ");
        int teamSize = scanner.nextInt();
        scanner.nextLine();

        Robot[] team1 = new Robot[teamSize];
        Robot[] team2 = new Robot[teamSize];

        System.out.println("Select robots for Team 1:");
        for (int i = 0; i < teamSize; i++) {
            System.out.println("Select robot index for position " + (i + 1) + ": ");
            int index = scanner.nextInt();
            if (index < robots.size()) {
                team1[i] = robots.get(index);
                if (team1[i] instanceof HealerRobot && i > 0) {
                    ((HealerRobot) team1[i]).heal(team1[i - 1]);
                }
            } else {
                System.out.println("Invalid index. Try again.");
                i--;
            }
        }

        System.out.println("Select robots for Team 2:");
        for (int i = 0; i < teamSize; i++) {
            System.out.println("Select robot index for position " + (i + 1) + ": ");
            int index = scanner.nextInt();
            if (index < robots.size()) {
                team2[i] = robots.get(index);
            } else {
                System.out.println("Invalid index. Try again.");
                i--;
            }
        }

        BattleRecord record = Combat.teamOnTeam(team1, team2);
        System.out.println("Team battle finished. " + record.getResult());
    }

    private static void recordBattle(Scanner scanner) {
        System.out.println("Enter filename to save the battle: ");
        String filename = scanner.nextLine();

        System.out.println("Select first robot index: ");
        int index1 = scanner.nextInt();
        System.out.println("Select second robot index: ");
        int index2 = scanner.nextInt();

        if (index1 < robots.size() && index2 < robots.size()) {
            BattleRecord record = Combat.oneOnOne(robots.get(index1), robots.get(index2));
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(record);
                System.out.println("Battle recorded to " + filename);
            } catch (IOException e) {
                System.out.println("Error recording battle: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid robot indices.");
        }
    }

    private static void playBattle(Scanner scanner) {
        System.out.println("Enter filename to play the battle: ");
        String filename = scanner.nextLine();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            BattleRecord record = (BattleRecord) ois.readObject();
            System.out.println("Battle result: " + record.getResult());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error playing battle: " + e.getMessage());
        }
    }
}