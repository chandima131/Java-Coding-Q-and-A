package org.example;

public class Activity {

    private String activity;
    private double accessibility;
    private String type;
    private int participants;
    private double price;
    private String key;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(double accessibility) {
        this.accessibility = accessibility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

//    public boolean isValid(){
//        return activity !=null && !activity.isEmpty()
//                && accessibility >=0
//                && type !=null && !type.isEmpty()
//                && participants >=0
//                && price >=0
//                && key != null && !key.isEmpty();
//    }

    @Override
    public String toString() {
        return "Activity{" +
                "activity='" + activity + '\'' +
                ", accessibility=" + accessibility +
                ", type='" + type + '\'' +
                ", participants=" + participants +
                ", price=" + price +
                ", key=" + key +
                '}';
    }
}
