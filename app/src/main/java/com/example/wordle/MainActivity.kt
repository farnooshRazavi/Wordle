package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
var counter = 0
val button = null
class MainActivity : AppCompatActivity() {
    private lateinit var wordToGuess: String
    private var countRound = 0
    private var streak = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wordToGuess = FourLetterWordList.getRandomFourLetterWord()

        val Button = findViewById<Button>(R.id.button)
        val Guess1 = findViewById<TextView>(R.id.textView)
        val Guess2 = findViewById<TextView>(R.id.textView3)
        val Guess3 = findViewById<TextView>(R.id.textView5)
        val guess1ch = findViewById<TextView>(R.id.textView2)
        val guess2ch = findViewById<TextView>(R.id.textView4)
        val guess3ch = findViewById<TextView>(R.id.textView6)
        val word1 = findViewById<TextView>(R.id.check1)
        val word1ch = findViewById<TextView>(R.id.check2)
        val word2 = findViewById<TextView>(R.id.check3)
        val word2ch = findViewById<TextView>(R.id.check4)
        val word3 = findViewById<TextView>(R.id.check5)
        val word3ch = findViewById<TextView>(R.id.check6)
        val TheWord = findViewById<TextView>(R.id.WordToGuessShow)
        val simpleEditText = findViewById<EditText>(R.id.wordInput)
        /**
         * Parameters / Fields:
         *   wordToGuess : String - the target word the user is trying to guess
         *   guess : String - what the user entered as their guess
         *
         * Returns a String of 'O', '+', and 'X', where:
         *   'O' represents the right letter in the right place
         *   '+' represents the right letter in the wrong place
         *   'X' represents a letter not in the target word
         */
        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }

        Button.setOnClickListener {
            val strValue = simpleEditText.text.toString().uppercase()
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            counter ++
            if (counter == 1) {
                word1.text = strValue
                word1.visibility = View.VISIBLE
                word1ch.text = word1.toString()
                word1ch.text = checkGuess(strValue)
                simpleEditText.text.clear()

            }
            if (counter == 2) {
                word2.text = strValue
                word2.visibility = View.VISIBLE
                word2ch.text = word2.toString()
                word2ch.text = checkGuess(strValue)
                simpleEditText.text.clear()

            }
            if (counter == 3) {
                word3.text = strValue
                word3.visibility = View.VISIBLE
                word3ch.text = word3.toString()
                word3ch.text = checkGuess(strValue)
                simpleEditText.text.clear()


            }
            if (counter > 3){

                Toast.makeText(this, "No more tries!", Toast.LENGTH_SHORT).show()
                TheWord.visibility = View.VISIBLE


            }
        }





        }
    }
