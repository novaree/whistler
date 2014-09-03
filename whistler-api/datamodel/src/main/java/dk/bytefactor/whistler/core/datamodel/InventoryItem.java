package dk.bytefactor.whistler.core.datamodel;

/**
 * Created by casper on 31/08/14.
 */
public class InventoryItem {
    public enum InventoryItemType {
        BIKE, CAR;
    }

    private String inventoryItemId;
    private InventoryItemType itemType;
    private String make;
    private String model;
    private String year;
    private String color;
    private User owner;

    public InventoryItem() {}

    public InventoryItem(String inventoryItemId, InventoryItemType itemType, String make, String model, String year, String color, User owner) {
        this.inventoryItemId = inventoryItemId;
        this.itemType = itemType;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.owner = owner;
    }

    public String getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(String inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public InventoryItemType getItemType() {
        return itemType;
    }

    public void setItemType(InventoryItemType itemType) {
        this.itemType = itemType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "inventoryItemId='" + inventoryItemId + '\'' +
                ", itemType=" + itemType +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", owner=" + owner +
                '}';
    }
}
