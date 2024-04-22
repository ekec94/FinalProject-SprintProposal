package com.example.finalproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat


class Activity4 : AppCompatActivity() {

    private var proteinChTV: CheckedTextView? = null
    private var proteinRG: RadioGroup? = null
    private var beefRB: RadioButton? = null
    private var chickenRB: RadioButton? = null
    private var fishRB: RadioButton? = null
    private var porkRB: RadioButton? = null

    private var carbChTV: CheckedTextView? = null
    private var carbRG: RadioGroup? = null
    private var noodleRB: RadioButton? = null
    private var riceRB: RadioButton? = null

    private var time: EditText? = null

    private var calorieSW: SwitchCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // display title of activity page
        supportActionBar!!.title = "Filter the Recipes"
        // allow the user to return to main activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // view variables
        proteinChTV = findViewById(R.id.idProteinChTV)
        beefRB = findViewById(R.id.idProteinBeefRB)
        chickenRB = findViewById(R.id.idProteinChickenRB)
        fishRB = findViewById(R.id.idProteinFishRB)
        porkRB = findViewById(R.id.idProteinPorkRB)

        carbChTV = findViewById(R.id.idAdditionalChTV)
        noodleRB = findViewById(R.id.idCarbNoodlesRB)
        riceRB = findViewById(R.id.idCarbRiceRB)

        time = findViewById(R.id.idTimeEV)

        calorieSW = findViewById(R.id.idCalorieSW)

        val filterBtn: Button = findViewById(R.id.idFilterBTN)

        // calorie switch
        var lowCalorie: Boolean? = null
        calorieSW!!.setOnCheckedChangeListener { _, isChecked ->
            lowCalorie = isChecked
        }

        // button listener
        filterBtn.setOnClickListener {
            var proteinTxt = ""
            var protein = 0

            var carbTxt = ""
            var carb = 0


            var radioBtn: RadioButton
            val intent = Intent(this@Activity4, MainActivity::class.java)

            carbRG = findViewById(R.id.idCarbGroup)
            proteinRG = findViewById(R.id.idProteinGroup)

            if (proteinChTV!!.isChecked) {
                protein = proteinRG!!.checkedRadioButtonId
                radioBtn = findViewById(protein)

                proteinTxt = radioBtn.text.toString()
            }

            if (carbChTV!!.isChecked) {
                carb = carbRG!!.checkedRadioButtonId
                radioBtn = findViewById(carb)

                carbTxt = radioBtn.text.toString()
            }

            if (carbRG!!.checkedRadioButtonId != -1) carbChTV!!.requestFocus()


            // time edit text
            val timeInt = time!!.text.toString()
            if (timeInt.isNotEmpty()){
                intent.putExtra("Time", timeInt.toInt())
            }
            if (timeInt.isEmpty()){
                intent.putExtra("Time", 0)
            }

            if (radioCheck(protein, carb)) {
                // intent to next screen
                intent.putExtra("Protein", proteinTxt)
                intent.putExtra("Carb", carbTxt)
                intent.putExtra("LowCalorie", lowCalorie)

                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Please Check Selections", Toast.LENGTH_LONG).show()
            }

        }
        beefRB!!.setOnCheckedChangeListener { _, _ ->
            beefRB!!.error = null
            chickenRB!!.error = null
            fishRB!!.error = null
            porkRB!!.error = null
        }

        chickenRB!!.setOnCheckedChangeListener { _, _ ->
            beefRB!!.error = null
            chickenRB!!.error = null
            fishRB!!.error = null
            porkRB!!.error = null
        }

        fishRB!!.setOnCheckedChangeListener { _, _ ->
            beefRB!!.error = null
            chickenRB!!.error = null
            fishRB!!.error = null
            porkRB!!.error = null
        }

        porkRB!!.setOnCheckedChangeListener { _, _ ->
            beefRB!!.error = null
            chickenRB!!.error = null
            fishRB!!.error = null
            porkRB!!.error = null
        }

        noodleRB!!.setOnCheckedChangeListener { _, _ ->
            noodleRB!!.error = null
            riceRB!!.error = null
        }

        riceRB!!.setOnCheckedChangeListener { _, _ ->
            noodleRB!!.error = null
            riceRB!!.error = null
        }

        proteinChTV!!.setOnClickListener{
            if (proteinChTV!!.isChecked){
                enableDisable(proteinChTV, beefRB, chickenRB, fishRB, porkRB, Color.WHITE, false )
            } else{
                enableDisable(proteinChTV, beefRB, chickenRB, fishRB, porkRB, Color.GRAY, true)
            }
        }

        carbChTV!!.setOnClickListener{
            if (carbChTV!!.isChecked){
                enableDisable(carbChTV, noodleRB, riceRB, null, null, Color.WHITE, false )
            } else{
                enableDisable(carbChTV, noodleRB, riceRB, null, null, Color.GRAY, true)
            }
        }
    }
    private fun radioCheck(
        protein: Int,
        carb: Int
        )
            : Boolean {
        if (protein == -1){
            proteinChTV?.requestFocus()
            beefRB!!.error = "Please select protein or un-check check view"
            return false
        }
        if (carb  == -1){
            carbChTV?.requestFocus()
            noodleRB!!.error = "Please select addition or un-check check view"
            return false
        }
        return true
    }

    private fun enableDisable(
        chTV: CheckedTextView?,
        rb1: RadioButton?,
        rb2: RadioButton?,
        rb3: RadioButton?,
        rb4: RadioButton?,
        bgColor: Int?,
        state: Boolean){

        chTV!!.isChecked = state
        chTV.setBackgroundColor(bgColor!!)
        rb1!!.isEnabled = state
        rb2!!.isEnabled = state
        if(rb3 != null) rb3.isEnabled = state
        if(rb4 != null) rb4.isEnabled = state

        rb1.isChecked = state

        if (!state) rb1.isChecked
    }
}
