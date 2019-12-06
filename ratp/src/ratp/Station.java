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
	@Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (obj instanceof Station) {
	    Station test = (Station) obj;
	    if (test.getName().equals(this.name)) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public int hashCode() {
	return this.name.hashCode();
    }
}
