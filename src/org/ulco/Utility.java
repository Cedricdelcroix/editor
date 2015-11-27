package org.ulco;

import java.util.Vector;

/**
 * Created by cedric on 27/11/2015.
 */
public abstract class Utility {
    public static GraphicsObjects select(Point pt, double distance, Vector<Layer> m_layers) {

        GraphicsObjects list = new GraphicsObjects();

        for (Layer layer : m_layers) {
            list.addAll(Utility.select(pt, distance,layer));
        }
        return list;
    }

    public static GraphicsObjects select(Point pt, double distance,Layer layer) {
        GraphicsObjects list = new GraphicsObjects();

        for (GraphicsObject object : layer.m_list) {
            if (object.isClosed(pt, distance)) {
                list.add(object);
            }
        }
        return list;
    }

    public static String toJson(Vector<Layer> m_layers){
            String str = "{ type: document, layers: { ";

            for (int i = 0; i < m_layers.size(); ++i) {
                Layer element = m_layers.elementAt(i);

                str += Utility.toJson(element);
                if (i < m_layers.size() - 1) {
                    str += ", ";
                }
            }
            return str + " } }";
    }

    public static String toJson(Layer layer) {
        String str = "{ type: layer, objects : { ";

        for (int i = 0; i < layer.m_list.size(); ++i) {
            GraphicsObject element = layer.m_list.elementAt(i);

            str += element.toJson();
            if (i < layer.m_list.size() - 1) {
                str += ", ";
            }
        }
        return str + " } }";
    }

    public static int searchSeparator(String str) {
        int index = 0;
        int level = 0;
        boolean found = false;

        while (!found && index < str.length()) {
            if (str.charAt(index) == '{') {
                ++level;
                ++index;
            } else if (str.charAt(index) == '}') {
                --level;
                ++index;
            } else if (str.charAt(index) == ',' && level == 0) {
                found = true;
            } else {
                ++index;
            }
        }
        if (found) {
            return index;
        } else {
            return -1;
        }
    }

}
