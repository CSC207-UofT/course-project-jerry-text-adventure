package entity;

import java.util.List;

public class PokemonBook {
    private List<BasePokemon> pokemonBook;

    public BasePokemon get(int i) {
        return pokemonBook.get(i);
    }

    public BasePokemon get(String name) {
        for (BasePokemon basePokemon : pokemonBook) {
            if (basePokemon.getName().equals(name)) {
                return basePokemon;
            }
        }
        return null;
    }
}
