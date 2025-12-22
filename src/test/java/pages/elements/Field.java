package pages.elements;


public abstract class Field {

    public enum Color {
        RED("rgb(220, 53, 69)"),
        GREEN("rgb(40, 167, 69)");
        private final String rgb;
        Color(String rgb) {
            this.rgb = rgb;
        }
        public String getValue() {
            return rgb;
        }
    }
}

