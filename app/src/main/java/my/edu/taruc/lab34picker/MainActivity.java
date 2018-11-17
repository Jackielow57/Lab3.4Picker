package my.edu.taruc.lab34picker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    Button buttonDate;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDate = findViewById(R.id.button);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datepicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        buttonDate.setText(dateMessage);
        Toast.makeText(this, getString(R.string.date) + dateMessage,
                Toast.LENGTH_SHORT).show();

        int Currentyear = Calendar.getInstance().get(Calendar.YEAR);
        age = Currentyear - year;

        TextView textViewAge = findViewById(R.id.textViewAge);
        textViewAge.setText("Age :" + age);
    }

    public void calculateEli(View view)
    {
        double minSaving = 0;
        double AccountBalance = 0;
        double eligbleAmount = 0;

        if(age >= 16 && age <= 20)
            minSaving = 5000;
        else if (age >= 21 && age <= 25)
            minSaving = 14000;
        else if (age >= 26 && age <= 30)
            minSaving = 29000;
        else if (age >= 31 && age <= 35)
            minSaving = 50000;
        else if (age >= 36 && age <= 40)
            minSaving = 78000;
        else if (age >= 41 && age <= 45)
            minSaving = 116000;
        else if (age >= 56 && age <= 50)
            minSaving = 165000;
        else if (age >= 51 && age <= 55)
            minSaving = 228000;

        EditText input = findViewById(R.id.editTextAccountBalance);
        AccountBalance = Double.parseDouble(input.getText().toString());

        if(AccountBalance > minSaving)
            eligbleAmount = (AccountBalance - minSaving) * 30 / 100;
        else
            eligbleAmount = 0;

        TextView textViewEligible = findViewById(R.id.textViewEligibleAmount);
        textViewEligible.setText("Eligible Amount :" + eligbleAmount);
    }

    public void reset(View view)
    {
        EditText input = findViewById(R.id.editTextAccountBalance);
        input.setText("");
        input.setHint("Account 1 Balance");

        buttonDate.setText("Select Date of Birth");

        TextView textViewAge = findViewById(R.id.textViewAge);
        textViewAge.setText("Age : 0" );

        TextView textViewEligible = findViewById(R.id.textViewEligibleAmount);
        textViewEligible.setText("Eligible Amount : 0.00");
    }
}
