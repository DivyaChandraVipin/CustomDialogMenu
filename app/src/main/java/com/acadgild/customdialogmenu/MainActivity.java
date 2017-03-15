package com.acadgild.customdialogmenu;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.acadgild.customdialogmenu.database.DBAdapter;
import com.acadgild.customdialogmenu.listview.PersonAdapter;
import com.acadgild.customdialogmenu.object.PersonObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
Dialog d;
    Button btnDate;
    ListView lv;
    DBAdapter db;
    EditText dateBirth;
    String new_phone;
    int new_phone_value;
    Calendar dateTime=Calendar.getInstance();
    PersonAdapter personAdapter;
    ArrayList<PersonObject> persondetails=new ArrayList<>();
   DateFormat formatDate=DateFormat.getDateInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listViewPerson) ;
        db=new DBAdapter(MainActivity.this);
        db.openDB();
        personAdapter=new PersonAdapter(this,persondetails);
        lv.setAdapter(personAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.OptionAdd: {

                d=new Dialog(MainActivity.this);
                d.setTitle("About");
                d.setContentView(R.layout.custom_dialog);
                final Button btnAdd=(Button)d.findViewById(R.id.btnAddDetail);
                final EditText name = (EditText)
                        d.findViewById(R.id.editTextName);
                final String personName=name.getText().toString();
                dateBirth=(EditText)d.findViewById(R.id.editTextDate) ;
                //name.setText("");
                final EditText phoneno = (EditText)d.findViewById(R.id.editTextPhone);
                final    String phone=phoneno.getText().toString();
                btnDate=(Button)d.findViewById(R.id.btnCalDate);
                final  DatePickerDialog.OnDateSetListener dialog = new DatePickerDialog.OnDateSetListener() {

                    @Override

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateTime.set(Calendar.YEAR, year);
                        dateTime.set(Calendar.MONTH, monthOfYear);
                        dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        dateTime.set(Calendar.HOUR_OF_DAY, 0);
                        dateTime.set(Calendar.MINUTE, 0);
                        dateTime.set(Calendar.SECOND, 0);
                        dateTime.set(Calendar.MILLISECOND, 0);

                        dateBirth.setText(formatDate.format(dateTime.getTime()));


                    }

                };
                btnDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new DatePickerDialog(MainActivity.this,dialog, dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });

                d.show();
               btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            new_phone=phoneno.getText().toString();
                            new_phone_value = Integer.parseInt(new_phone);
                        }
                        catch(NumberFormatException e)
                        {
                            new_phone_value=0;
                        }
                        db.add(name.getText().toString(),new_phone_value,dateBirth.getText().toString());
                        d.dismiss();
                        getPersonDetails();
                    }
                });
                break;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
    private void getPersonDetails()
    {
        persondetails.clear();
        PersonObject personObject=null;
        Cursor c=db.retrieve();
        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String name=c.getString(1);
            int phoneno=c.getInt(2);
            String date=c.getString(3);
            personObject=new PersonObject();
            personObject.setId(id);
            personObject.setName(name);
            personObject.setPhoneno(phoneno);
            personObject.setDateOfBirth(" "+date);
            persondetails.add(personObject);
        }
        lv.setAdapter(personAdapter);

    }
}
