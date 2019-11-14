package com.example.insurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       // Toast.makeText(this,"Position = $position", Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"Item=${spinnerAge.getItemAtPosition(position)}",Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Associate
        spinnerAge.onItemSelectedListener=this

        buttonCalculate.setOnClickListener{
            calculatePremium();
        }
    }

    private fun calculatePremium(){
        //TODO calculate insurance premium
        var premium=0


    val age:Int=spinnerAge.selectedItemPosition
        premium=when(age){
            0->60
            1->70
            2->90
            3->120
            4->150
            else->150
        }

        //ID of a radiobutton checked by user
        val gender: Int=radioGroupGender.checkedRadioButtonId
        if(radioButtonMale.isChecked){
            premium += when(age){
                0->0
                1->50
                2->100
                3->150
                4->200
                else->200
            } }
        else premium+=0
            //booleanValue
        val smoker:Boolean=checkBoxSmoker.isChecked
        if(smoker) {
            premium += when (age) {
                0 -> 0
                1 -> 100
                2 -> 150
                3 -> 200
                4 -> 250
                else -> 300
            }
        } else premium+=0

        textViewPremium.text=getString(R.string.premium) + premium
    }

    fun resetInput(view: View?){
        //TODO clear all inputs and outputs

    }

}
