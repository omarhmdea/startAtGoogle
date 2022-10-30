package Exercises.week2.Enums;

public enum Bird {
    LOON("Gavia immer") {
        @Override
        public String sing() {
            return "cooo-leee";
        }
    },
    CUCKOO("Cuculus canorus") {
        @Override
        public String sing() {
            return "ku-ku";
        }
    },
    CROW("Corvus brachyrhynchos") {
        @Override
        public String sing() {
            return "caw-caw-caw-caw-koodle-yah";
        }
    },
    RAVEN("Corvus corax") {
        @Override
        public String sing() {
            return "cruck-cruck";
        }
    };


    Bird(String scientificName) {
        this.scientificName = scientificName;
    }


    private final String scientificName;
    public abstract String sing();
}
