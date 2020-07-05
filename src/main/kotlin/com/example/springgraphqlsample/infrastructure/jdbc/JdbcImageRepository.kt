package com.example.springgraphqlsample.infrastructure.jdbc

import com.example.springgraphqlsample.domain.Image
import com.example.springgraphqlsample.domain.ImageRepository
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class JdbcImageRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) : ImageRepository {

    private val rowMapper: RowMapper<Image> = RowMapper { rs, _ ->
        Image(
                id = rs.getString("id"),
                url = rs.getString("url")
        )
    }

    override fun getImage(id: String): Image? {
        if (id.isEmpty()) return null
        //language=SQL
        return jdbcTemplate.query(
                """
                SELECT
                  id,
                  url
                FROM
                  IMAGE
                WHERE
                  id = :id
                """.trimIndent(), mapOf("id" to id), rowMapper
        ).firstOrNull()
    }
    override fun getImages(): List<Image> {
        //language=SQL
        return jdbcTemplate.query(
                """
                SELECT
                  id,
                  url
                FROM
                  IMAGE               
                """.trimIndent(), rowMapper
        )
    }
}