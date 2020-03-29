
### Master-Slave Architecture

### Configure Redis Master

	port 6379
	tcp-backlog 511
	timeout 0
	tcp-keepalive 0
	loglevel notice
	logfile ""
	databases 16
	save 900 1
	save 300 10
	save 60 10000
	stop-writes-on-bgsave-error yes
	rdbcompression yes
	rdbchecksum yes
	dbfilename dump.rdb
	dir ./	
	slave-serve-stale-data yes
	slave-read-only yes
	repl-diskless-sync no
	repl-diskless-sync-delay 5
	repl-disable-tcp-nodelay no
	slave-priority 100
	requirepass foobared
	appendonly no
	appendfsync everysec
	no-appendfsync-on-rewrite no
	auto-aof-rewrite-percentage 100
	auto-aof-rewrite-min-size 64mb
	aof-load-truncated yes
	lua-time-limit 5000
	slowlog-max-len 128
	latency-monitor-threshold 0
	notify-keyspace-events ""
	hash-max-ziplist-entries 512
	hash-max-ziplist-value 64
	list-max-ziplist-entries 512
	list-max-ziplist-value 64
	set-max-intset-entries 512
	zset-max-ziplist-entries 128
	zset-max-ziplist-value 64
	hll-sparse-max-bytes 3000
	activerehashing yes
	client-output-buffer-limit normal 0 0 0
	client-output-buffer-limit slave 256mb 64mb 60
	client-output-buffer-limit pubsub 32mb 8mb 60
	hz 10
	aof-rewrite-incremental-fsync yes
	
	# include .\path\to\local.conf
	# include c:\path\to\other.conf
	# bind 192.168.1.100 10.0.0.1
	# bind 127.0.0.1
	# unixsocket /tmp/redis.sock
	# unixsocketperm 700
	# slaveof <masterip> <masterport>
	# masterauth <master-password>
	# repl-ping-slave-period 10
	# repl-timeout 60
	# repl-backlog-size 1mb
	# repl-backlog-ttl 3600
	# min-slaves-to-write 3
	# min-slaves-max-lag 10
	# rename-command CONFIG ""
	# maxclients 10000
	# maxheap <bytes>
	# heapdir <directory path(absolute or relative)>
	# maxmemory <bytes>
	# maxmemory-policy volatile-lru
	# maxmemory-samples 3
	# client-output-buffer-limit <class> <hard limit> <soft limit> <soft seconds>