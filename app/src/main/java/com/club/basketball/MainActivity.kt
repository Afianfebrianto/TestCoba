package com.club.basketball

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var rv: RecyclerView
    private  val listClub = ArrayList<Club>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.club_rv)
        rv.setHasFixedSize(true)
        listClub.addAll(getListClub())
        showRecyclerList()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_about_page -> {
                val aboutPage = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutPage)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun getListClub(): ArrayList<Club> {
        val dataName = resources.getStringArray(R.array.data_club)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataFounded = resources.getStringArray(R.array.club_founded)
        val dataLocation = resources.getStringArray(R.array.club_location)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)


        val listClub = ArrayList<Club>()
        for (i in dataName.indices) {
            val club = Club(
                dataName[i],
                dataDescription[i],
                dataFounded[i],
                dataLocation[i],
                dataPhoto.getResourceId(i, -1)

            )
            listClub.add(club)
        }
        dataPhoto.recycle()
        return listClub
    }


    private fun getListFruit(): ArrayList<Club> {
        val dataName = resources.getStringArray(R.array.data_club)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataFaounded = resources.getStringArray(R.array.club_founded)
        val dataLocation = resources.getStringArray(R.array.club_location)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listClub = ArrayList<Club>()
        for (i in dataName.indices) {
            val club = Club(dataName[i], dataDescription[i],dataFaounded[i],dataLocation[i], dataPhoto.getResourceId(i, -1))
            listClub.add(club)
        }
        return listClub
    }

    private fun showRecyclerList() {
        rv.layoutManager = LinearLayoutManager(this)
        val listClubAdapter = ListClubAdapter(listClub)
        rv.adapter = listClubAdapter

       listClubAdapter.setOnItemClickCallback(object : ListClubAdapter.OnItemClickCallback {
          override fun onItemClicked(data: Club) {
              showSelectedClub(data)
           }
       })
    }
    private fun showSelectedClub(club: Club) {
        Toast.makeText(this, "Pilihan Kamu " + club.name, Toast.LENGTH_SHORT).show()
    }

}