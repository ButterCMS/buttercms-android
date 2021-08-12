package com.example.buttercms.ui.main.blog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buttercms.model.Blog
import com.example.buttercms.network.BlogApiCallService
import retrofit2.await

class BlogViewModel : ViewModel() {

    private val apiResponseBlog by lazy { MutableLiveData<List<Blog>>() }

    fun getData(): MutableLiveData<List<Blog>> = apiResponseBlog

    suspend fun loadData() {
        val getBlogList = BlogApiCallService.data.getBlogs()
        val listResult = getBlogList.await()
        apiResponseBlog.postValue(listResult.blogs)
    }
}