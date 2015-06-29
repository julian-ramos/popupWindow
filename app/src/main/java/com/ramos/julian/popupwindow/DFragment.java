package com.ramos.julian.popupwindow;

/**
 * Created by julian on 6/22/15.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DFragment extends DialogFragment {
    Button plusButton,minusButton,submitButton;
    EditText edit;
    Integer score;
    String TAG = "dialog";
    static int taskScore;
    Intent intent;
    public static final String BROADCAST_ACTION="dialog2main";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialogfragment, container,
                false);
        intent = new Intent(BROADCAST_ACTION);

        getDialog().setTitle("DialogFragment Tutorial");
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        plusButton = (Button)rootView.findViewById(R.id.plusbutton);
        minusButton = (Button)rootView.findViewById(R.id.minusbutton);
        submitButton = (Button)rootView.findViewById(R.id.submitbutton);
        edit= (EditText) rootView.findViewById(R.id.editText);


        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edit!=null) {
                    if (edit.getText().toString().equalsIgnoreCase("")){
                        score=0;
                    }
                    else{
                        score=Integer.parseInt(edit.getText().toString())+1;
                    }
                    edit.setText(String.valueOf(score));

                }
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edit!=null) {

                    if (edit.getText().toString().equalsIgnoreCase("")){
                        edit.setText(String.valueOf(0));
                    }
                    else{
                        score = Integer.parseInt(edit.getText().toString())-1;

                        if  (score >= 0){
                            edit.setText(String.valueOf(score));
                        } else {
                            edit.setText(String.valueOf("0"));
                        }
                    }

                    Log.d(TAG,"edit is different from null");
                }
                else{
                    edit.setText(String.valueOf("0"));
                    Log.d(TAG, "edit is null");
                }

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit.getText().toString().equalsIgnoreCase("")){
                    edit.setText("0");
                }


            intent.putExtra("score",edit.getText().toString());
            getActivity().sendBroadcast(intent);
//            sendBroadcast(intent);
            dismiss();
            }
        });

        // Do something else
        return rootView;
    }

}