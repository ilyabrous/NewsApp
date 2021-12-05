package com.project.mvvmnewsapp.model.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.mvvmnewsapp.model.util.Article
import kotlinx.android.synthetic.main.item_article_preview.view.*
import project.mvvmnewsapp.R

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_article_preview, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]

        holder.itemView.apply {
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt
            tvSource.text = article.source.name

            Glide.with(this).load(article.urlToImage).into(ivArticleImage)

            setOnItemClickListener {
                onItemClickListener?.let { it(article)}
            }

        }
    }

    private var onItemClickListener: ( (Article) -> Unit )? = null

    fun setOnItemClickListener( listener : (Article) -> Unit ) {
        onItemClickListener = listener
    }

    inner class ArticleViewHolder(articleView : View) : RecyclerView.ViewHolder(articleView)
}