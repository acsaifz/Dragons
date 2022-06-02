package hu.progmatic;

import hu.progmatic.model.BaseDragon;
import hu.progmatic.model.Element;
import hu.progmatic.model.Rarity;
import hu.progmatic.services.DataHandler;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        DataHandler dataHandler = new DataHandler();
        if(dataHandler.loadFiles(DataHandler.BASE_DRAGON_PATH,DataHandler.USER_DRAGON_PATH)){
            System.out.println("1. feladat: Névtelen UserDragonok száma: " + dataHandler.countNamelessUserDragons());
            System.out.println("2. feladat: UserDragon nélküli BaseDragonok száma: " + dataHandler.getBaseDragonsWithoutUserDragon().size());
            System.out.println("3. feladat: Jég elemű sárkányok száma: " + dataHandler.getDragonsWithElement(Element.ICE).size());
            System.out.println("4. feladat: Káosz első elemmel rendelkező UserDragonok száma: " + dataHandler.getUserDragonsWithFirstElement(Element.CHAOS).size());

            for (Map.Entry<Rarity,List<BaseDragon>> rarityGroup: dataHandler.getBaseDragonsGroupByRarity().entrySet()){
                System.out.println("5. feladat: " + rarityGroup.getKey() + ": " + rarityGroup.getValue().size() );
            }
            System.out.println("6. feladat: " + dataHandler.getBaseDragonsCountByRarity());
            System.out.println("7. feladat: Max szintű UserDragonok száma: " + dataHandler.countMaxLevelUserDragons());
        }
    }


}
