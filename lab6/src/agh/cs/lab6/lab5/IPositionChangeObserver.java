package agh.cs.lab6.lab5;

import agh.cs.lab6.lab5.prev.base.Vector2d;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
