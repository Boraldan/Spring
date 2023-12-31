package ru.boraldan.OnetoMany;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private Person owner;

    public Item(){
    }


    // конструктор до урока 54(включительно)
    public Item(String itemName, Person owner) {
        this.itemName = itemName;
        this.owner = owner;
    }

    // конструктор с урока 54(включительно) в добавок к методу addItem в Person
    public Item(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +

                ", item_name='" + itemName + '\'' +
                ", owner=" + owner +
                "}\n";
    }
}
