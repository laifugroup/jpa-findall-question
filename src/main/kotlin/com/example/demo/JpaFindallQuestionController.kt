package com.example.demo

import com.example.demo.domain.po.LuckPlatformPO
import com.example.demo.repo.PlatformRepo
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification
import io.micronaut.data.runtime.criteria.SelectQuery
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import jakarta.persistence.criteria.Predicate
import org.hibernate.query.Page
import java.time.LocalDateTime

@Controller("/jpa")
class JpaFindallQuestionController(private val platformRepo: PlatformRepo) {

    @Get(uri="/v1/index")
    fun index(): io.micronaut.data.model.Page<LuckPlatformPO> {
        val save=platformRepo.save(LuckPlatformPO(groupId = 1, groupName = "zz"))
        println(save)

        val spec= toSpecification<LuckPlatformPO>(save)
        //org.hibernate.sql.ast.SqlTreeCreationException: Could not locate TableGroup
       val result= platformRepo.findAll(spec, Pageable.from(0, 10))
        return result
    }

    fun <T : LuckPlatformPO> toSpecification(entity: T): PredicateSpecification<T> {
        val predicateList = mutableListOf<Predicate>()
        val predSpec = PredicateSpecification<T> { root, builder ->
            val pathString = root.get<String>("id")
            predicateList.add(builder.equal(pathString, 1))
            val predicate=predicateList.toTypedArray()
            builder.createQuery().where(*predicate).restriction
        }
        return predSpec
    }


}