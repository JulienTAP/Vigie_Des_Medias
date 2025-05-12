package Entities;

import Entities.Abstract.Being;

import java.util.ArrayList;

public class Rich extends Being {

    private ArrayList<Integer> ranks;

    public Rich(String name, ArrayList<Integer> ranks) {
        this.name = name;
        this.ranks = ranks;
        this.isMoral = true;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tranks = " + ranks.toString() +
                "\n\t" + printProperties(false);
    }

    public String printAll() {
        return super.toString() +
                "\n\t" + "ranks = " + ranks.toString() +
                printProperties(true).replace("\n", "\n" + "\t");
    }
}
