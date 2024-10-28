package abm.javafxtemplate.communication;

import java.util.ArrayList;
import java.util.List;

public enum AppEvents {
    USER_ADDED;

    private final List<AppEventListener> listeners = new ArrayList<>();

    public void addListener(AppEventListener listener) {
        listeners.add(listener);
    }

    public void dispatch(EventData eventData) {
        listeners.forEach(listener -> listener.send(eventData));
    }

}
