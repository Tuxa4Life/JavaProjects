package fop.w9store;

public enum ScrewDrive {
    SlotDrive {
        @Override
        public String toString() {
            return "schlitz";
        }
    },
    Cross {
        @Override
        public String toString() {
            return "kreuzschlitz";
        }
    },
    Hex {
        @Override
        public String toString() {
            return "sechskant";
        }
    },
    Torx {
        @Override
        public String toString() {
            return "torx";
        }
    };

    @Override
    public abstract String toString();
}