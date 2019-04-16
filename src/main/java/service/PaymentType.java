package service;

public enum PaymentType {
    CASH("현금", 2f),
    CREDIT_CARD("신용카드", 5f);

    private PaymentType(String name, float discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }
    private String name;
    private float discountRate; // % 단위 할인율. ex. discountRate == 5 이면 할인율이 5%

    public int getDiscountedPrice(int price) {
        return (int)(price * ((100 - discountRate) / 100));
    }

    public String getName() {
        return name;
    }
}
