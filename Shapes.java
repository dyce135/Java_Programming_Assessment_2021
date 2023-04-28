public interface Shape {

    String getName(); // Shape name to be redefined by subclasses

    double getArea(); // shape area

    double getVolume(); // shape volume

}

public class Point implements Shape { // extends means “inherits from”

    private float x, y; // coordinates, could also be public as there is nothing
    // to protect, private for consistency with Circle/Cylinder

    public Point () { // constructor when no parameters
        x = 0;
        y = 0; // initiate x and y to 0
    }

    public Point (float xval, float yval) { // constructor with these parameters
        x = xval;
        y = yval; // get and set methods for the coordinates
    }

    public float getX () {
        return x; // returns the x co-ord when getX is called
    }

    public float getY () {
        return y; // returns the y co-ord when getY is called
    }

    public double getArea() {
        return 0; // has no area so returns 0
    }

    public double getVolume() {
        return 0; // has no volume so returns 0
    }

    public void setX (float xval) {
        x = xval; // define x as xval which is scanned as the user input
    }

    public void setY (float yval) {
        y = yval; // define y as yval which is scanned as the user input
    }

    @Override // overrides the Shape abstract method getName
    public String getName () {
        return "Point"; // returns the name of the shape
    }

    @Override // overrides the Object method toString (Shape inherits Object)
    public String toString () {
        return "[ " + x + ", "  + y + " ]"; // returns a string with the shape's position
    }

} // end class Point

public class Circle extends Point {

    private double r; // its radius

    public Circle () { // when no arguments
        super(); // calls the parent class constructors
        r = 0; // initialize and defaults r to 0
    }

    public Circle (float x, float y, double r) { // with these arguments
        super(x, y); // calls the parent class constructor
        setRadius(r); // call the method to set the radius
    }

    public double getRadius () {
        return r; // returns the radius
    }

    public void setRadius (double rval) {
        r = rval < 0 ? 0 : rval; // only accept the scanned rval input if it is non-negative, otherwise defaults to 0
    }

    @Override // overrides Shape getArea
    public double getArea () {
        return Math.PI * r * r; // arithmetically calculates and returns the area of circle
    }

    @Override // overrides Point getname
    public String getName () {
        return "Circle"; // returns name 'Circle' to all circle objects
    }

    @Override // overrides and uses the Point toString implementation
    public String toString () {
        return "= " + super.toString() + " with radius = " + r; // returns position and radius information of circle object
    }

} // end class Circle

public class Cylinder extends Circle {

    private double h; // its height

    public Cylinder () { // when constructor is called with no parameters
        super(); // calls parent constructors when no arguments
        h = 0; // defaults height to 0
    }

    public Cylinder (float x, float y, double r, double h) { // when constructor is called with these parameters
        super(x, y, r); // calls parent constructor with these parameters
        setHeight(h);  // get and set methods for the height
    }

    public double getHeight () {
        return h; // returns the height value
    }

    public void setHeight (double hval) {
        h = hval < 0 ? 0 : hval; // only accept the scanned hval input if it is non-negative, otherwise defaults to 0
    }

    @Override // overrides and uses Circle getArea
    public double getArea () {
        return 2 * super.getArea() + 2 * Math.PI * getRadius() * h; // arithmetically calculates and returns total area of cylinder
    }

    @Override // overrides Shape getVolume
    public double getVolume () {
        return super.getArea() * h; // arithmetically calculates and returns volume of cylinder
    }

    @Override // overrides Circle getname
    public String getName () {
        return "Cylinder"; // returns name 'Cylinder' for all cylinder objects
    }

    @Override // overrides and uses the Circle toString implementation
    public String toString () {
        return super.toString() + ", height = " + h; // returns position, radius, and height information of cylinder object
    }

} // end class Cylinder