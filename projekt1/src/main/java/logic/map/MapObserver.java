package logic.map;

import logic.model.map.Grass;

public interface MapObserver {
    public void onGrassRemoved(Grass grass);
}
