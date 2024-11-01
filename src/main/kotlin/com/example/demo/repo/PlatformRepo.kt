package com.example.demo.repo

import com.example.demo.domain.po.LuckPlatformPO
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.PageableRepository
import io.micronaut.data.repository.jpa.JpaSpecificationExecutor
@Repository
interface  PlatformRepo: JpaSpecificationExecutor<LuckPlatformPO>, PageableRepository<LuckPlatformPO, Long> {
}