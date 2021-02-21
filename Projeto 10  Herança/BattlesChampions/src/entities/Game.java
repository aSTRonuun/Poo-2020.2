package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entities.Champions.Player;
import entities.Champions.Trol;
import entities.Champions.Warraior;
import entities.Champions.Wizard;
import entities.Champions.Assassin;
import entities.Champions.Mage;


public class Game {
    List<Player> players;
    Scanner sc = new Scanner(System.in);

    public Game(int nTrols){
        this.players = new ArrayList<>();
        for(int i=0;i<nTrols;i++)
            players.add(new Trol());
        players.add(new Mage());
        players.add(new Wizard());
        players.add(new Warraior());
        players.add(new Assassin());
        Collections.shuffle(players);
    }
    public void showPlayers(){
        for(Player player : players)
            System.out.print(player + " ");
        System.out.println("");
    }
    public void roundFight(){
        for(Player player : players){
            if(!player.isAlive())
                continue;
            Player target = player.selectTarget(this.players);
            System.out.print(player + " ⚔️  " + target + " ");
            if(player.ultimate(target))
                System.out.print("");
            else{
                player.attack(target); 
            }
            System.out.println(""); 
        }
    }
    public void rmvDeadBodies(){
        List<Player> aux = new ArrayList<Player>();
        for(Player player : players)
            if(player.isAlive())
                aux.add(player);
        players = aux;
    }
    public void play(){
        showPlayers();   
        while(players.size() > 1){
            System.out.print("Ready for battle?: (y/n) ");
            sc.next();
            System.out.println("FIGHT");
            roundFight();
            showPlayers();
            rmvDeadBodies();
        }
    }
    
}
