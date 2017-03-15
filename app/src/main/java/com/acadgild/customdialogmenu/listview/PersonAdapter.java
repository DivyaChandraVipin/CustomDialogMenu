package com.acadgild.customdialogmenu.listview;

import android.content.Context;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.acadgild.customdialogmenu.object.PersonObject;
import com.acadgild.customdialogmenu.R;
import java.util.ArrayList;

/**
 * Created by DivyaVipin on 3/14/2017.
 */

public class PersonAdapter extends BaseAdapter {
    Context c;
    int colors[] = new int[]{R.color.Violet, R.color.Red, R.color.Green,
            R.color.Orange, R.color.Blue, R.color.Indigo};


    public ArrayList<PersonObject> getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(ArrayList<PersonObject> personDetails) {
        this.personDetails = personDetails;
    }

    ArrayList<PersonObject> personDetails;
    LayoutInflater inflater;
    public PersonAdapter(Context c, ArrayList<PersonObject> personDetails) {
        this.c = c;
        this.personDetails  = personDetails;
        inflater= (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return personDetails .size();
    }

    @Override
    public Object getItem(int i) {
        return personDetails .get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null) {

            // inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            view = inflater.inflate(R.layout.customdialog_listitem, viewGroup, false);
            holder = new ViewHolder();
            holder.txtViewText = (TextView) view.findViewById(R.id.personText);

            view.setTag(holder);
        }else {
            holder= (ViewHolder)view.getTag();
        }

        holder.txtViewText.setBackgroundColor(ContextCompat.getColor(c,colors[i%6]));
                Integer a=personDetails.get(i).getPhoneno();
                String phone_Val=a.toString();
                String date=personDetails.get(i).getDateOfBirth();
                String person_name=personDetails.get(i).getName();
                holder.txtViewText.setText(" Name: "+person_name+"\n"+"  Phone No: "+phone_Val+"\n"+"  DateOfBirth: "+date);



        return view;

    }



    class ViewHolder{
        TextView txtViewText;

    }

}
