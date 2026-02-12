package segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import point.Point;

public class SegmentTest {

    @Test
    void constructeur_4_attrs_ok() {
        assertDoesNotThrow(() -> new Segment(1, 2, 3, 4));
    }

    @Test
    void constructeur_2_attrs_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
        assertDoesNotThrow(() -> new Segment(org, ext));
    }
    
    @Test
    void print_class_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
        Segment seg;
		try {
			seg = new Segment(org, ext);
			System.out.println(seg);
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }
    
    @Test
    void getOrigine_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
		try {
			Segment seg = new Segment(org, ext);
			System.out.println(seg.getOrigine());
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }
    
    @Test
    void getExtremite_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
		try {
			Segment seg = new Segment(org, ext);
			System.out.println(seg.getExtremite());
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }
    
    @Test
    void setOrigine_1_attr_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
		try {
			Segment seg = new Segment(org, ext);
			System.out.println(seg.getExtremite());
	        assertEquals(seg.getOrigine(), org);
	        Point nw = new Point(10, 7);
	        seg.setOrigine(nw);
	        assertEquals(seg.getOrigine(), nw);
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }
    
    @Test
    void setOrigine_2_attrs_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
		try {
			Segment seg = new Segment(org, ext);
	        assertEquals(seg.getOrigine(), org);
	        Point nw = new Point(10, 7);
	        seg.setOrigine(nw.getX(), nw.getY());
	        assertEquals(seg.getOrigine().toString(), nw.toString());
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }

    @Test
    void setExtremite_1_attr_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
		try {
			Segment seg = new Segment(org, ext);
	        assertEquals(seg.getExtremite(), ext);
	        Point nw = new Point(10, 7);
	        seg.setExtremite(nw);
	        assertEquals(seg.getExtremite(), nw);
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }
    
    @Test
    void setExtremite_2_attrs_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
		try {
			Segment seg = new Segment(org, ext);
	        assertEquals(seg.getExtremite(), ext);
	        Point nw = new Point(10, 7);
	        seg.setExtremite(nw.getX(), nw.getY());
	        assertEquals(seg.getExtremite().toString(), nw.toString());
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }
    
    @Test
    void getLongueur_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
		try {
			Segment seg = new Segment(org, ext);
	        seg.setLongueur();
	        assertEquals(seg.getLongueur(), Math.sqrt(8));
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }

    @Test
    void projX_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
		try {
			Segment seg = new Segment(org, ext);
	        Point proj = seg.projX();
	        Point projTest = new Point(seg.getVec().getX(), 0);
	        assertEquals(proj.toString(), projTest.toString());
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }

    @Test
    void projY_ok() {
    	Point org = new Point(1, 2);
    	Point ext = new Point(3, 4);
		try {
			Segment seg = new Segment(org, ext);
	        Point proj = seg.projY();
	        Point projTest = new Point(0, seg.getVec().getY());
	        assertEquals(proj.toString(), projTest.toString());
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }
    
    @Test
    void init_exception() {
    	Point org = new Point(1, 2);
		try {
			Segment seg = new Segment(org, org);
			System.out.println(seg);
		} catch (Exception e) {
			System.out.println("Erreur: Les points sont les mêmes");
		}
    }
}