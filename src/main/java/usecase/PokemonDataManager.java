package usecase;

import entity.*;

public class PokemonDataManager {
    public PokemonData create(BasePokemonData basePokemonData, int level) {
        int maxHitPoint = leveledPoint(basePokemonData.getMaxHitPoint(), level);
        int attackPoint = leveledPoint(basePokemonData.getAttackPoint(), level);
        int defencePoint = leveledPoint(basePokemonData.getDefencePoint(), level);
        int speed = leveledPoint(basePokemonData.getSpeed(), level);
        return new PokemonData(basePokemonData.getPokemonType(), maxHitPoint, attackPoint, defencePoint, speed);
    }

    public void update(PokemonData pokemonData, BasePokemonData basePokemonData, int level) {
        pokemonData.setMaxHitPoint(leveledPoint(basePokemonData.getMaxHitPoint(), level));
        pokemonData.setAttackPoint(leveledPoint(basePokemonData.getAttackPoint(), level));
        pokemonData.setDefencePoint(leveledPoint(basePokemonData.getDefencePoint(), level));
        pokemonData.setSpeed(leveledPoint(basePokemonData.getSpeed(), level));
    }

    private int leveledPoint(int basePoint, int level) {
        return (int) Math.round(basePoint * Math.sqrt(level));
    }
}
