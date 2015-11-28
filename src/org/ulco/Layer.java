package org.ulco;

import java.util.Vector;
public class Layer extends Group {
    public Vector<GraphicsObject> m_list;
    protected int m_ID;
    public Layer() {
        m_list = new Vector<>();
        m_ID = ID.getInstance().generate();
    }

    public Layer(String json) {
        m_list= new Vector<>();
        String str = json.replaceAll("\\s+","");
        int objectsIndex = str.indexOf("objects");
        int endIndex = str.lastIndexOf("}");

        parseObjects(str.substring(objectsIndex + 9, endIndex - 1));
    }

    public void add(GraphicsObject o) {
        m_list.add(o);
    }

    public GraphicsObject get(int index) {
        return m_list.elementAt(index);
    }

    public int getObjectNumber() {
        return m_list.size();
    }

    public int getID() {
        return m_ID;
    }


}
