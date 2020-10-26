package agh.cs.lab2;

public class World {

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal);
        String[] movesString = {"r","f","f","f"};
        MoveDirection[] moves = OptionsParser.parse(movesString);
        for(MoveDirection move: moves){
            animal.move(move);
        }
        System.out.println(animal);
    }
}
