package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Sanjana J.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("sanjana-jilla-913", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-06", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_Rachit() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Rachit"),"Team should contain Rachit");
    }

    @Test
    public void getTeam_returns_team_with_Aaryan() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Aaryan"),"Team should contain Aaryan");
    }


    @Test
    public void getTeam_returns_team_with_Saeed() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Saeed"),"Team should contain Saeed");
    }


    @Test
    public void getTeam_returns_team_with_Riya() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Riya"),"Team should contain Riya");
    }


    @Test
    public void getTeam_returns_team_with_Yarwin() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Yarwin"),"Team should contain Yarwin");
    }


}
