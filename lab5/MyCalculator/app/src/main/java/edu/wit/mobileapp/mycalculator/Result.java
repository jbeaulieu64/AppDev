package edu.wit.mobileapp.mycalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Result extends Fragment {

    private double idealWeight;
    private int height;
    private String gender;

    public void setIdealWeight(double idealWeight) { this.idealWeight = idealWeight; }
    public void setUserHeight(int height) {
        this.height = height;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.standard_main, container, false);

        ((TextView) rootView.findViewById(R.id.textView8)).setText(String.valueOf(idealWeight));
        ((TextView) rootView.findViewById(R.id.textView7)).setText(String.valueOf(height));
        ((TextView) rootView.findViewById(R.id.textView6)).setText(gender);

        return rootView;
    }
    // Equations
    //Male’s Ideal Body Weight = 50 kg + 2.3 kg * (Height(inches) - 60)
    //Female’s Ideal Body Weight = 45.5 kg + 2.3 kg * (Height(inches) - 60)

}
