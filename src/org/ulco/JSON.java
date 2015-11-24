package org.ulco;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class JSON {
    static public Object parse(String json) {
        Object o = null;
        String str = json.replaceAll("\\s+", "");
        String type = str.substring(str.indexOf("type") + 5, str.indexOf(","));

        type = "org.ulco." + type.substring(0,1).toUpperCase() + type.substring(1,type.length());

        try {
            Class<?> maClasse = Class.forName(type);
            Constructor<?> constructor = maClasse.getConstructor(String.class);
            o = constructor.newInstance(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return o;
    }

    static public Group parseGroup(String json) {
        return new Group(json);
    }

    static public Layer parseLayer(String json) {
        return new Layer(json);
    }

    static public Document parseDocument(String json) {
        return new Document(json);
    }
}
