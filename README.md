# SpringBoot-Caching

- Ehcache

- Redis

- hazelcast

- Infinispan

### Annotation 

- <b>@Cacheable</b> : This annotation is used to tell that we are storing this method data into cache. We define a name for cache for uniquely identify cache.
- <b>@CacheEvict</b> : This annotaion is used to remove value from cache
- <b>@CachePut</b> : This annotaion is used to add or update the cache data.
- <b>@CacheConfig</b> :  This annotation is used to enable the cache at class level.
- <b>@Caching</b> : This annotation is used at method level with multiple annotaion of same type

### Reference

- https://www.javadream.in/spring-boot-cache-tutorial-with-example/
