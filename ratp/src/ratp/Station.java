package ratp;

public class Station {

    private String name;

    private Line line;

    public Station(String name, Line line) {
	this.name = name;
	this.line = line;
    }

    public Station() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Line getLine() {
	return line;
    }

    public void setLine(Line line) {
	this.line = line;
    }

    @Override
    public String toString() {
	return "Station: [" + line + ", name: " + name + "]";
    }
}
