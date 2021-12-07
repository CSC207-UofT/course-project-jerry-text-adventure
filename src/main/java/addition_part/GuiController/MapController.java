package addition_part.GuiController;

import addition_part.GuiUsecase.TextAdventureMap;
import entity.BasePokemon;
import entity.Pokemon;
import entity.PokemonBook;
import usecase_pokemon.PokemonFactory;

import java.util.ArrayList;
import java.util.List;

public class MapController{
    private final List<TextAdventureMap> textAdventureMaps;
    private TextAdventureMap currentPlace;

    /**
     * Construct MapController, given them the new list and null value
     */

    public MapController() {
        this.textAdventureMaps = new ArrayList<>();
        this.currentPlace = null;
    }

    /**
     * Construct MapController, given them the new list and currentPlace
     * @param currentPlace the currentPlace that player in
     *
     * @see TextAdventureMap
     * @see RandomAlgorithm
     * @see PokemonBook
     * @see PokemonFactory
     * @see BasePokemon
     */

    public MapController(TextAdventureMap currentPlace) {
        this.textAdventureMaps = new ArrayList<>();
        this.currentPlace = currentPlace;
    }

    public void setCurrentPlace(TextAdventureMap currentPlace) {
        this.currentPlace = currentPlace;
    }


    public List<TextAdventureMap> getTextAdventureMaps() {
        return textAdventureMaps;
    }

    public TextAdventureMap find(String mapName) {
        for (TextAdventureMap textAdventureMap : textAdventureMaps) {
            if (textAdventureMap.getMapName().equals(mapName)) {
                return textAdventureMap;
            }
        }
        return null;
    }

    public Pokemon walkAround(PokemonBook pokemonBook) {
        RandomAlgorithm ra = new RandomAlgorithm(this.currentPlace);
        PokemonFactory pokemonFactory = new PokemonFactory();
        BasePokemon basePokemon = ra.encounter(pokemonBook);
        if (basePokemon != null) {
            Pokemon newPokemon = pokemonFactory.getPokemon(basePokemon, ra.randomExp(), 0);
            PokemonController.heal(newPokemon);
            return newPokemon;
        }
        else{
            return null;
        }
    }

    public TextAdventureMap getCurrentPlace() {
        return currentPlace;
    }


}