package camp.codelab.anime

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import camp.codelab.anime.models.Anime
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_anime.view.*

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    val animeList: List<Anime>

    constructor(animeList: List<Anime>) {
        this.animeList = animeList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {
        val anime = animeList[position]
        viewHolder.setAnime(anime)
    }

    inner class AnimeViewHolder : RecyclerView.ViewHolder {

        val view: View

        constructor(view: View) : super(view) {
            this.view = view

            this.view.setOnClickListener {

                val anime = animeList[layoutPosition]
                val url = anime.url

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                it.context.startActivity(intent)

            }

        }

        fun setAnime(anime: Anime) {
            view.titleTextView.text = anime.title
            view.synopsisTextView.text = anime.synopsis

            Picasso.get()
                .load(anime.imageURL)
                .into(view.animeImageView)
        }

    }

}