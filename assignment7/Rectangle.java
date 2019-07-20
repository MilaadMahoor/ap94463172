public class Rectangle extends Shape {

    public int lenth,width;
    public double enviroment,area;

    public Rectangle(int lenth,int width){

        super(lenth,width);
        this.lenth=lenth;
        this.width=width;
    }


    public double enviroment () {
        enviroment = 2*(lenth+width);
        return enviroment;
    }
    public double area(){
        area =lenth*width;

        return area;
    }
    public void print(){
        System.out.println("Rectangle");
        System.out.println("Enviroment:"+enviroment+"    Area:"+area);
    }

    public String toString(){
        return String.valueOf(area);

    }

}
