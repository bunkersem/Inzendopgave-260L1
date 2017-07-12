package models;

import java.util.ArrayList;

/**
 * Created by Sem on 09-Jul-17.
 */
public class Hotel {
    public static ArrayList<Hotel> hotels = null;

    public int id;
    public String name;

    public Hotel(final int id, final String name){
        this.id = id;
        this.name = name;
    }
}
