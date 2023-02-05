package OOPHw06;

public class Triangle extends Shape {

    Triangle(double digit){
        super(digit);
    }

    @Override
    String getName() {
        return "треугольник";
    }

    @Override
    String getSizeName() {
        return "(сторона)";
    }

    @Override
    double getArea() {
        return Math.sqrt(3)/4*getRadiusOrSide()*getRadiusOrSide();
    }
     
}
