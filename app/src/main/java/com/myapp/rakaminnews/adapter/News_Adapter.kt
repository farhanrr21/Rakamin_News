package com.myapp.rakaminnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapp.rakaminnews.R
import com.myapp.rakaminnews.model.Article


class News_Adapter : RecyclerView.Adapter<News_Adapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(item: View) : RecyclerView.ViewHolder(item){
        var ivListNews = item.findViewById<ImageView>(R.id.iv_list_news)
        var tvTitle = item.findViewById<TextView>(R.id.tvTitle)
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val diff = AsyncListDiffer(this,diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_home,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = diff.currentList[position]
        holder.itemView.apply {
            Glide.with(this)
                .load(article.urlToImage)
                .into(holder.ivListNews)


            setOnItemClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
        holder.tvTitle.text = article.title

    }

    override fun getItemCount(): Int {
        return diff.currentList.size
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}