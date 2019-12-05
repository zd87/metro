package ratp;

public class Line {

    private String name;

    public Line(String name) {
	this.name = name;
    }

    public Line() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "Line: [name: " + name + "]";
    }
}
