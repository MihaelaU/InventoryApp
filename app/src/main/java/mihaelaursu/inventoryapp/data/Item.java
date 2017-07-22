package mihaelaursu.inventoryapp.data;

/**
 * Created by ursum on 22/07/2017.
 */

public class Item {

    private final String productName;
    private final String price;
    private final int quantity;
    private final String providerName;
    private final String providerPhone;
    private final String providerEmail;
    private final String image;

    public Item(String productName, String price, int quantity, String providerName, String providerPhone, String providerEmail, String image) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.providerName = providerName;
        this.providerPhone = providerPhone;
        this.providerEmail = providerEmail;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public String getProviderEmail() {
        return providerEmail;
    }

    public String getImage() {
        return image;
    }
    @Override
    public String toString() {
        return "Item{" +
                "productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                ", providerName='" + providerName + '\'' +
                ", providerPhone='" + providerPhone + '\'' +
                ", providerEmail='" + providerEmail + '\'' +
                '}';
    }

}

