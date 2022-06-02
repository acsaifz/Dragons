package hu.progmatic.model;

import java.util.Arrays;
import java.util.Objects;

public class BaseDragon {
    private final int id;
    private String name;
    private Rarity rarity;
    private String description;
    private Element[] elements;

    public BaseDragon(int id, String name, int rarity, String description, String[] elements){
        this.name = name;
        this.rarity = Rarity.getByValue(rarity);
        this.description = description;
        this.id = id;
        this.elements = Element.getAllByValues(elements);
    }

    public int getId() {
        return id;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BaseDragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rarity=" + rarity +
                ", description='" + description + '\'' +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDragon that = (BaseDragon) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
