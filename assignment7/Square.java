public class Square extends Shape {

    public int side;
    public double enviroment,area;

    public Square(int side){
        super();
        this.side=side;
    }

    public double enviroment () {
        enviroment = 4*side;
        return enviroment;
    }
    public double area(){
        area=side*side;
        return area;
    }
    public void print(){
        System.out.println("Square");
        System.out.println("Enviroment:"+enviroment+"    Area:"+area);
    }
    public String toString(){
        return String.valueOf(area);

    }
}
