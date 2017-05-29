package nl.olaf.coolgame.settings.settingtypes;

/**
 * Created by Hoodz on 29/05/2017.
 */

public class FieldSettings {

    private Size fieldSize;

    private enum Size {
        SMALL(10, 10),
        MEDIUM(15, 15),
        LARGE(20, 20);

        private final int width;
        private final int height;

        Size(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }
    }

    public FieldSettings() {
        this.fieldSize = Size.SMALL;
    }

    public Size getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(Size fieldSize) {
        this.fieldSize = fieldSize;
    }

}
