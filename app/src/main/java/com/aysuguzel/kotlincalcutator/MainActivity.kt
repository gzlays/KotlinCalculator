package com.aysuguzel.kotlincalcutator

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SharedMemory
import android.view.View
import com.aysuguzel.kotlincalcutator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //uygulamaıyı kapatsak bile verileri silinmez
        //SharedPreference - xml - key-value
        sharedPref = this.getSharedPreferences("com.aysuguzel.kotlincalcutator", MODE_PRIVATE)


        //sonucun kaydetmek için;
        val userSonuc = sharedPref.getInt("sonuç:",-1)

        if(userSonuc == -1){ //eğer değer yeri boşsa
            binding.sonuc.text = "sonuç:"

        }else{
            binding.sonuc.text = "sonuç:${userSonuc}"

        }
    }





        fun topla(view: View) {

            val number1= binding.editText1.text.toString().toDoubleOrNull()
            val number2 = binding.editText2.text.toString().toDoubleOrNull()


            if(number1 !=null && number2 != null) {
                val result = number1 + number2
                binding.sonuc.text = "Sonuç: ${result}"

                sharedPref.edit().putInt("sonuc",result.toInt()).apply()

                 }else {
                   binding.sonuc.text = "Enter number!"

            }


        }

        fun cıkar(view: View){
            val number1 = binding.editText1.text.toString().toDoubleOrNull()
            val number2 = binding.editText2.text.toString().toDoubleOrNull()

            if(number1 != null && number2 !=null){
                val result= number1 - number2
                binding.sonuc.text = "Sonuç: ${result}"

            }else{
                binding.sonuc.text = "Enter number!"

            }


        }


        fun carp(view:View){
            val number1= binding.editText1.text.toString().toDoubleOrNull()
            val number2 = binding.editText2.text.toString().toDoubleOrNull()

            if(number1 !=null && number2 !=null){
                val result = number1 * number2
                 binding.sonuc.text = "sonuç: ${result}"

            }else{
                binding.sonuc.text = "enter number!"
            }
        }

        fun bol(view:View){

            val number1 = binding.editText1.text.toString().toDoubleOrNull()
            val number2 = binding.editText2.text.toString().toDoubleOrNull()


            if(number1 != null && number2 != null){
                val result = number1 / number2
                binding.sonuc.text = "sonuç: ${result}"

            }else{
                binding.sonuc.text = "enter an number"
            }
        }


    fun clear (view:View){



        binding.editText1.text.clear()
        binding.editText2.text.clear()

        binding.sonuc.text = "Sonuç: "

    }


}


