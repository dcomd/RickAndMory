package com.demo.android.alexandre.rickandmortycardapp.ui.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.demo.android.alexandre.rickandmortycardapp.R
import com.demo.android.alexandre.rickandmortycardapp.data.model.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class CharacterAdpater: RecyclerView.Adapter<CharacterAdpater.CharacterViewHolder>() {

    private var listCharacters = emptyList<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacters[position])

        holder.itemView.setOnClickListener { view ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(listCharacters[position])
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    fun setCharacters(characters: List<Character>){
        listCharacters = characters
        notifyDataSetChanged()
    }

    class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imageCharacter: ImageView = itemView.character_img
        var statusType: TextView = itemView.txt_status
        var idNumber: TextView = itemView.txt_id_character
        var nameCharacter: TextView = itemView.txt_name_character

        fun bind(character: Character){
            Picasso.get().load(character.image).into(imageCharacter)
            statusType.text = character.status
            idNumber.text = character.id.toString()
            nameCharacter.text = character.name
        }
    }

}