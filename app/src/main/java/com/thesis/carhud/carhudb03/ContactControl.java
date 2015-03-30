package com.thesis.carhud.carhudb03;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by l2ol3otic2 on 3/30/2015.
 */
public class ContactControl extends Activity {
    private static final int REQUEST_CODE_PICK_CONTACTS = 1;
    private final int PICK = 1;
    private ImageView imageViewRound;
    private Uri uriContact;
    private String contactID;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactlayout);
        //ImageView imageView2 = (ImageView) findViewById(R.id.imageView1);
        //Picasso.with(getApplicationContext()).load(R.drawable.pic1)
                //.transform(new RoundPic()).into(imageView2);

        Button addcontact = (Button) findViewById(R.id.ADDC);
        addcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                // calling OnActivityResult with intenet And Some conatct for Identifie
                startActivityForResult(intent, PICK);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        a++;
        if (resultCode == RESULT_OK) {
            if (requestCode == PICK) {
                Uri returnUri = data.getData();
                Cursor cursor = getContentResolver().query(returnUri, null, null, null, null);

                if (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    int columnIndex_ID = cursor.getColumnIndex(ContactsContract.Contacts._ID);
                    String contactID = cursor.getString(columnIndex_ID);
                    String Pic = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));

                    int columnIndex_HASPHONENUMBER = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
                    String stringHasPhoneNumber = cursor.getString(columnIndex_HASPHONENUMBER);

                    if (stringHasPhoneNumber.equalsIgnoreCase("1")) {
                        Cursor cursorNum = getContentResolver().query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactID,
                                null,
                                null);

                        //Get the first phone number
                        if (cursorNum.moveToNext()) {
                            int columnIndex_number = cursorNum.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                            String stringNumber = cursorNum.getString(columnIndex_number);
                            Log.d("Number", stringNumber);
                            Log.d("Name", name);
                            if(a==1) {
                                TextView n1 = (TextView) findViewById(R.id.n1);
                                n1.setText(name);
                            }
                            else if(a==2) {
                                TextView n2 = (TextView) findViewById(R.id.n2);
                                n2.setText(name);
                            }
                            else if(a==3) {
                                TextView n3 = (TextView) findViewById(R.id.n3);
                                n3.setText(name);
                            }
                        }

                    } else {
                        Log.d("Number", "NO Phone Number");
                    }

                     Log.d("Count",String.valueOf(a));
                } else {
                    Toast.makeText(getApplicationContext(), "NO data!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}





//Code1
       /* switch (reqCode) {
            case (PICK) :
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c =  getContentResolver().query(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        int columnIndex_ID = c.getColumnIndex(ContactsContract.Contacts._ID);
                        String contactID = c.getString(columnIndex_ID);
                        String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        String d = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        int columnIndex_HASPHONENUMBER = c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
                        String stringHasPhoneNumber = c.getString(columnIndex_HASPHONENUMBER);

                        if(stringHasPhoneNumber.equalsIgnoreCase("1")){
                            Cursor cursorNum = getContentResolver().query(
                                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                    null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactID,
                                    null,
                                    null);

                            //Get the first phone number
                            if(cursorNum.moveToNext()){
                                int columnIndex_number = cursorNum.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                                String stringNumber = cursorNum.getString(columnIndex_number);
                                Log.d("Number", stringNumber);
                            }

                        }else{
                            Log.d("Number","NO Phone Number");
                        }


                        Log.d("Name", name);

                    }
                }
                break;
        }*/

//Code2
       /* if (reqCode == PICK)
        {
            //Cursor cursor =  managedQuery(data.getData(), null, null, null, null);
            Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
            cursor.moveToNext();
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
            String  name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER)) ;
            String c = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Log.d("Name ", name);
            Log.d("Phone",phone);
            Log.d("Number" ,c);
            if (cursor != null && cursor.getCount() > 0)
                {
                 while (cursor.moveToNext())
                  {

   phNumber = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));

                      callDuration = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DURATION));
                      dur = Integer.parseInt(callDuration);

 }
               }

              cursor.close();

            cursor = null;
            name= null;
            phone = null;
            c=null;

        }*/


