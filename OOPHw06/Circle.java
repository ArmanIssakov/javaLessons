package OOPHw06;

public class Circle extends Shape {

    Circle(double digit){
        super(digit);
    }

    @Override
    String getName() {
        return "Круг";
    }

    @Override
    String getSizeName() {
        return "(радиус)";
    }

    @Override
    double getArea() {
        return Math.PI*getRadiusOrSide()*getRadiusOrSide();
    }
    
}
