package com.fungames.blockcrafw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MAg : AppCompatActivity() {
    lateinit var enemyPic: ImageView
    lateinit var playerPic: ImageView
    val choices = mutableListOf<String>("Bug", "Cat", "Ten")
    var playerscore = 0
    var enemyscore = 0
    lateinit var playerScoreText: TextView
    lateinit var enemyScoreText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mag)

        MaterialAlertDialogBuilder(this@MAg)
            .setTitle("Simple Rules")
            .setMessage("Bug defeats Ten, Cat defeats Bug, Ten defeats Cat")
            .setCancelable(false)
            .setPositiveButton("Play"){dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()

        enemyPic = findViewById(R.id.enemy_pic)
        playerPic = findViewById(R.id.player_pic)

        playerScoreText = findViewById(R.id.player_score_text)
        enemyScoreText = findViewById(R.id.enemy_score_text)

    }
    fun rock(v: View){
        playerPic.setImageResource(R.drawable.bug)
        val enemychoice = choices.random()
        when (enemychoice){
            "Bug" -> {enemyPic.setImageResource(R.drawable.bug)}

            "Cat" -> {enemyPic.setImageResource(R.drawable.cat)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()

            }

            "Ten" -> {enemyPic.setImageResource(R.drawable.ten)
                playerscore++
                playerScoreText.text = playerscore.toString()

            }

        }


    }

    fun paper(v: View){
        playerPic.setImageResource(R.drawable.cat)
        val enemychoice = choices.random()
        when (enemychoice){
            "Bug" -> {enemyPic.setImageResource(R.drawable.bug)
                playerscore++
                playerScoreText.text = playerscore.toString()}

            "Cat" -> {enemyPic.setImageResource(R.drawable.cat)}

            "Ten" -> {enemyPic.setImageResource(R.drawable.ten)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()}

        }
    }

    fun scissors(v: View) {
        playerPic.setImageResource(R.drawable.ten)
        val enemychoice = choices.random()
        when (enemychoice) {
            "Bug" -> {
                enemyPic.setImageResource(R.drawable.bug)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()
            }

            "Cat" -> {
                enemyPic.setImageResource(R.drawable.cat)
                playerscore++
                playerScoreText.text = playerscore.toString()
            }

            "Ten" -> {
                enemyPic.setImageResource(R.drawable.ten)
            }

        }
    }
}