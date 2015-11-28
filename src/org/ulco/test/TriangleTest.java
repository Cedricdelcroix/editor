package org.ulco.test;

import junit.framework.TestCase;
import org.ulco.GraphicsObject;
import org.ulco.Point;
import org.ulco.Rectangle;
import org.ulco.Triangle;

public class TriangleTest extends TestCase {

    public void testType() throws Exception {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 2), new Point(10, 4));

        assertTrue(triangle instanceof Triangle);
        assertTrue(triangle instanceof GraphicsObject);
    }

    public void testJson() throws Exception {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 2), new Point(10, 4));

        assertEquals(triangle.toJson(), "{ type: triangle, point1: { type: point, x: 0.0, y: 0.0 }, point2: { type: point, x: 5.0, y: 2.0 }, point3: { type: point, x: 10.0, y: 4.0 } }");
    }

    public void testCopy() throws Exception {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 2), new Point(10, 4));

        assertEquals(triangle.toJson(), triangle.copy().toJson());
    }
}