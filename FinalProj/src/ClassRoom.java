public class ClassRoom {

    private String className;
    private int classSize =10;

    public ClassRoom(String className) {
        this.className = className;
    }

    public int getClassSize() {
        return classSize;
    }

    @Override
    public String toString() {
        return "Class:" + className;
    }

    public void changeSize(int num){
        classSize-=num;
    }
}
