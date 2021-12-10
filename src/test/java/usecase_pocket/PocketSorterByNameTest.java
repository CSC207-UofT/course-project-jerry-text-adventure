package usecase_pocket;

import entity.Pocket;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PocketSorterByNameTest {
    PocketSorterByName testPSBN = new PocketSorterByName();
    Pocket testPocket = new Pocket();

    @Test
    public void sortTest() {
        testPocket.add(PokemonForTest.testPokemon1);
        testPocket.add(PokemonForTest.testPokemon3);
        testPocket.add(PokemonForTest.testPokemon4);
        testPocket.add(PokemonForTest.testPokemon2);
        testPSBN.sort(testPocket);
        assertTrue(testPocket.get(0).getLevel() == 4
                && testPocket.get(0).getName().equals("Test Pokemon 1")
                && testPocket.get(1).getLevel() == 3
                && testPocket.get(1).getName().equals("Test Pokemon 2")
                && testPocket.get(2).getLevel() == 2
                && testPocket.get(2).getName().equals("Test Pokemon 3")
                && testPocket.get(3).getLevel() == 1
                && testPocket.get(3).getName().equals("Test Pokemon 4"));
    }
}
