package entities;

import java.util.ArrayList;
import java.util.Collections;


public class Topic {
    
    private ArrayList<Pass> seats;
    private int MaxPrefSeats;
    private int OcpPrefSeats;
    private int MaxNormalSeats;
    private int OcpNormalSeats;

    public Topic(int seatsTotal, int MaxPrefSeats){
        this.seats = new ArrayList<>(Collections.nCopies(seatsTotal, null));
        this.MaxPrefSeats = MaxPrefSeats;
        this.OcpPrefSeats = 0;
        this.MaxNormalSeats = seatsTotal - MaxPrefSeats;
        this.OcpNormalSeats = 0;
    }

    public boolean toBoard(Pass pass){
        for(int i=0;i<seats.size();i++){
            if(seats.get(i) != null && pass.getName().equals(seats.get(i).getName())){
                System.out.println("Passenger already registered.");
                return false;
            }
            if(pass.getAge() >= 60){
                if(OcpPrefSeats + 1 <= MaxPrefSeats && seats.get(i) == null){
                    seats.set(i, pass);
                    OcpPrefSeats += 1;
                    return true;
                }if(seats.get(i) == null){
                    seats.set(i, pass);
                    OcpNormalSeats += 1;
                    return true;
                }
                System.out.println("Crowded vehicle");
                return false;
            }if(pass.getAge() < 60){
                if(OcpNormalSeats + 1 <= MaxNormalSeats){
                    if(i >= MaxPrefSeats && seats.get(i) == null){
                        seats.set(i, pass);
                        OcpNormalSeats += 1;
                        return true;
                    }
                }if(OcpPrefSeats + 1 <= MaxPrefSeats && OcpNormalSeats == MaxNormalSeats){
                    if(seats.get(i) == null){
                        seats.set(i, pass);
                        OcpPrefSeats += 1;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void land(String name){
        for(int i=0;i<seats.size();i++){
            if(seats.get(i) != null && name.equals(seats.get(i).getName())){
                if(seats.get(i).getAge() >= 60)
                    OcpPrefSeats -= 1;
                else
                    OcpNormalSeats -= 1;
                seats.set(i, null);
                return;
            }
        }
        System.out.println("Passenger not found.");
        return;
    }
    
}
