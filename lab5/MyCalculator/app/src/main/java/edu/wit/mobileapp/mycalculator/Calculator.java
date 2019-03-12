package edu.wit.mobileapp.mycalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Calculator extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.gender_main, container, false);

        Button myBtn = (Button) rootView.findViewById(R.id.myBtn1);
        final RadioGroup myRadioGrp = (RadioGroup) rootView.findViewById(R.id.RadioGroup);
        final EditText inch = rootView.findViewById(R.id.editTextInchesEntered);
        final EditText feet = rootView.findViewById(R.id.editTextFeetEntered);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int inches = Integer.valueOf(inch.getText().toString()) + Integer.valueOf(feet.getText().toString()) * 12;
                final double idealWeight = 2.3 * (inches - 60) + (myRadioGrp.getCheckedRadioButtonId() == R.id.radioButtonMale ? 50.0 : 45.5);
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Result result = new Result();
                result.setIdealWeight(idealWeight);
                result.setUserHeight(inches);
                result.setGender((myRadioGrp.getCheckedRadioButtonId() == R.id.radioButtonMale ? "Male" : "Female"));
                transaction.replace(R.id.container, result);
                transaction.commit();
            }
        });


        return rootView;
    }


}
