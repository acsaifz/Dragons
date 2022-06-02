package hu.progmatic.services;

import hu.progmatic.model.BaseDragon;
import hu.progmatic.model.Element;
import hu.progmatic.model.Rarity;
import hu.progmatic.model.UserDragon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataHandler {
    public static final String BASE_DRAGON_PATH = "src/main/resources/dragons.txt";
    public static final String SEPARATOR = "\\|";
    public static final String ELEMENT_SEPARATOR = ",";
    public static final String USER_DRAGON_PATH ="src/main/resources/user_dragons.txt";
    private final List<BaseDragon> baseDragonList = new ArrayList<>();
    private final List<UserDragon> userDragonList = new ArrayList<>();

    public int countMaxLevelUserDragons(){
        int count = 0;
        for (UserDragon userDragon: userDragonList){
            if (UserDragon.getMaxLevel(userDragon.getStar()) == userDragon.getLevel()){
                count++;
            }
        }
        return count;
    }

    public Map<Rarity,Integer> getBaseDragonsCountByRarity(){
        Map<Rarity,Integer> baseDradonsCountByRarity = new HashMap<>();
        for (BaseDragon baseDragon: baseDragonList){
            baseDradonsCountByRarity.putIfAbsent(baseDragon.getRarity(),0);
            baseDradonsCountByRarity.put(
                    baseDragon.getRarity(),
                    baseDradonsCountByRarity.get(baseDragon.getRarity())+1
            );
        }
        return baseDradonsCountByRarity;
    }
    public Map<Rarity,List<BaseDragon>> getBaseDragonsGroupByRarity(){
        Map<Rarity,List<BaseDragon>> baseDradonsGroupByRarity = new HashMap<>();
        for (BaseDragon baseDragon: baseDragonList){
            baseDradonsGroupByRarity.putIfAbsent(baseDragon.getRarity(),new ArrayList<>());
            baseDradonsGroupByRarity.get(baseDragon.getRarity()).add(baseDragon);
        }
        return baseDradonsGroupByRarity;
    }

    public List<UserDragon> getUserDragonsWithFirstElement(Element element){
        List<UserDragon> userDragonsWithElement = new ArrayList<>();
        for (UserDragon userDragon: userDragonList){
            if (element == userDragon.getBaseDragon().getElements()[0]){
                userDragonsWithElement.add(userDragon);
            }
        }
        return  userDragonsWithElement;
    }

    public List<BaseDragon> getDragonsWithElement(Element element){
        List<BaseDragon> baseDragonWithElement = new ArrayList<>();
        for (BaseDragon baseDragon: baseDragonList){
            for (Element dragonElement: baseDragon.getElements()){
                if(dragonElement == element){
                    baseDragonWithElement.add(baseDragon);
                }
            }
        }
        return  baseDragonWithElement;
    }
    public List<BaseDragon> getBaseDragonsWithoutUserDragon(){
        List<BaseDragon> baseDragonsWithoutUserDragon = new ArrayList<>();
        for (BaseDragon baseDragon: baseDragonList){
            boolean hasUser = false;
            for (UserDragon userDragon: userDragonList){
                if (baseDragon.equals(userDragon.getBaseDragon())){
                    hasUser = true;
                    break;
                }
            }
            if (!hasUser) {
                baseDragonsWithoutUserDragon.add(baseDragon);
            }
        }
        return baseDragonsWithoutUserDragon;
    }

    public boolean loadFiles( String baseDragonPath, String userDragonPath ){
        try{
            loadBaseDragons(baseDragonPath);
            loadUserDragons(userDragonPath);
        }catch (FileNotFoundException e){
            return false;
        }
        return true;
    }

    public int countNamelessUserDragons(){
        int count = 0;
        for (UserDragon userDragon: userDragonList){
            if (userDragon.getName().isBlank()){
                count++;
            }
        }
        return count;
    }

    public BaseDragon findBaseDragonById(int id){
        for (BaseDragon baseDragon: baseDragonList){
            if (baseDragon.getId() == id){
                return baseDragon;
            }
        }
        return null;
    }


    public void loadBaseDragons(String basePath) throws FileNotFoundException{
        Scanner reader = new Scanner(new File(basePath));
        while (reader.hasNextLine()){
            String[] line = reader.nextLine().split(SEPARATOR);
            baseDragonList.add(
                    new BaseDragon(
                            Integer.parseInt(line[0]),
                            line[1],
                            Integer.parseInt(line[2]),
                            line[3],
                            line[4].split(ELEMENT_SEPARATOR)
                    )
            );
        }
        reader.close();
    }

    public void loadUserDragons(String basePath) throws FileNotFoundException{
        Scanner reader = new Scanner(new File(basePath));
        while (reader.hasNextLine()){
            String[] line = reader.nextLine().split(SEPARATOR);
            BaseDragon baseDragon = findBaseDragonById(Integer.parseInt(line[0]));

            if(baseDragon == null) continue;

            userDragonList.add(
                    new UserDragon(
                            baseDragon,
                            line[1],
                            Integer.parseInt(line[2]),
                            Integer.parseInt(line[3])
                    )
            );
        }
    }

    public List<BaseDragon> getBaseDragonList() {
        return baseDragonList;
    }

    public List<UserDragon> getUserDragonList() {
        return userDragonList;
    }
}
