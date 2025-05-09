package main;

import input.KeyInputs;

public class BloodRoot {
    private BloodRootWindow bloodRootWindow;
    private BloodRootPannel bloodRootPannel;

    public BloodRoot() {
        bloodRootPannel = new BloodRootPannel();
        bloodRootWindow = new BloodRootWindow(bloodRootPannel);
        bloodRootPannel.requestFocus();
    }
}