package com.example.springgraphqlsample.presentation.queryresolver

import com.example.springgraphqlsample.domain.Image
import org.springframework.stereotype.Component
import com.example.springgraphqlsample.service.ImageService
import graphql.kickstart.tools.GraphQLQueryResolver

@Component
class DrugQueryResolver(val imageService: ImageService) : GraphQLQueryResolver {
    fun image(id: String): Image? = imageService.getImage(id)
    fun images(): List<Image> = imageService.getImages()
}