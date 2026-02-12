package segment;

import point.Point;

public class Segment {
	private Point origine;
	private Point extremite;
	private Double longueur;
	private Point vec;
	
	public Segment(Point org, Point ext) throws Exception {
		if (org.getX() == ext.getX() && org.getY() == ext.getY())
			throw new Exception("Les 2 points sont les mêmes");
		origine = org;
		extremite = ext;
	}
	
	public Segment(double orgX, double orgY, double extX, double extY) throws Exception {
	    this(new Point(orgX, orgY), new Point(extX, extY));
	}
	
	@Override
	public String toString() {
		return "Segment(Origine: "+origine+", Extremite: "+extremite+")";
	}
	
	public Point getOrigine() {
		return origine;
	}
	
	public Point getExtremite() {
		return extremite;
	}
	
	public void setOrigine(Double orgX, Double orgY) {
		origine = new Point(orgX, orgY);
	}
	
	public void setOrigine(Point org) {
		origine = org;
	}
	
	public void setExtremite(Double extX, Double extY) {
		extremite = new Point(extX, extY);
	}
	
	public void setExtremite(Point ext) {
		extremite = ext;
	}
	
	public Double getLongueur() {
		if (longueur == null)
			setLongueur();
		return longueur;
	}
	
	public void setLongueur() {
		if (longueur == null) {
			this.setVec();
			longueur = this.getVec().getDistanceOrigine();
		}
	}
	
	public void setVec() {
		if (vec == null)
			vec = new Point(extremite.getX() - origine.getX(), extremite.getY() - origine.getY());
	}
	
	public Point getVec() {
		if (vec == null)
			setVec();
		return vec;
	}
	
    public Point projX(){
		if (vec == null)
			setVec();
        return vec.projX();
    }

    public Point projY(){
		if (vec == null)
			setVec();
        return vec.projY();
    }
}
