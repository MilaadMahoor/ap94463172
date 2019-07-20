public class Circle extends Shape  {

    public int radius;
    public double pi = Math.PI;
    public double enviroment,area;


    public Circle(int radius){

        super(radius);
        this.radius=radius;


    }

    public double enviroment () {
        enviroment = (2*radius)*pi;
        enviroment = (long) (Math.round(enviroment*100)/100.0d);
        return enviroment;
    }
    public double area(){
        area=(radius*radius)*pi;
        area = (long) (Math.round(area*100)/100.0d);
        return area;
    }
    public void print(){
        System.out.println("Circle");
        System.out.println("Enviroment:"+enviroment+"    Area:"+area);
    }
    public String toString(){
        return String.valueOf(area);

    }
}
