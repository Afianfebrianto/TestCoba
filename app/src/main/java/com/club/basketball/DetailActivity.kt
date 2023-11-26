package com.club.basketball

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CLUB = "extra_club"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataClub = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("extra_club", Club::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_CLUB)
        }

        if (dataClub != null){
            val imgDetailPhoto: ImageView = findViewById(R.id.image_detail_photo)
            val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
            val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
            val tvDetailFaounded: TextView = findViewById(R.id.tv_detail_faunded)
            val tvDetailLocation: TextView = findViewById(R.id.tv_detail_location)


            tvDetailName.text = dataClub.name
            tvDetailDescription.text = dataClub.description
            imgDetailPhoto.setImageResource(dataClub.photo)
            tvDetailFaounded.text = dataClub.faounded
            tvDetailLocation.text = dataClub.location

        }
        val fab: View = findViewById(R.id.fab_share)
        fab.setOnClickListener{ view ->
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "{$dataClub}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }




    }
}