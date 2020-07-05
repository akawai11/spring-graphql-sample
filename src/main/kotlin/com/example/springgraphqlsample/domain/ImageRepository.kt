package com.example.springgraphqlsample.domain

interface ImageRepository {
    fun getImage(id: String): Image?
    fun getImages(): List<Image>
}