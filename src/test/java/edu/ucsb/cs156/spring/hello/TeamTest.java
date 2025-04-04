package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

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
    public void testEquals_SameObject() {
        Team team = new Team("TeamA");
        team.addMember("Alice");
        assert team.equals(team); // Case 1: same object
    }

    @Test
    public void testEquals_DifferentClass() {
        Team team = new Team("TeamA");
        assert !team.equals("Some String"); // Case 2: different class
    }

    @Test
    public void testEquals_TT() {
        Team team1 = new Team("TeamA");
        team1.addMember("Alice");

        Team team2 = new Team("TeamA");
        team2.addMember("Alice");

        assert team1.equals(team2); // Case 3: T T
    }

    @Test
    public void testEquals_TF() {
        Team team1 = new Team("TeamA");
        team1.addMember("Alice");

        Team team2 = new Team("TeamA");
        team2.addMember("Bob");

        assert !team1.equals(team2); // Case 3: T F
    }

    @Test
    public void testEquals_FT() {
        Team team1 = new Team("TeamA");
        team1.addMember("Alice");

        Team team2 = new Team("TeamB");
        team2.addMember("Alice");

        assert !team1.equals(team2); // Case 3: F T
    }

    @Test
    public void testEquals_FF() {
        Team team1 = new Team("TeamA");
        team1.addMember("Alice");

        Team team2 = new Team("TeamB");
        team2.addMember("Bob");

        assert !team1.equals(team2); // Case 3: F F
    }

    @Test
    public void testHashCode_EqualsObjectsHaveEqualHashCodes() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
    
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
    
        assert t1.equals(t2);
        assert t1.hashCode() == t2.hashCode();
    }    
    // @Test
    // public void testHashCode_PrintActualValue() {
    //     Team t = new Team();
    //     t.setName("foo");
    //     t.addMember("bar");

    //     System.out.println("Actual hash: " + t.hashCode());
    //     assert false; // intentionally fail so the output prints
    // }


    @Test
    public void testHashCode_HardcodedValue() {
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");
    
        int expected = 130294; // ← the actual value from your run
        assert t.hashCode() == expected;
    }
    

}
