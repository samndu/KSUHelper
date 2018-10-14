package com.example.rehmasan.ksuhelp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class infoViewAdapter extends ArrayAdapter<KSUInfo>
{
    private Context myContext;
    /*It should be noted that HogwartsInfo is the name of a script, which is being referenced here for managing
     * our info*/
    private List<KSUInfo> infoList;
    /*references the page fragment script to create this variable*/
    private PageFragment pageCallback = null;

    infoViewAdapter(Context context, ArrayList<KSUInfo> list, PageFragment cb)
    {
        super (context, 0, list);
        myContext = context;
        infoList = list;
        pageCallback = cb;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;
        if(listItem == null)
        {
            listItem = LayoutInflater.from(myContext).inflate(R.layout.piece_of_info, parent, false);
        }
        KSUInfo currentInfo = getItem(position);

        if (currentInfo == null)
        {
            Log.e("ERROR", "infoViewAdapter:getView() could not get currentInfo");
            return listItem;
        }
        /*get the following text and image views*/
        TextView infoWordsText = listItem.findViewById(R.id.infoWordsView);
        TextView infoGotoText = listItem.findViewById(R.id.infoGoto);
        ImageView infoImage = listItem.findViewById(R.id.infoImageView);

        /*check and make sure whatever needs to be visible, is visible. If there is no picture associated with the info,
         * there is no need to do anything*/
        if (currentInfo.pic != CategoryAdapter.NO_PIC)
        {
            infoWordsText.setVisibility(View.VISIBLE);
            infoImage.setVisibility(View.VISIBLE);
            infoGotoText.setVisibility(View.GONE);

            infoWordsText.setText(currentInfo.words);
            infoImage.setImageResource(currentInfo.pic);
        }

        else
        {
            infoWordsText.setVisibility(View.GONE);
            infoImage.setVisibility(View.GONE);
            infoGotoText.setVisibility(View.VISIBLE);

            infoGotoText.setText(currentInfo.words);

            pageCallback.setButtonCallback(currentInfo.gotoRef);
        }

        return listItem;
    }
}