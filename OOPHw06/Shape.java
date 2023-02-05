package OOPHw06;

//Абстрактный суперклласс
public abstract class Shape {
    
   private double radiusOrSide;

    
    Shape(double digit){
        this.radiusOrSide = digit;
    }

   abstract String getName();

   abstract String getSizeName();

   public double getRadiusOrSide(){
    return radiusOrSide;
   };

   abstract double getArea();

   public void show(){

    System.err.println("Фигура: "+getName());

    System.out.println("Характерный размер: "+getRadiusOrSide()+" "+getSizeName());

    System.out.printf("Площадь: %.3f\n",getArea());

    System.out.println("");

   }

}
