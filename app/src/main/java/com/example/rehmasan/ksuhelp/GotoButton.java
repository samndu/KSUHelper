package com.example.rehmasan.ksuhelp;

import java.io.Serializable;

/*This script is for making the go to button. that way we can navigate to a specific position in our app*/
public class GotoButton implements Serializable
{
    public int textViewRes;
    public String name;
    public int position;

    GotoButton(int tvR, String n, int p)
    {
        textViewRes = tvR;
        name = n;
        position = p;
    }
}