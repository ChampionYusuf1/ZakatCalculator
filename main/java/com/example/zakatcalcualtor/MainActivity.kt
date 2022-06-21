 package com.example.zakatcalcualtor


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

 // editextdecimal number one is for income
 //edittextdecimal2 is for assets
 //edittextdecimal3 is for properties
 //edittextdeciaml 4 is for debts/loans
 // (income + assets + properties - debts/loans) * 0.025 = zakat
class MainActivity : AppCompatActivity() {
    private lateinit var etIncome: EditText
    private lateinit var etAssets: EditText
    private lateinit var etProperties: EditText
    private lateinit var etDebtsnLoans: EditText
    private lateinit var etZakat : TextView
    private var test = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener{
                    test = ((computeZakat()+computeZakat2()+computeZakat3()-computeZakat4())*0.025).toInt()
                    etZakat.text = test.toString()
        }
        etIncome = findViewById(R.id.editTextNumberDecimal)
        etAssets = findViewById(R.id.editTextNumberDecimal2)
        etProperties = findViewById(R.id.editTextNumberDecimal3)
        etDebtsnLoans = findViewById(R.id.editTextNumberDecimal4)
        etZakat = findViewById(R.id.textView7)


        etIncome.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            computeZakat()
            }

        })
        etAssets.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                computeZakat2()
            }

        })
        etProperties.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                computeZakat3()
            }

        })
        etDebtsnLoans.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                
                computeZakat4()
            }

        })

        //test = computeZakat() + computeZakat2() + computeZakat3() + computeZakat4()
        //etZakat.text = test.toString()



    }
     private fun computeZakat(): Int {
         //if(etIncome.text.toString().isEmpty()){}
         var income =  etIncome.text.toString().toInt() * 0.025
         //var assets = etAssets.text.toString().toDouble()
         //var properties = etProperties.text.toString().toDouble()
         //var debts = etDebtsnLoans.text.toString().toDouble()
         return income.roundToInt()
     }
     private fun computeZakat2(): Int {
         //var income =  etIncome.text.toString().toInt()
         var assets = etAssets.text.toString().toInt()
         //var properties = etProperties.text.toString().toDouble()
         //var debts = etDebtsnLoans.text.toString().toDouble()
         return assets
     }
     private fun computeZakat3(): Int {
         //var income =  etIncome.text.toString().toInt()
         //var assets = etAssets.text.toString().toInt()
         var properties = etProperties.text.toString().toInt()
         //var debts = etDebtsnLoans.text.toString().toDouble()
         return properties
     }
     private fun computeZakat4(): Int {
         //var income =  etIncome.text.toString().toInt()
         //var assets = etAssets.text.toString().toInt()
         //var properties = etProperties.text.toString().toInt()
         var debts = etDebtsnLoans.text.toString().toInt()
         return debts
     }

}//