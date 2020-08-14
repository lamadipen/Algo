package kata.recursiondynamicprogramming.stackofboxes;

public class Box {
    int width;
    int height;
    int length;

    public Box(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public boolean canBeOnTop(Box bottom) {
        if (this.width < bottom.width && this.height < bottom.height && this.length < bottom.length) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
