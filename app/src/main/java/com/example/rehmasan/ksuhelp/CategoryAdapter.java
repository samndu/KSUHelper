package com.example.rehmasan.ksuhelp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class CategoryAdapter extends FragmentPagerAdapter
{
    /*create variables here. We also need to give a value for when  there is no pic.*/
    private final static int NULL_VAL = -1;
    public final static int NO_PIC = -2;
    public final static int NUM_PAGE_FRAGS = 4;

    private Context myContext;

    private String tabTitles[];

    /*get the following titles for our app*/
    CategoryAdapter(@NonNull Context c, FragmentManager fm)
    {
        super(fm);
        myContext = c;
        tabTitles = new String[] { myContext.getString(R.string.homepage),
                myContext.getString(R.string.map), myContext.getString(R.string.events),
                myContext.getString(R.string.studentforum) };
    }

    /*cycle through the following methods*/
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                PageFragment featuredPageFrag = new PageFragment();
                setupFeaturedPageFrag(featuredPageFrag);
                return featuredPageFrag;
            case 1:
                PageFragment KsuMapPageFrag = new PageFragment();
                setupKsuMapPageFrag(KsuMapPageFrag);
                return KsuMapPageFrag;
            case 2:
                PageFragment EventsPageFrag = new PageFragment();
                setupEventsPageFrag(EventsPageFrag);
                return EventsPageFrag;
            default:
                PageFragment StudentForumPageFrag = new PageFragment();
                setupStudentForumPageFrag(StudentForumPageFrag);
                return StudentForumPageFrag;
        }
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        /*use the position to generate the titles*/
        return tabTitles[position];
    }

    @Override
    public int getCount()
    {
        return NUM_PAGE_FRAGS;
    }

    /*method for setting up the home page*/
    private void setupFeaturedPageFrag(PageFragment pageFrag)
    {
        pageFrag.addInfo(new KSUInfo(myContext.getResources().getString(R.string.home), R.drawable.home, NULL_VAL));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.home));
        pageFrag.addInfo(new KSUInfo(myContext.getString(R.string.history1), R.drawable.old, NULL_VAL));
    }

    /*method for setting up the general info home page*/
    private void setupKsuMapPageFrag(PageFragment pageFrag)
    {




    }

    /*method for setting up the Visiting Page*/
    private void setupEventsPageFrag(PageFragment pageFrag)
    {
        pageFrag.addInfo(new KSUInfo(myContext.getResources().getString(R.string.travelling), NO_PIC, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.travelling));


        pageFrag.addInfo(new KSUInfo(myContext.getResources().getString(R.string.attractions), NO_PIC, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.attractions));


        pageFrag.addInfo(new KSUInfo(myContext.getResources().getString(R.string.lodging), NO_PIC, 2));
        pageFrag.addGoto(R.id.goto2, myContext.getResources().getString(R.string.lodging));


        pageFrag.addInfo(new KSUInfo(myContext.getResources().getString(R.string.additionalInfo), NO_PIC, 3));
        pageFrag.addGoto(R.id.goto3, myContext.getResources().getString(R.string.additionalInfo));

    }

    /*method for setting up the Living Here Page*/
    private void setupStudentForumPageFrag(PageFragment pageFrag)
    {
        pageFrag.addInfo(new KSUInfo(myContext.getResources().getString(R.string.careers), NO_PIC, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.careers));
        pageFrag.addInfo(new KSUInfo(myContext.getResources().getString(R.string.career), NO_PIC, 0));

        pageFrag.addInfo(new KSUInfo(myContext.getResources().getString(R.string.admissions), NO_PIC, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.admissions));
        pageFrag.addInfo(new KSUInfo(myContext.getResources().getString(R.string.admins), NO_PIC, 0));
    }
}