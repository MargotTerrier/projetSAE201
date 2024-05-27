package org.uphf.projetsae201.Controller;

import org.uphf.projetsae201.Model.*;
import org.uphf.projetsae201.View.GUI;

import java.util.Random;

public class VGraphique {
    private GUI gui;
    private Monde m;
    private EventGUI eg;

    public VGraphique() {
        this.m = new Monde(2, new Random().nextInt(2, 5), 10, 10);
        gui = new GUI(m);
        this.eg = new EventGUI(this);

    }

    public GUI getGUI() {
        return gui;
    }
    public Monde getMonde(){
        return this.m;
    }












}
