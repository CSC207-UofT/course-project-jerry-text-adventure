package gateway;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.BasePokemon;
import entity.BasePokemonData;
import entity.PokemonBook;
import entity.PokemonType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Scanner;

public class PokemonGate {
    public static HashMap<String, HashMap<String, Integer>> readPokemonInfo(){
        try{
            File pokemonFile = new File("gamedata/AllPokemonData.json");
            Scanner scanner = new Scanner(pokemonFile);
            StringBuilder pokemonData = new StringBuilder();
            while (scanner.hasNext()){pokemonData.append(scanner.next().strip());}
            String pokemonDataJson = pokemonData.toString();
            Gson gson = new Gson();
            Type dataType = new TypeToken<HashMap<String, HashMap<String, Integer>>>(){}.getType();
            return gson.fromJson(pokemonDataJson, dataType);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    return null;
    }

    public static PokemonBook toPokemonBook(){
        try{
            File pokemonFile = new File("gamedata/pokemon/AllPokemonData.json");
            Scanner scanner = new Scanner(pokemonFile);
            StringBuilder pokemonData = new StringBuilder();
            while (scanner.hasNext()){pokemonData.append(scanner.next().strip());}
            String pokemonDataJson = pokemonData.toString();
            Gson gson = new Gson();
            return gson.fromJson(pokemonDataJson, PokemonBook.class);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void writePokemonBook(PokemonBook pokemonBook){
        Gson gson = new Gson();
        String pokemonBookJson = gson.toJson(pokemonBook);
        try {
            FileWriter mapFile = new FileWriter("gamedata/pokemon/AllPokemonData.json");
            mapFile.write(pokemonBookJson);
            mapFile.close();}
        catch (IOException e) {
            e.printStackTrace();}
    }
}