package com.example.hejkonpejkon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {  //Påbörjat kortspelsapp

    lateinit var imageView: ImageView  //Deklarar här en variabel som heter imageView- där jag visar korten
    lateinit var buttonLow: Button
    lateinit var buttonHigh: Button //Deklarar här en variabel som heter buttonHigh typ "button"
    var currentCardNumber: Int = 0
    var nextCardNumber: Int = 0 //Deklarar och initierar här en variabel som heter som heter int.
    // Variabeln har värdet på nästa kort
    var points: Int = 0
    lateinit var showPoints: TextView
    lateinit var buttonGoBack: Button
    var deck = mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        createDeck() //I am calling a function here

        imageView = findViewById<ImageView>(R.id.imageView) //Initierar variabeln imageView, dvs ger ett värde, jag vill att denna variebel ska peka mot komponent Komplicerat
        currentCardNumber = setRandomCard().value // Calling a fun. DU kommer använda koden som är innanför funktionen SetRandomCard
        buttonLow = findViewById(R.id.buttonLow) //variabeln ska peka mot komponenten UI som heter bottonLow
        buttonHigh = findViewById(R.id.buttonHigh)
        showPoints = findViewById(R.id.showPoints)
        buttonGoBack = findViewById(R.id.buttonGoBack)

        buttonLow.setOnClickListener() {
            handleButtonLow() //I am calling a function here. Metoden som används när användaren klickar på knappen "buttonLow"
        }
        buttonHigh.setOnClickListener {
            handleButtonHigh() //Metoden som används när användaren klickar på knappen "buttonHigh"
        }
        buttonGoBack.setOnClickListener() {
            handleGoBackButton()
        }
    }

    fun handleButtonHigh() {
        nextCardNumber = (0..(deck.size -1)).random()

        if(nextCardNumber >= currentCardNumber) {
            points = points +100
            showPoints.text = "Points $points"

        }
        currentCardNumber = nextCardNumber

        val card =deck.get(currentCardNumber)
        imageView.setImageResource(card.image)

        if (points >= 1000) {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }
    }

    fun handleButtonLow() {
        nextCardNumber = (0..(deck.size -1)).random() /// get a new random card from deck

        if ( nextCardNumber <= currentCardNumber) {
            points = points + 100 // points += 100 -poängen höjs med 100
            //textViewPoints.text = points.toString()// need to convert int to string given textView can only show strings
            showPoints.text = "Points: $points" //Att poängen syns på skärmen!!

            Log.d("Correct!", "currentCardNumber $currentCardNumber - nextCardNumber $nextCardNumber")
        } else {  //Detta ser bara jag i loggen
            Log.d("Wrong!", "currentCardNumber $currentCardNumber - nextCardNumber $nextCardNumber")
        }

        Log.d("Points!", "points $points") // show points in a component on the ui-visa på skärmen som bara jag ser

        currentCardNumber = nextCardNumber
        //show on screen next card, nedan:

        val card = deck.get(currentCardNumber)
        imageView.setImageResource(card.image)

        if (points >= 1000) {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }
    }


    fun setRandomCard() : Card {
        val randomCardNumber = (0..(deck.size -1)).random()//=för att få ett random kort från korstspelet, måste skriva så
        val card = deck.get(randomCardNumber) //= we get random card from the deck
        imageView.setImageResource(card.image)

        return card
    }

    fun handleGoBackButton() {
      val intent = Intent(this, MainActivity3::class.java)
      startActivity(intent)
    }

    fun createDeck(){
        deck.add(Card("tiles", 1, R.drawable.one_tiles))
        deck.add(Card("tiles", 2, R.drawable.two_tiles))
        deck.add(Card("tiles", 3, R.drawable.three_tiles))
        deck.add(Card("tiles", 4, R.drawable.four_tiles))

        deck.add(Card("pikes", 2, R.drawable.two_pikes))
        deck.add(Card("pikes", 5, R.drawable.five_pikes))
        deck.add(Card("pikes", 6, R.drawable.six_pikes))
        deck.add(Card("pikes", 7, R.drawable.seven_pikes))
        deck.add(Card("pikes", 8, R.drawable.eight_pikes))
        deck.add(Card("pikes", 10, R.drawable.ten_pikes))
        deck.add(Card("pikes", 12, R.drawable.queen_pikes))

        deck.add(Card("clovers", 7, R.drawable.seven_clovers))
        deck.add(Card("clovers", 9, R.drawable.nine_clovers))
        deck.add(Card("clovers", 11, R.drawable.jack_clovers))
        deck.add(Card("clovers", 13, R.drawable.king_clovers))


        deck.add(Card("hearts", 1, R.drawable.one_hearts))
        deck.add(Card("hearts", 3, R.drawable.three_hearts))
        deck.add(Card("hearts", 5, R.drawable.five_hearts))
        deck.add(Card("hearts", 10, R.drawable.ten_hearts))
    }
}

