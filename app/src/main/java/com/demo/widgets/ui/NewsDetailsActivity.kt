package com.demo.widgets.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.widgets.databinding.ActivityNewsDetailsBinding
import com.demo.widgets.news.newsList

class NewsDetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NEWS_INDEX = "news_index"
        const val COMMON_REQUEST_CODE = 9527
    }

    private lateinit var binding: ActivityNewsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateNews()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        this.intent = intent
        populateNews()
    }

    private fun populateNews() {
        val index = this.intent?.getIntExtra(EXTRA_NEWS_INDEX, -1) ?: -1
        if (index >= 0) {
            val newsEntity = newsList[index]
            binding.tvTitle.text = newsEntity.title
            binding.tvContent.text = newsEntity.content
            binding.ivImg.setImageResource(newsEntity.imageId)
        } else {
            finish()
        }
    }
}
