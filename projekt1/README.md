# Projekt 1: Symulacja

## Konfiguracja(Intellij idea)
1. Dodać do VM options: --module-path "Scieżka do folderu lib biblioteki JavaFX" --add-modules=javafx.controls,javafx.fxml
2. Oddzielnie dodać biblioteke JavaFX: Project Structure -> Libraries
3. Załadować pom.xml
4. Zbudować projekt i gotowe :)

## Parametry początkowe
Wszystko powinno być tak jak w specyfikacji. Pole singleSimulation mówi nam czy jest jedna symulacja czy dwie.
Czas pomiedzy kolejnymi iteracjami epok jest w klasie ThreadSimulation. 
### Zalecenia co do parametrów początkowych
 - wartość przerwy > 200ms (sleep)
 - wielkość mapy 30x30
 - ilość zwierząt(0-100)
(dla innych parametrów symulacja może działać niepoprawnie, powodem jest złożoność rysowania widoków mapy, która dla większych parametrów "nie wyrabia")
## Kolory na mapie 
1. Kolor zielony -> puste pole na mapie
2. Kolor jasnobrązowy -> trawa
3. Odcienie szarego -> zwierze (im ciemniejsze tym ma więcej energii)
4. Granatowy -> obserwowane zwierze
5. Fioletowy -> zwierzęta z najbardziej popularnym genem 
