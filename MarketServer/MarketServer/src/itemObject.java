
public class itemObject {
    public String name;
    public String price;
    public String bidAmount;
    public String availability;
    public String highestBidder;

    public itemObject(String[] itemInfo){
        
            this.name = itemInfo[0];
            this.price = itemInfo[1];
            this.bidAmount = itemInfo[2];
            this.availability = itemInfo[3];
            this.highestBidder = itemInfo[4];

    }
}
