package com.example.pokemoncards

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemoncards.model.Card
import com.example.pokemoncards.model.CardCollection
import com.example.pokemoncards.networking.PokemonCardsApi
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://docs.pokemontcg.io/
class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.card_list)
        list.layoutManager = GridLayoutManager(this, 3)
        list.adapter = CardAdapter()

        PokemonCardsApi.cardsApi.getAllCards().enqueue(object : Callback<CardCollection> {
            override fun onFailure(call: Call<CardCollection>, t: Throwable) {
                Log.d("DELETE_THIS", "Error - " + t.message)
            }

            override fun onResponse(call: Call<CardCollection>, response: Response<CardCollection>) {
                (findViewById<RecyclerView>(R.id.card_list).adapter as? CardAdapter)?.updateData(response.body()?.cards ?: emptyList())
            }

        })
    }

    class CardViewHolder(view: View): RecyclerView.ViewHolder(view)

    class CardAdapter : RecyclerView.Adapter<CardViewHolder>() {

        private val data: ArrayList<Card> = ArrayList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
            return CardViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
            Picasso.get().load(data[position].imageUrl).into(holder.itemView.findViewById<ImageView>(R.id.card_image_view))
        }

        override fun getItemCount() = data.size

        fun updateData(cardList: List<Card>) {
            data.clear()
            data.addAll(cardList)
            notifyDataSetChanged()
        }

    }
}
