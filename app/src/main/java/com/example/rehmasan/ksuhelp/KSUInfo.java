package com.example.rehmasan.ksuhelp;

import java.io.Serializable;

/*this script handles the layout of all the information we will have about hogwarts*/
public class KSUInfo implements Serializable
{
    public String words;        // text part of a ListView entry
    public int pic;             // resource for the image part of a ListView entry
    public int gotoRef;         // Used by ArrayAdapter to tell the fragment code which
    // navigation TextView to highlight when a category header
    // is shown on the screen.

    KSUInfo(String w, int p, int gotoR)
    {
        words = w;
        pic = p;
        gotoRef = gotoR;
    }
}