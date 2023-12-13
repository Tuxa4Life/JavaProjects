public class RgbaColor extends RgbColor {
    private final int alpha;
    public RgbaColor(int bitDepth, int red, int green, int blue, int alpha) {
        super(bitDepth, red, green, blue);
        this.alpha = Math.min(Math.max(alpha, 0), (int) Math.pow(2, bitDepth) - 1);
    }

    public int getAlpha() {
        return alpha;
    }

    @Override
    public RgbColor8Bit toRgbColor8Bit() {
        if (alpha == (int) Math.pow(2, getBitDepth()) - 1) return super.toRgbColor8Bit();

        System.out.println("Error: alpha value is not set as to convert color to 8 bit.");
        return null;
    }
}
