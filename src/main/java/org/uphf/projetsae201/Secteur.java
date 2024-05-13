package org.uphf.projetsae201;

abstract class  Secteur {
    protected static int id=0;

    public Secteur() {
        Secteur.id += 1;
    }

    public abstract int getId();
}
