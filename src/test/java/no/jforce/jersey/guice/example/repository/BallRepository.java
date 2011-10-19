package no.jforce.jersey.guice.example.repository;

public interface BallRepository
{
    int addNewBall(String color);

    String getBall(int id);

    void updateColor(int id, String color);

    void deleteBall(int id);
}
