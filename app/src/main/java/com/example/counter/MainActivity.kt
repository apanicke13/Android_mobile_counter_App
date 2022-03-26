package com.example.counter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var numberText: TextView
    private lateinit var numberinput: EditText
    private lateinit var interval: EditText
    private lateinit var summary: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton: Button = findViewById(R.id.button_main_Activity)
        val randomButton: Button = findViewById(R.id.randombt)
        val incrementButton: Button = findViewById(R.id.act_main_increment)
        val decrementButton: Button = findViewById(R.id.act_main_bt_decrement)

        submitButton.setOnClickListener{ submitNumber() }
        randomButton.setOnClickListener{ generateRandomNumber() }
        incrementButton.setOnClickListener{ changenumber("+") }
        decrementButton.setOnClickListener{ changenumber("-") }

        numberText = findViewById(R.id.a_m_t_v_n)
        numberinput = findViewById(R.id.main_activity_number_ip)
        interval = findViewById(R.id.act_main_interval)
        summary = findViewById(R.id.main_act_summary)
    }

    private fun submitNumber(){

        var startingno = numberinput.text.toString()
        if (startingno == ""){
            startingno = "10"
        }

        numberText.text = startingno
        numberinput.setText("")

        hidekeyboard()

    }

    private fun generateRandomNumber(){

        val randomno = (-100..100).random()
        numberText.text = randomno.toString()

    }

    private fun changenumber(operation: String){

        val currentnumber = numberText.text.toString().toInt()
        var incrementvalue = interval.text.toString()

        if (incrementvalue == ""){
            incrementvalue= "1"
        }

        if (operation=="+"){

            val newnumber = currentnumber + incrementvalue.toInt()
            numberText.text = newnumber.toString()

            summary.text = "$currentnumber + $incrementvalue = $newnumber"

        } else {

            val newnumber = currentnumber - incrementvalue.toInt()
            numberText.text = newnumber.toString()

            summary.text = "$currentnumber - $incrementvalue = $newnumber"

        }

        hidekeyboard()
    }


    private fun hidekeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(numberText.windowToken, 0 )
    }
}