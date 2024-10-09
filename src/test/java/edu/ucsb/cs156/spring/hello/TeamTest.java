package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_test(){
        Team team = new Team("test-team");
        Team team2 = new Team("test-team");
        Team team3 = new Team("test-team2");
        assert(team.equals(team2));
        assert(team.equals(team));
        assert(team.equals("lmao") == false);
        assert(team.equals(team3) == false);

        team2.addMember("me");
        team.addMember("you");
        assert(team.equals(team2) == false);
    }

    @Test
    public void hashcode_test(){
        Team team = new Team("test-team");
        Team team2 = new Team("test-team");
        Team team3 = new Team("test-team2");
        assert(team.hashCode() == team2.hashCode());
        assert(team.hashCode() != team3.hashCode());

        team2.addMember("me");
        team.addMember("you");
        assert(team.hashCode() != team2.hashCode());
    }

}
