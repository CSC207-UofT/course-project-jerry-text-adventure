package usecase;

import entity.*;


import java.util.ArrayList;
import java.util.List;

public class MapManager{
    private PokemonDataManager pokemonDataManager;
    private List<Pmap> pmaps;
    private Pmap currentPlace;

    public MapManager() {
        this.pokemonDataManager = new PokemonDataManager();
        this.pmaps = new ArrayList<>();
        this.currentPlace = null;
    }

    public MapManager(Pmap currentPlace) {
        this.pokemonDataManager = new PokemonDataManager();
        this.pmaps = new ArrayList<>();
        this.currentPlace = currentPlace;
    }

    public void setPmaps(List<Pmap> pmaps){
        this.pmaps = pmaps;
    }

    public List<Pmap> getMaps() {
        return pmaps;
    }

    public void addMap(Pmap pmap) {
        pmaps.add(pmap);
    }

    public Pmap start() {
        if (!pmaps.isEmpty()){return pmaps.get(0);}
        return null;
    }

    public Pmap find(String mapName) {
        for (Pmap pmap : pmaps) {
            if (pmap.getMapName().equals(mapName)) {
                return pmap;
            }
        }
        return null;
    }

    public Pokemon walkAround() {
        // TODO: return a random (according to the probability of currentPlace) pokemon.
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1000, 1000, 1000, 1000);
        BasePokemon basePokemon = new BasePokemon("Pikachu", basePokemonData);
        PokemonFactory pf = new PokemonFactory();
        return pf.getPokemon(basePokemon, 0, 1000);
    }

    public Pokemon walkAround(PokemonBook pokemonBook) {
        RandomAlgorithm ra = new RandomAlgorithm(this.currentPlace);
        PokemonFactory pokemonFactory = new PokemonFactory();
        return pokemonFactory.getPokemon(ra.encounter(pokemonBook), ra.randomExp());
    }

    public Pmap getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(Pmap currentPlace) {
        this.currentPlace = currentPlace;
    }

    public String getName(Pmap map) {
        return map.getMapName();
    }


}
