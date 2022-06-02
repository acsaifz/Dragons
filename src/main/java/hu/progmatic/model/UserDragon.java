package hu.progmatic.model;

public class UserDragon {
    private BaseDragon baseDragon;
    private String name;
    private int level;
    private int star;

    public UserDragon(BaseDragon baseDragon, String name, int level, int star){
        this.baseDragon = baseDragon;
        this.name = name;
        this.level = level;
        this.star = star;
    }

    public static int getMaxLevel(int star){
        return switch (star){
            case 0 -> 40;
            case 1 -> 45;
            case 2 -> 50;
            case 3 -> 55;
            case 4 -> 60;
            case 5 -> 70;
            default -> throw new IllegalStateException("Unexpected value: " + star);
        };
    }

    public BaseDragon getBaseDragon() {
        return baseDragon;
    }

    public void setBaseDragon(BaseDragon baseDragon) {
        this.baseDragon = baseDragon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "UserDragon{" +
                "baseDragon=" + baseDragon +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", star=" + star +
                '}';
    }
}
