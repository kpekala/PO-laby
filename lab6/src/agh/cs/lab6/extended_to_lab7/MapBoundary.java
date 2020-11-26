package agh.cs.lab6.extended_to_lab7;

import agh.cs.lab6.lab5.Grass;
import agh.cs.lab6.lab5.IMapElement;
import agh.cs.lab6.lab5.IPositionChangeObserver;
import agh.cs.lab6.lab5.prev.IWorldMap;
import agh.cs.lab6.lab5.prev.base.Animal;
import agh.cs.lab6.lab5.prev.base.Vector2d;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    SortedSet<IMapElement> sortedElementsByX = new TreeSet<>(comparatorByX());
    SortedSet<IMapElement> sortedElementsByY = new TreeSet<>(comparatorByY());

    private final IWorldMap map;

    public MapBoundary(IWorldMap map){
        this.map = map;
    }

    public void addElement(IMapElement element){
        sortedElementsByX.add(element);
        sortedElementsByY.add(element);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement el = (IMapElement) map.objectAt(oldPosition);
        if(el ==null){
            el = (IMapElement) map.objectAt(newPosition);
        }
        sortedElementsByX.remove(el);
        sortedElementsByY.remove(el);

        sortedElementsByX.add(el);
        sortedElementsByY.add(el);
    }
    Comparator<IMapElement> comparatorByX(){
        return (el1, el2) -> {
            Vector2d pos1 = el1.getPosition();
            Vector2d pos2 = el2.getPosition();
            if(pos1.x > pos2.x)
                return 1;
            else if (pos1.x < pos2.x)
                return -1;
            else{
                if(pos1.y > pos2.y)
                    return 1;
                else if (pos1.y < pos2.y)
                    return -1;
                return compareElementsByClass(el1,el2);
            }
        };
    }

    Comparator<IMapElement> comparatorByY(){
        return (el1, el2) -> {
            Vector2d pos1 = el1.getPosition();
            Vector2d pos2 = el2.getPosition();
            if (pos1.y > pos2.y)
                return 1;
            else if (pos1.y < pos2.y)
                return -1;
            else {
                if (pos1.x > pos2.x)
                    return 1;
                else if (pos1.x < pos2.x)
                    return -1;
                return compareElementsByClass(el1, el2);
            }
        };
    }
    int compareElementsByClass(IMapElement el1, IMapElement el2){
        if (el1 instanceof Animal && el2 instanceof Grass)
            return 1;
        else if (el1 instanceof Grass && el2 instanceof Animal)
            return -1;
        return 0;
    }

    public Vector2d getLowerBound(){
        Vector2d lX = sortedElementsByX.first().getPosition();
        Vector2d lY = sortedElementsByY.first().getPosition();
        return lX.lowerLeft(lY);
    }
    public Vector2d getUpperBound(){
        Vector2d uX = sortedElementsByX.last().getPosition();
        Vector2d uY = sortedElementsByY.last().getPosition();
        return uX.upperRight(uY);
    }
}
