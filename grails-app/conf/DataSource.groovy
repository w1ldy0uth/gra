dataSource {
    dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
    dbCreate = "update"
    url = "jdbc:h2:mem:testDb;DB_CLOSE_DELAY=-1"
}
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory'
    singleSession = true
    flush.mode = 'manual'
}

environments {
    development {
        dataSource {
            dbCreate = 'create-drop'
        }
    }
}
