package com.example.rehmasan.ksuhelp;
import android.os.Bundle;
//these can be used to handle pagr fragments
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
/////////////////////////////////////////////
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class PageFragment extends Fragment implements View.OnClickListener {

    private ArrayList<KSUInfo> myInfo = new ArrayList<>();
    private View rootView;
    private ListView infoListView;


    private ArrayList<GotoButton> myGotos = new ArrayList<>();
    private ArrayList<TextView> myGotoTexts = new ArrayList<>();

    private TextView prevGoto = null;

    public PageFragment()
    {
        /*public constructor*/
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.info_list, container, false);

        if (savedInstanceState != null)
        {
            myInfo = (ArrayList<KSUInfo>) savedInstanceState.getSerializable(getString(R.string.myInfos));
            myGotos = (ArrayList<GotoButton>) savedInstanceState.getSerializable(getString(R.string.myGotos));
        }

        initViews();

        initAdapter();

        return rootView;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putSerializable(getString(R.string.myInfos), myInfo);
        outState.putSerializable(getString(R.string.myGotos), myGotos);
    }

    /*check and see if the user clocked on something, if so, go to that position*/
    @Override
    public void onClick(View v)
    {
        int numGoto = Integer.parseInt(v.getTag().toString());
        jumpToView(myGotos.get(numGoto).position);
    }

    public void setButtonCallback(int position)
    {
        highlightButton(myGotoTexts.get(position));
    }

    /*add in new info, if any*/
    public void addInfo(KSUInfo newInfo)
    {
        myInfo.add(newInfo);
    }

    /*add a navigation for the app*/
    public void addGoto(int textRes, String name)
    {
        myGotos.add(new GotoButton(textRes, name, myInfo.size() - 1));
    }

    private void initAdapter()
    {
        infoViewAdapter infoAdapter = new infoViewAdapter(getActivity(), myInfo, this);
        infoListView = rootView.findViewById(R.id.list);
        infoListView.setAdapter(infoAdapter);
    }

    private void initViews()
    {
        for (GotoButton g : myGotos)
        {
            TextView v = rootView.findViewById(g.textViewRes);
            v.setText(g.name);
            v.setOnClickListener(this);
            myGotoTexts.add(v);
        }
    }

    private void highlightButton(TextView v)
    {
        /*checks if the user clicked on the text, if not, the text will be grey*/
        if (prevGoto != null) {
            prevGoto.setTextColor(getResources().getColor(R.color.greyedOutText));
        }
        prevGoto = v;

        v.setTextColor(getResources().getColor(R.color.textColor));
    }

    private void jumpToView(int position)
    {
        infoListView.smoothScrollToPositionFromTop(position, 10);
    }
}