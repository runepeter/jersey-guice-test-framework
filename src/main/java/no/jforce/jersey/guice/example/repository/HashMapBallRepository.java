package no.jforce.jersey.guice.example.repository;

import java.util.HashMap;
import java.util.Map;

public class HashMapBallRepository implements BallRepository
{
    private final Map<Integer, String> map = new HashMap<Integer, String>();

    private int counter = 0;

    public int addNewBall(final String color)
    {
        int id = ++counter;
        map.put(id, color);
        return id;
    }

    public String getBall(final int id)
    {
        return map.get(id);
    }

    public void updateColor(final int id, final String color)
    {
        map.put(id, color);
    }

    public void deleteBall(final int id)
    {
        map.remove(id);
    }

}
