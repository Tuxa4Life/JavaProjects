public class RgbColor {
    private final int bitDepth, red, green, blue;

    public RgbColor (int bitDepth, int red, int green, int blue) {
        this.bitDepth = Math.max(bitDepth, 1);
        this.red = Math.min(Math.max(red, 0), (int) Math.pow(2, bitDepth) - 1);
        this.green = Math.min(Math.max(green, 0), (int) Math.pow(2, bitDepth) - 1);
        this.blue = Math.min(Math.max(blue, 0), (int) Math.pow(2, bitDepth) - 1);
    }

    public RgbColor8Bit toRgbColor8Bit () {
        if (bitDepth > 8) {
            int redBit = (int) (red / Math.pow(2, bitDepth - 8)) % 2;
            int blueBit = (int) (blue / Math.pow(2, bitDepth - 8)) % 2;
            int greenBit = (int) (green / Math.pow(2, bitDepth - 8)) % 2;

            return new RgbColor8Bit(red / 2 + redBit, blue / 2 + blueBit, green /2 + greenBit);
        }

        if (bitDepth < 8) {
            return new RgbColor8Bit(red * 2, green * 2, blue * 2);
        }

        return new RgbColor8Bit(red, green, blue);
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

    public int getBitDepth() {
        return bitDepth;
    }
}
