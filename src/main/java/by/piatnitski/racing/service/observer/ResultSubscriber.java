// ResultSubscriber.java
package by.piatnitski.racing.service.observer;

public interface ResultSubscriber {
    void update(RaceResultEvent event);
}