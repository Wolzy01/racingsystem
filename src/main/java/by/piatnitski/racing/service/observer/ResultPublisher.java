package by.piatnitski.racing.service.observer;

import java.util.ArrayList;
import java.util.List;

public class ResultPublisher {

    private final List<ResultListener> listeners = new ArrayList<>();

    public void subscribe(ResultListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    public void unsubscribe(ResultListener listener) {
        listeners.remove(listener);
    }

    // ✅ метод, которого не хватало
    public void publish(RaceResultEvent event) {
        for (ResultListener l : listeners) {
            l.onResultFixed(event);
        }
    }

    // Интерфейс слушателя
    public interface ResultListener {
        void onResultFixed(RaceResultEvent event);
    }
}