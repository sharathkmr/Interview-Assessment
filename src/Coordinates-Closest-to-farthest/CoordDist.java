
public class CoordDist {
	
	String id;
	double dist;
	Coordinates coordinates;
	
	public CoordDist(String id, double dist) {
		this.id = id;
		this.dist = dist;
	}
	
	public CoordDist(String id, double dist, Coordinates coordinates) {
		this.id = id;
		this.dist = dist;
		this.coordinates = coordinates;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getDist() {
		return dist;
	}
	public void setDist(double dist) {
		this.dist = dist;
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	@Override
	public String toString() {
		return "CoordDist [id=" + id + ", dist=" + dist + ", " + coordinates + "]";
	}
}
