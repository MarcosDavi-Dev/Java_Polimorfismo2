package entities.enums;

public enum ProductType {
    COMMON(0),
    USED(1),
    IMPORTED(2);

    private final int code;

    ProductType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProductType valueOf(int code) {
        for (ProductType value : ProductType.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ProductType code: " + code);
    }
}
