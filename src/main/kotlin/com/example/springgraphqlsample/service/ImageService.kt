package com.example.springgraphqlsample.service

import com.example.springgraphqlsample.domain.Image
import com.example.springgraphqlsample.domain.ImageRepository
import org.springframework.stereotype.Service

@Service
class ImageService(private val repository: ImageRepository) {
    fun getImage(id: String): Image? = repository.getImage(id)
    fun getImages(): List<Image> = repository.getImages()
}