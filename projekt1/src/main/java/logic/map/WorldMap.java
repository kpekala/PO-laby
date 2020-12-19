package logic.map;

import logic.model.GameConfig;
import logic.model.map.Grass;
import logic.model.map.animal.Animal;
import logic.model.Vector2d;
import ui.model.AnimalModel;

import java.util.ArrayList;
import java.util.HashMap;

public class WorldMap implements IWorldMap {

    private HashMap<Vector2d, ArrayList<Animal>> animals;
    private HashMap<Vector2d, Grass> grassElements;
    private ArrayList<Vector2d> eatingPlaces;
    private MapObserver mapObserver;
    private GameConfig config;

    private int width;
    private int height;
    private int plantEnergy;

    public WorldMap(GameConfig config, int width, int height, int plantEnergy) {
        this.config = config;
        this.width = width;
        this.height = height;
        this.plantEnergy = plantEnergy;
        animals = new HashMap<>();
        grassElements = new HashMap<>();
        eatingPlaces = new ArrayList<>();
    }

    public void attachObserver(MapObserver mapObserver){
        this.mapObserver = mapObserver;
    }

    @Override
    public void place(Animal animal) {
        Vector2d pos = animal.getPosition();
        if(animals.get(pos) == null)
            animals.put(pos, new ArrayList<>());
        animals.get(pos).add(animal);
        if(grassElements.containsKey(pos))
            eatingPlaces.add(pos);
    }

    @Override
    public void placeGrass(Grass grass) {
        if (grassElements.containsKey(grass.getPosition()))
            return;
        grassElements.put(grass.getPosition(),grass);
        if(animals.containsKey(grass.getPosition()))
            eatingPlaces.add(grass.getPosition());
    }

    public void remove(Animal animal,Vector2d oldPosition){
        if(animals.get(oldPosition) == null){
            System.out.println("Auć!");
            return;
        }
        if(!animals.get(oldPosition).contains(animal)){
            System.out.println(":)");
        }
        animals.get(oldPosition).remove(animal);
        if(animals.get(oldPosition).size() == 0)
            animals.remove(oldPosition);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null && animals.get(position).size() > 0;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }

    @Override
    public void eating() {
        for(Vector2d place: eatingPlaces){
            if(!isOccupied(place) || !grassElements.containsKey(place))
                continue;
            double maxEnergy = 0;
            ArrayList<Animal> bestAnimals = new ArrayList<>();
            Grass grass = grassElements.get(place);
            for(Animal animal: animals.get(place))
                if(maxEnergy < animal.getEnergy())
                    maxEnergy = animal.getEnergy();

            for(Animal animal: animals.get(place))
                if(animal.getEnergy() == maxEnergy)
                    bestAnimals.add(animal);

            double energyPerAnimal = plantEnergy / (double) bestAnimals.size();
            for(Animal animal: bestAnimals)
                animal.updateEnergy(energyPerAnimal);

            //Usuwanie zjedzonej trawy
            grassElements.remove(place);
            mapObserver.onGrassRemoved(grass);
        }
        eatingPlaces.clear();
    }

    public void breeding(){
        for(Vector2d pos: animals.keySet()){
            ArrayList<Animal> posAnimals = animals.get(pos);
            if(posAnimals.size()<2)
                continue;
            Animal[] bestAnimals = getTwoBestAnimals(posAnimals);
            Animal a1 = bestAnimals[0];
            Animal a2 = bestAnimals[1];
            if(canBreed(a1, a2)){
                a1.updateEnergy(-a1.getEnergy()/4f);
                a1.updateEnergy(-a2.getEnergy()/4f);
            }
        }
    }

    private boolean canBreed(Animal a1, Animal a2) {
        float neededEnergy = config.getStartEnergy()/2.0f;
        return a1.getEnergy() >= neededEnergy && a2.getEnergy() >= neededEnergy;
    }

    private Animal[] getTwoBestAnimals(ArrayList<Animal> anims){
        Animal a1 = anims.get(0);
        Animal a2 = anims.get(1);
        for(int i=2; i<anims.size(); i++){
            Animal a3 = anims.get(i);
            if(a3.getEnergy() > a1.getEnergy()){
                if (a3.getEnergy() > a2.getEnergy()){
                    if(a1.getEnergy() > a2.getEnergy())
                        a2 = a3;
                    else
                        a1 = a3;
                }else
                    a1 = a3;
            }
            else if(a3.getEnergy() > a2.getEnergy())
                a2 = a3;

        }
        return new Animal[]{a1, a2};
    }

    public ArrayList<AnimalModel> getAnimalModels(){
        ArrayList<AnimalModel> animalModels = new ArrayList<>();
        for(Vector2d pos : animals.keySet()){
            //Sortowanie potrzebne!
            if(isOccupied(pos))
                animalModels.add(new AnimalModel(animals.get(pos).get(0)));
        }
        return animalModels;
    }

    public void onAnimalMoved(Animal animal, Vector2d oldPosition, Vector2d newPosition){
        remove(animal, oldPosition);
        place(animal);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
